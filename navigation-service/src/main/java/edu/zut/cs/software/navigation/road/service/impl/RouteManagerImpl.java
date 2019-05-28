package edu.zut.cs.software.navigation.road.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.road.dao.RouteDao;
import edu.zut.cs.software.navigation.admin.road.domain.Route;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.road.service.RouteManager;

@Component
public class RouteManagerImpl extends GenericManagerImpl<Route, Long> implements RouteManager {

	
	RouteDao routeDao;
	@Autowired
	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
		this.dao = this.routeDao;
	}
	@Override
	public List<Route> findbyRoutename(String route) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
