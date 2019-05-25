package edu.zut.cs.software.navigation.admin.map;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import edu.zut.cs.software.navigation.admin.map.dao.PlaceDao;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;


public class PlaceDaoTest extends GenericDaoTestCase<Long, Place, PlaceDao>{

	private static final Logger logger = LogManager.getLogger(PlaceDaoTest.class.getName());
	
	@Autowired
	PlaceDao placeDao;
	
	@Test
	public void testFindAll() {
		
		List<Place> all = this.placeDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<place> all={}", all); 
		}	
	}
}
