package edu.zut.cs.software.navigation.road.service;


import java.util.List;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

public interface RoadManager extends GenericTreeManager<Road, Long>{

	List<Road> findbyRoadname(String name);
	
     void deleteById(Long id);
	 
	 void updateById(Long id,String name);
	 
	 void updateById(Long id,String name,String start,String end,float length);
	 
	 void create(String name,String start,String end,float length);
}
