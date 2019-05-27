package edu.zut.cs.software.navigation.admin.road;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.road.dao.RouteDao;
import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.admin.road.domain.Route;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

public class RouteDaoTest extends GenericDaoTestCase<Long, Route, RouteDao>{
	
	
	@Autowired
	RouteDao routeDao;
	private static final Logger logger = LogManager.getLogger(RouteDaoTest.class.getName());
	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
		this.dao =  this.routeDao;
	}
	@Test
    public void testFindAll() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Route route = new Route();
			route.setName("route_" + i);
			for(int j = 0; j < 10; j++) {
				Road r = new Road();
				r.setname("road_" + i + "_" + j);
			}
			this.routeDao.save(route);
		}
		List<Route> result =  this.routeDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<Route> result={}", result); //$NON-NLS-1$
		}
	}
}
