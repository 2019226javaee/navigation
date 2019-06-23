package edu.zut.cs.software.navigation.groute.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.location.domain.Routes;
import edu.zut.cs.software.navigation.admin.map.domain.Place;

public interface GrouteManager {

	
	List<Routes> getRoute(String pname1,String pname2);
}
