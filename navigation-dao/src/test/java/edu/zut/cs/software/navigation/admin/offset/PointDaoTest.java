package edu.zut.cs.software.navigation.admin.offset;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.offset.dao.PointDao;
import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.admin.offset.domain.Point;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

public class PointDaoTest extends GenericDaoTestCase<Long, Point, PointDao>{
	
	
	@Autowired
	PointDao pointDao;
	private static final Logger logger = LogManager.getLogger(PointDaoTest.class.getName());
	public void setPointDao(PointDao pointDao) {
		this.pointDao = pointDao;
		this.dao =  this.pointDao;
	}
	@Test
    public void testFindAll() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Point point = new Point();
			point.setName("point_" + i);
			for(int j = 0; j < 10; j++) {
				Offset r = new Offset();
				r.setEntityName("offset_" + i + "_" + j);
			}
			this.pointDao.save(point);
		}
		List<Point> result =  this.pointDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<Point> result={}", result); //$NON-NLS-1$
		}
	}
}