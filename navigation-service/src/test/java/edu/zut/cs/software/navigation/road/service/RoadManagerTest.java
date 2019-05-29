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
	
	@Test
	public void testAddRoad() {
		for (int i = 0; i < 10; i++) {
			Road road = new Road();
			road.setname("road_" + i);
			road = this.roadManager.save(road);
			for (int j = 0; j < 10; j++) {
				Road subgroup = new Road();
				subgroup.setname("subgroup_" + i + "_" + j);
				subgroup.setParent(road);
				subgroup = this.roadManager.save(subgroup);
			}
		}
		
		List<Road> rootRoadList = this.roadManager.getRoot();
		assertNotNull(rootRoadList);
		Assert.assertEquals(110, rootRoadList.size());

	}
}