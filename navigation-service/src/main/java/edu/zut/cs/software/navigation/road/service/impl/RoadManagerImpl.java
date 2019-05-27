package edu.zut.cs.software.navigation.road.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.admin.road.dao.RoadDao;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.road.service.RoadManager;

@Component
public abstract  class RoadManagerImpl extends GenericManagerImpl<Road, Long> implements RoadManager{

	RoadDao roadDao;
	
	@Autowired
	public void setPlaceDao( RoadDao roadDao) {
		this.roadDao = roadDao;
		this.dao = this.roadDao;
	}
}