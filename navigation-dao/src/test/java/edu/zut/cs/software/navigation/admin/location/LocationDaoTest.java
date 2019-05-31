package edu.zut.cs.software.navigation.admin.location;

import edu.zut.cs.software.navigation.admin.map.PlaceDaoTest;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.location.dao.LocationsDao;
import edu.zut.cs.software.navigation.admin.location.domain.Locations;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

public class LocationDaoTest extends GenericDaoTestCase<Long, Locations, LocationsDao>{

private static final Logger logger = LogManager.getLogger(PlaceDaoTest.class.getName());
	
	@Autowired
	LocationsDao locationsDao;
	
	@Test
	public void testFindAll() {
		
		List<Locations> all = this.locationsDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<locations> all={}", all); 
		}	
	}
}
