package edu.zut.cs.software.navigation.place.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.place.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface PlaceManager extends GenericManager<Place, Long> {

	List<Place> findAll();
	
	Place findbyPlacename(String place);
	
}
