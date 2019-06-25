package edu.zut.cs.software.navigation.offset.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.base.service.GenericGenerator;

public class OffsetGenerator extends GenericGenerator{
	OffsetManager offsetManager;
	
	@Autowired
	public void setGroupManager(OffsetManager offsetManager) {
		this.offsetManager = offsetManager;
	}
	
	/*@Test
	public void testAddOffset() {
		for (int i = 0; i < 10; i++) {
			Offset offset = new Offset();
			offset.setName("offset_" + i);
			offset = this.offsetManager.save(offset);
			for (int j = 0; j < 10; j++) {
				Offset subgroup = new Offset();
				subgroup.setName("subgroup_" + i + "_" + j);
				subgroup.setParent(offset);
				this.offsetManager.save(subgroup);
			}
			
		}

	}
	@Test
	public void findbyOffsetname() {
		List<Offset> result = this.offsetManager.findbyOffsetname("图书馆");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("图书馆", result.get(0).getName());
        
		
	}
	
	
	@Test
	public void createcase() {
		//创建一个名为南苑十二号宿舍楼的地点数据
		offsetManager.create( "南十二宿舍楼", "151", "115"," 11");
		System.out.println("南十二数据已经被创建");
	}
	@Test
	public void updatecase() {
		offsetManager.updateById((long)123,"南十研究生宿舍楼","21","44","11");
		System.out.println("南十数据已经被修改");
	}*/
}
