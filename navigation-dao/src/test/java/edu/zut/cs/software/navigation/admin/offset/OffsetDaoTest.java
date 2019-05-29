package edu.zut.cs.software.navigation.admin.offset;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.admin.offset.dao.OffsetDao;
import edu.zut.cs.software.navigation.base.dao.GenericTreeDaoTestCase;

public class OffsetDaoTest extends GenericTreeDaoTestCase<Long, Offset, OffsetDao> {
	
	private static final Logger logger = LogManager.getLogger(OffsetDaoTest.class.getName());

	
	OffsetDao offsetDao;

	@Autowired
	public void setOffset(OffsetDao offsetDao) {
		this.offsetDao = offsetDao;
		this.dao = this.offsetDao;
	}
	
	@Test
	public void testGetRoot() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Offset offset = new Offset();
			offset.setName("offset_" + i);
			for(int j = 0; j < 10; j++) {
				Offset m = new Offset();
				m.setName("offset_" + i + "_" + j);
			}
			this.offsetDao.save(offset);
		}
		
		List<Offset> roots = this.offsetDao.getRoot();
		assertEquals(root_size, roots.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Offset> roots={}", roots); 
		}

		
	}
}