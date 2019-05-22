package edu.zut.cs.software.navigation.place.service;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import edu.zut.cs.software.navigation.admin.place.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class PlaceManagerTest extends GenericManagerTestCase<Long, Place, PlaceManager>{

	PlaceManager placeManager;
	
	public PlaceManagerTest() {
		super(Place.class);
	}
	
	@Autowired
	public void setCustomerManager(PlaceManager placeManager) {
		this.placeManager = placeManager;
		this.manager = this.placeManager;
	}

	@Override
	public void setUp() throws Exception {
		Place place = new Place();
		place.setName("图书馆");
		place.setLeftlocation("行坐标");
		place.setRightlocation("列坐标");
		this.entity = this.manager.save(place);
	}
	
	
	
	@Test
	public void testfindAll() {
		List<Place> all = this.placeManager.findAll();
		all.toString();
	}
}
