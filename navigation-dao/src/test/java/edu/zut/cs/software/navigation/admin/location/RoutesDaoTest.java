package edu.zut.cs.software.navigation.admin.location;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.location.dao.RoutesDao;
import edu.zut.cs.software.navigation.admin.location.domain.Routes;
import edu.zut.cs.software.navigation.admin.map.MapDaoTest;
import edu.zut.cs.software.navigation.base.dao.GenericTreeDaoTestCase;

public class RoutesDaoTest extends GenericTreeDaoTestCase<Long, Routes, RoutesDao>{

private static final Logger logger = LogManager.getLogger(MapDaoTest.class.getName());



    RoutesDao routesDao;

	@Autowired
	public void setMapDao(RoutesDao routesDao) {
		this.routesDao = routesDao;
		this.dao = this.routesDao;
	}
	
	@Test
	public void testGetRoot() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Routes routes = new Routes();
			routes.setName("routes_" + i);
			for(int j = 0; j < 10; j++) {
				Routes m = new Routes();
				m.setName("routes_" + i + "_" + j);
				m.setParent(routes);
			}
			this.routesDao.save(routes);
		}
		
		List<Routes> roots = this.routesDao.getRoot();
		assertEquals(root_size, roots.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Routes> roots={}", roots); 
		}

		
	}
}
