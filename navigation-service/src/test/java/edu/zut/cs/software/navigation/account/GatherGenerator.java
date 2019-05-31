package edu.zut.cs.software.navigation.account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.account.service.GatherManager;
import edu.zut.cs.software.navigation.admin.account.daomain.Gather;
import edu.zut.cs.software.navigation.base.service.GenericGenerator;
public class GatherGenerator extends GenericGenerator {

	GatherManager gatherManager;

	@Autowired
	public void setGroupManager(GatherManager gatherManager) {
		this.gatherManager = gatherManager;
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
				this.gatherManager.save(subgather);
			}
			
		}

	}

}