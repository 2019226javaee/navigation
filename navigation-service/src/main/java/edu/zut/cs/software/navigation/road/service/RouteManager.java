package edu.zut.cs.software.navigation.road.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.road.domain.Route;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface RouteManager extends GenericManager<Route,Long>{

	List<Route> findbyRoutename(String route);
	
    void deleteById(Long id);
	 
	void updateById(Long id,String name);
	 
	void updateById(Long id,String name,String number,String zlength);
	 
	void create(String name,String number,String zlength);
}
