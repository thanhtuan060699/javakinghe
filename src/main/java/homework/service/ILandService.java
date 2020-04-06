package homework.service;

import java.util.List;

import homework.builder.LandSearchBuilder;
import homework.dto.LandDTO;

public interface ILandService {
	List<LandDTO> findAll(LandSearchBuilder landSearchBuilder);
	List<LandDTO> findAll();
	void save(LandDTO landDTO);
}
