package edu.zut.cs.software.navigation.road.service;

//import static org.junit.Assert.assertNotNull;

import java.util.List;

//import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class RoadManagerTest extends GenericManagerTestCase<Long, Road, RoadManager>{

	
	RoadManager roadManager;
	
	public RoadManagerTest() {
		super(Road.class);
		
	}
	@Autowired
	public void setRoadManager(RoadManager roadManager) {
		this.roadManager = roadManager;
		this.manager = this.roadManager;
	}
	@Test
	public void testFindAll() {
		List<Road> all = this.roadManager.findAll();
		//assertNotNull(all);
		//Assert.assertEquals(100, all.size());
		all.toString();
	}
}
