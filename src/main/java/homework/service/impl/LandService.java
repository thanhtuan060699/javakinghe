package homework.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;

import homework.builder.LandSearchBuilder;
import homework.converter.LandConverter;
import homework.dto.LandDTO;
import homework.entity.LandEntity;
import homework.repository.ILandRepository;
import homework.repository.impl.LandRepository;
import homework.service.ILandService;

public class LandService implements ILandService {
	ILandRepository landRepository=new LandRepository();
	LandConverter converter=new LandConverter();

	public List<LandDTO> findAll(LandSearchBuilder landSearchBuilder) {
		Map<String, Object> properties=convertToMapProperties(landSearchBuilder);
		return null;
	}

	private Map<String, Object> convertToMapProperties(LandSearchBuilder landSearchBuilder) {
		Map<String,Object> properties=new HashMap<String, Object>();
		try {
			Field[] fields=LandSearchBuilder.class.getDeclaredFields();
			for(Field field:fields) {
				field.setAccessible(true);
				properties.put(field.getName().toLowerCase(), field.get(landSearchBuilder));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return properties;
	}

	@Override
	public List<LandDTO> findAll() {
		List<LandEntity> landEntities=landRepository.findAll();
		return landEntities.stream().map(item->converter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public void save(LandDTO landDTO) {
		LandEntity landEntity=converter.convertToEntity(landDTO);
		landRepository.save(landEntity);
		
	}
	
}
