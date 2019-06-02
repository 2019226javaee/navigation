package edu.zut.cs.software.navigation.road.service;

import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.service.GenericTreeManagerTestCase;

public class RoadManagerTest extends GenericTreeManagerTestCase<Long, Road, RoadManager>{

	
	RoadManager roadManager;
	
	public RoadManagerTest() {
		super(Road.class);
		
	}
	@Autowired
	public void setRoadManager(RoadManager roadManager) {
		this.roadManager = roadManager;
		this.manager = this.roadManager;
	}
	
	@Override
	public void setUp()  {
		Road m = new Road();
		m.setname("太湖路");
		this.entity = this.manager.save(m);
	}
    
    @Test
	public void findbyMapname() {
		List<Road> result = this.roadManager.findbyRoadname("太湖路");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("太湖路", result.get(0).getname());
        
		
	}
}