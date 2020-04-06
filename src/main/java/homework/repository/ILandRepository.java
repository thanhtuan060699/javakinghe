package homework.repository;

import java.util.List;

import homework.entity.LandEntity;

public interface ILandRepository {
	public List<LandEntity> findAll();
	public void save(LandEntity landEntity);

}
