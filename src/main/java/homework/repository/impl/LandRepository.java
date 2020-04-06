package homework.repository.impl;

import java.util.List;

import homework.entity.LandEntity;
import homework.repository.ILandRepository;

public class LandRepository extends SimpleJpaRepository<LandEntity> implements ILandRepository {

	@Override
	public List<LandEntity> findAll() {
		String sql="select * from land";
		List<LandEntity> landEntities= this.findAll(sql);
		return landEntities;
	}

	@Override
	public void save(LandEntity landEntity) {
		this.insert(landEntity);
		
	}

	

}
