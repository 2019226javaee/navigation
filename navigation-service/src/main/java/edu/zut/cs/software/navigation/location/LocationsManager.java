package edu.zut.cs.software.navigation.location;

import java.util.List;

import edu.zut.cs.software.navigation.admin.location.domain.Locations;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface LocationsManager extends GenericManager<Locations, Long> {

	
	//通过地点名称查找地点
	List<Locations> findbyName(String name);
	
	
	
	
}
