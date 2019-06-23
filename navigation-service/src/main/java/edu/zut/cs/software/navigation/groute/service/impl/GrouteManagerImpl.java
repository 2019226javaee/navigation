package edu.zut.cs.software.navigation.groute.service.impl;

import java.util.List;

import edu.zut.cs.software.navigation.admin.location.domain.Routes;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.groute.service.GrouteManager;
import edu.zut.cs.software.navigation.map.service.PlaceManager;

public class GrouteManagerImpl implements GrouteManager{

	PlaceManager placeManager;
	
	@Override
	public List<Routes> getRoute(String pname1,String pname2){
		List<Place> pdemo = placeManager.findbyTPlacename(pname1, pname2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		List<Routes> demo = null;
		return null;
		
	}
}
