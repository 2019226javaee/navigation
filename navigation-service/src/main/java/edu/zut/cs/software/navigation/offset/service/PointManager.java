package edu.zut.cs.software.navigation.offset.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.offset.domain.Point;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface PointManager extends GenericManager<Point,Long>{

	List<Point> findbyPointname(String point);
	
}
