package edu.zut.cs.software.navigation.road.service;


import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface RoadManager extends GenericManager<Road, Long>{

	Road findbyRoadname(String road);
}
