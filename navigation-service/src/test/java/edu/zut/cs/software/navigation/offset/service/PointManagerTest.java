package edu.zut.cs.software.navigation.offset.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.offset.domain.Point;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class PointManagerTest extends GenericManagerTestCase<Long, Point, PointManager>{

	public PointManagerTest() {
		super(Point.class);
		// TODO Auto-generated constructor stub
	}

	PointManager pointManager;
	@Autowired
	public void setCustomerManager(PointManager pointManager) {
		this.pointManager = pointManager;
		this.manager = this.pointManager;
	}
	
	@Test
	public void testfindAll() {
		List<Point> all = this.pointManager.findAll();
		all.toString();
	}
}