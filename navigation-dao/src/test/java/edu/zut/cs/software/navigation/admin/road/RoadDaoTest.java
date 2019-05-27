package edu.zut.cs.software.navigation.admin.road;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.zut.cs.software.navigation.admin.road.dao.RoadDao;
import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.dao.GenericTreeDaoTestCase;

public class RoadDaoTest extends GenericTreeDaoTestCase<Long, Road, RoadDao>{
	
	@Autowired
	RoadDao roadDao;
	private static final Logger logger = LogManager.getLogger(RoadDaoTest.class.getName());
	public void setRoadDao(RoadDao roadDao) {
		this.roadDao = roadDao;
		this.dao =  this.roadDao;
	}
	@Test
	public void testFindAll() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Road road = new Road();
			road.setname("road_" + i);
			for(int j = 0; j < 10; j++) {
				Road r = new Road();
				r.setname("road_" + i + "_" + j);
				r.setParent(road);
			}
			this.roadDao.save(road);
		}
		List<Road> all = ((JpaRepository<Road, Long>) this.roadDao).findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<road> all={}", all);
		}
	}
}
