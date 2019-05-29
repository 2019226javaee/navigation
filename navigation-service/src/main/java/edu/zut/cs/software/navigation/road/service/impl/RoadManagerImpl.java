package edu.zut.cs.software.navigation.road.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.admin.road.dao.RoadDao;
import edu.zut.cs.software.navigation.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.navigation.road.service.RoadManager;

@Service(value = "roadManager")
public  class RoadManagerImpl extends GenericTreeManagerImpl<Road, Long> implements RoadManager{

	RoadDao roadDao;
	@Autowired
	public void setRoadDao( RoadDao roadDao) {
		this.roadDao = roadDao;
		this.treeDao = this.roadDao;
		this.dao=this.treeDao;
	}
	public Road findbyRoadname(String road) {
		// TODO Auto-generated method stub
		return null;
	}
	
}