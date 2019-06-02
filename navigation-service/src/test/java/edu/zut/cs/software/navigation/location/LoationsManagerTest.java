package edu.zut.cs.software.navigation.location;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.location.domain.Locations;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;
import edu.zut.cs.software.navigation.map.service.PlaceManager;

public class LoationsManagerTest extends GenericManagerTestCase<Long, Locations, LocationsManager>{

	LocationsManager locationsManager;
	public LoationsManagerTest() {
		super(Locations.class);
	}
	
	@Autowired
	public void setLoationsManager(LocationsManager locationsManager) {
		this.locationsManager = locationsManager;
		this.manager = this.locationsManager;
	}

	@Override
	public void setUp()  {
		Locations locations = new Locations();
		locations.setName("图书馆");
		locations.setX(3);
		locations.setY(6);
		this.entity = this.manager.save(locations);
	}
	
	
	
	@Test
	public void findbyPlacename() {
		List<Locations> result = this.locationsManager.findbyLocationsName("图书馆");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("图书馆", result.get(0).getName());
        
		
	}
}
