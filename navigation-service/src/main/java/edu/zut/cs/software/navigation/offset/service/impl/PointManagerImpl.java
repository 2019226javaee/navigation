package edu.zut.cs.software.navigation.offset.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.offset.dao.PointDao;
import edu.zut.cs.software.navigation.admin.offset.domain.Point;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.offset.service.PointManager;

@Component
public class PointManagerImpl extends GenericManagerImpl<Point, Long> implements PointManager {

	
	PointDao pointDao;
	@Autowired
	public void setRouteDao(PointDao pointDao) {
		this.pointDao = pointDao;
		this.dao = this.pointDao;
	}
	@Override
	public List<Point> findbyPointname(String point) {
		// TODO Auto-generated method stub
		return null;
	}

	


}