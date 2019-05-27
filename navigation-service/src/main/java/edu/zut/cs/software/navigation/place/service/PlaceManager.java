package edu.zut.cs.software.navigation.place.service;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface PlaceManager extends GenericManager<Place, Long> {

	
	
	Place findbyPlacename(String place);
	
}
