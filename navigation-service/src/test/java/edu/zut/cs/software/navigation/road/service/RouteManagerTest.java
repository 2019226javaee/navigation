package edu.zut.cs.software.navigation.road.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.road.domain.Route;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class RouteManagerTest extends GenericManagerTestCase<Long, Route, RouteManager>{

	public RouteManagerTest() {
		super(Route.class);
		// TODO Auto-generated constructor stub
	}

	RouteManager routeManager;
	@Autowired
	public void setCustomerManager(RouteManager routeManager) {
		this.routeManager = routeManager;
		this.manager = this.routeManager;
	}
	
	@Test
	public void testfindAll() {
		List<Route> all = this.routeManager.findAll();
		all.toString();
	}
}
