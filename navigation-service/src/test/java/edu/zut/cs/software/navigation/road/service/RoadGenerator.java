package edu.zut.cs.software.navigation.road.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.service.GenericGenerator;

public class RoadGenerator extends GenericGenerator{
	RoadManager roadManager;
	
	@Autowired
	public void setGroupManager(RoadManager roadManager) {
		this.roadManager = roadManager;
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
				this.roadManager.save(subgroup);
			}
			
		}

	}
}
