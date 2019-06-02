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
	
	@Override
	public void setUp()  {
		Offset m = new Offset();
		m.setName("变量");
		this.entity = this.manager.save(m);
	}
    
    @Test
	public void findbyMapname() {
		List<Offset> result = this.offsetManager.findbyOffsetname("变量");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("变量", result.get(0).getName());
        
		
	}
}