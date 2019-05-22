package edu.zut.cs.software.navigation.admin.map;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import edu.zut.cs.software.navigation.admin.map.dao.MapDao;
import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.base.dao.GenericTreeDaoTestCase;

public class MapDaoTest extends GenericTreeDaoTestCase<Long, Map, MapDao> {
	
	private static final Logger logger = LogManager.getLogger(MapDaoTest.class.getName());

	@Autowired
	MapDao mapDao;

	
	public void setMapDao(MapDao mapDao) {
		this.mapDao = mapDao;
		this.dao = this.mapDao;
	}
	
	@Test
	public void testGetRoot() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Map map = new Map();
			map.setName("map_" + i);
			for(int j = 0; j < 10; j++) {
				Map m = new Map();
				m.setName("map_" + i + "_" + j);
				m.setParent(map);
			}
			this.mapDao.save(map);
		}
		
		List<Map> roots = this.mapDao.getRoot();
		assertEquals(root_size, roots.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Map> roots={}", roots); 
		}

		
	}
}
