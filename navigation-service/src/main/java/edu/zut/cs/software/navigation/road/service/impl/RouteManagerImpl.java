package edu.zut.cs.software.navigation.road.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.road.dao.RouteDao;
import edu.zut.cs.software.navigation.admin.road.domain.Road;
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
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	@Override
	public void updateById(Long id, String name) {
		// TODO Auto-generated method stub
		Route route = dao.getOne(id);
		route.setName(name);
		this.save(route);
	}
	@Override
	public void updateById(Long id, String name, String number, String zlength) {
		// TODO Auto-generated method stub
		Route route = dao.getOne(id);
		route.setName(name);
		route.setNumber(number);
		route.setZlength(zlength);
		this.save(route);
	}
	@Override
	public void create(String name,String number,String zlength){
		// TODO Auto-generated method stub
		Route route= new Route();
		route.setName(name);
		route.setNumber(number);
		route.setZlength(zlength);
		this.save(route);
	}
	
}
