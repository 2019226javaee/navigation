package edu.zut.cs.software.navigation.map.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface PlaceManager extends GenericManager<Place, Long> {

	
	//通过地点名称查找地点
	List<Place> findbyPlacename(String place);
	
	
	//通过地点编号查找地点
	List<Place> findbyLocation(String leftlocation,String rightlocation);
	
}
