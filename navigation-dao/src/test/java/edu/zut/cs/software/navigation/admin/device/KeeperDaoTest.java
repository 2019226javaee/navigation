package edu.zut.cs.software.navigation.admin.device;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.device.dao.KeeperDao;
import edu.zut.cs.software.navigation.admin.device.domain.Keeper;
import edu.zut.cs.software.navigation.base.dao.GenericTreeDaoTestCase;

public class KeeperDaoTest extends GenericTreeDaoTestCase<Long, Keeper, KeeperDao> {
	private static final Logger logger = LogManager.getLogger(KeeperDaoTest.class.getName());
	KeeperDao keeperDao;

	@Autowired
	public void setDriverDao(KeeperDao keeperDao) {
		this.keeperDao = keeperDao;
		this.dao = this.keeperDao;
	}

	@Test
	public void testGetRoot() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Keeper keeper = new Keeper();
			keeper.setName("keeper_" + i);
			for(int j = 0; j < 10; j++) {
				Keeper k = new Keeper();
				k.setName("keeper_" + i + "_" + j);
				k.setParent(keeper);
			}
			this.keeperDao.save(keeper);
		}
		
		List<Keeper> roots = this.keeperDao.getRoot();
		assertEquals(root_size, roots.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Keeper> roots={}", roots); 
		}

		
	}
	
}
