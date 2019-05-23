package edu.zut.cs.software.navigation.admin.road;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.zut.cs.software.navigation.admin.road.dao.RoadDao;
import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

@SuppressWarnings("hiding")
public class RoadDaoTest<RoadDao> extends GenericDaoTestCase<Long, Road, edu.zut.cs.software.navigation.admin.road.dao.RoadDao>{
	
	@Autowired
	RoadDao roadDao;
	private static final Logger logger = LogManager.getLogger(edu.zut.cs.software.navigation.admin.road.dao.RoadDao.class.getName());
	public void setRoadDao(RoadDao roadDao) {
		this.roadDao = roadDao;
		this.dao = (edu.zut.cs.software.navigation.admin.road.dao.RoadDao) this.roadDao;
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll() {
		List<Road> all = ((JpaRepository<Road, Long>) this.roadDao).findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<road> all={}", all); 
		}
	}
}

