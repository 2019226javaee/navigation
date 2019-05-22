package edu.zut.cs.software.navigation.map.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.place.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;
import edu.zut.cs.software.navigation.place.service.PlaceManager;

public class MapManagerTest extends GenericManagerTestCase<Long, Place, PlaceManager> {

	
	
	@Autowired
    MapManager mapManager;

    public MapManagerTest() {
        super(Place.class);
    }
}
