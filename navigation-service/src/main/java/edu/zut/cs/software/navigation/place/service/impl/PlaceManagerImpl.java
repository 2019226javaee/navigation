package edu.zut.cs.software.navigation.place.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.map.dao.PlaceDao;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.place.service.PlaceManager;

@Component
public class PlaceManagerImpl extends GenericManagerImpl<Place, Long> implements PlaceManager{

	PlaceDao placeDao;
	@Override
	public Place findbyPlacename(String placename) {
		return null;
	}
	
	@Autowired
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
		this.dao = this.placeDao;
	}
}
