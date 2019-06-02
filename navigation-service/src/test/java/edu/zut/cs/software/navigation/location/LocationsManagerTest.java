package edu.zut.cs.software.navigation.location;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.location.domain.Locations;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class LocationsManagerTest extends GenericManagerTestCase<Long, Locations, LocationsManager>{

	



	LocationsManager locationsManager;
	public LocationsManagerTest() {
		super(Locations.class);
		
	}
	
	
	@Autowired
	public void setLocationsManager(LocationsManager locationsManager) {
		this.locationsManager = locationsManager;
		this.manager = this.locationsManager;
	}

	@Override
	public void setUp()  {
		Locations l = new Locations();
		l.setName("餐厅");
		this.entity = this.manager.save(l);
	}
	
	
	
	@Test
	public void findbyLocationsName() {
		List<Locations> result = this.locationsManager.findbyLocationsName("餐厅");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("餐厅", result.get(0).getName());
        
		
	}
}
