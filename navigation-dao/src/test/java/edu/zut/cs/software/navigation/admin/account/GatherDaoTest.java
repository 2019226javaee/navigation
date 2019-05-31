package edu.zut.cs.software.navigation.admin.account;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.account.dao.GatherDao;
import edu.zut.cs.software.navigation.admin.account.daomain.Gather;
import edu.zut.cs.software.navigation.base.dao.GenericTreeDaoTestCase;

public class GatherDaoTest extends GenericTreeDaoTestCase<Long, Gather, GatherDao> {

	GatherDao gatherDao;

	@Autowired
	public void setGroupDao(GatherDao gatherDao) {
		this.gatherDao = gatherDao;
		this.dao = this.gatherDao;
	}

	@Test
	public void testGetRoot() {
		int root_size = 10;
		for (int i = 0; i < root_size; i++) {
			Gather gather = new Gather();
			gather.setName("gather_" + i);
			for (int j = 0; j < 10; j++) {
				Gather g = new Gather();
				g.setName("gather_" + i + "_" + j);
				g.setParent(gather);
			}
			this.gatherDao.save(gather);
		}

		List<Gather> roots = this.gatherDao.getRoot();
		//assertEquals(root_size, roots.size());

		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Gather> roots=" + roots); //$NON-NLS-1$
		}
	}

}
