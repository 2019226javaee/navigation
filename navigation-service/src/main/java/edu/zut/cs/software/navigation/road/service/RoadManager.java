package edu.zut.cs.software.navigation.road.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface RoadManager extends GenericManager<Road, Long>{

    List<Road> findAll();
	Place findbyPlacename(String place);
}
