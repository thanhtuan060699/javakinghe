package homework.converter;

import org.modelmapper.ModelMapper;

import homework.dto.LandDTO;
import homework.entity.LandEntity;

public class LandConverter {
 public LandDTO convertToDTO(LandEntity entity) {
	 ModelMapper modelMapper=new ModelMapper();
	 LandDTO dto=modelMapper.map(entity, LandDTO.class);
	 return dto;
 }
 public LandEntity convertToEntity(LandDTO dto) {
	 ModelMapper modelMapper=new ModelMapper();
	 LandEntity entity=modelMapper.map(dto, LandEntity.class);
	 return entity;
 }
}
