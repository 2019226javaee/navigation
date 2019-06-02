package edu.zut.cs.software.navigation.road.service;


import java.util.List;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

public interface RoadManager extends GenericTreeManager<Road, Long>{

	List<Road> findbyRoadname(String name);
}
