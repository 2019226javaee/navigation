package edu.zut.cs.software.navigation.offset.service;

import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.base.service.GenericTreeManagerTestCase;

public class OffsetManagerTest extends GenericTreeManagerTestCase<Long, Offset, OffsetManager>{

	
	OffsetManager offsetManager;
	
	public OffsetManagerTest() {
		super(Offset.class);
		
	}
	@Autowired
	public void setOffsetManager(OffsetManager offsetManager) {
		this.offsetManager = offsetManager;
		this.manager = this.offsetManager;
	}
	
	@Test
	public void testAddOffset() {
		for (int i = 0; i < 10; i++) {
			Offset offset = new Offset();
			offset.setName("offset_" + i);
			offset = this.offsetManager.save(offset);
			for (int j = 0; j < 10; j++) {
				Offset subgroup = new Offset();
				subgroup.setName("subgroup_" + i + "_" + j);
				subgroup.setParent(offset);
				subgroup = this.offsetManager.save(subgroup);
			}
		}
		
		List<Offset> rootOffsetList = this.offsetManager.getRoot();
		assertNotNull(rootOffsetList);
		Assert.assertEquals(110, rootOffsetList.size());

	}
}