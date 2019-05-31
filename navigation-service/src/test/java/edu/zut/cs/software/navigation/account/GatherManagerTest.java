package edu.zut.cs.software.navigation.account;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.account.service.GatherManager;
import edu.zut.cs.software.navigation.admin.account.daomain.Gather;
import edu.zut.cs.software.navigation.base.service.GenericTreeManagerTestCase;

public class GatherManagerTest extends GenericTreeManagerTestCase<Long, Gather, GatherManager> {

	GatherManager gatherManager;

	public GatherManagerTest() {
		super(Gather.class);
	}

	@Autowired
	public void setGatherManager(GatherManager gatherManager) {
		this.gatherManager = gatherManager;
		this.manager = this.gatherManager;
	}

	@Test
	public void testAddGather() {
		for (int i = 0; i < 10; i++) {
			Gather gather = new Gather();
			gather.setName("gather_" + i);
			gather = this.gatherManager.save(gather);
			for (int j = 0; j < 10; j++) {
				Gather subgather = new Gather();
				subgather.setName("subgather_" + i + "_" + j);
				subgather.setParent(gather);
				subgather= this.gatherManager.save(subgather);
			}
		}

		List<Gather> rootGatherList = this.gatherManager.getRoot();
		assertNotNull(rootGatherList);
		assertEquals(20, rootGatherList.size());
	

	}

}
