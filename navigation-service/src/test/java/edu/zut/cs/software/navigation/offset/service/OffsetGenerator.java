package edu.zut.cs.software.navigation.offset.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.base.service.GenericGenerator;

public class OffsetGenerator extends GenericGenerator{
	OffsetManager offsetManager;
	
	@Autowired
	public void setGroupManager(OffsetManager offsetManager) {
		this.offsetManager = offsetManager;
	}
	
	@Test
	public void testAddOffset() {
		for (int i = 0; i < 10; i++) {
			Offset offset = new Offset();
			offset.setname("offset_" + i);
			offset = this.offsetManager.save(offset);
			for (int j = 0; j < 10; j++) {
				Offset subgroup = new Offset();
				subgroup.setname("subgroup_" + i + "_" + j);
				subgroup.setParent(offset);
				this.offsetManager.save(subgroup);
			}
			
		}

	}
}
