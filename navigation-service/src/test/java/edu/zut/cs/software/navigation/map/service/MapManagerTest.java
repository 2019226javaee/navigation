package edu.zut.cs.software.navigation.map.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.base.service.GenericTreeManagerTestCase;

public class MapManagerTest extends GenericTreeManagerTestCase<Long, Map, MapManager> {

	
	
	
    MapManager mapManager;

    public MapManagerTest() {
        super(Map.class);
    }
    
    @Autowired
	public void setMapManager(MapManager mapManager) {
		this.mapManager = mapManager;
		this.manager = this.mapManager;
	}
    
    @Override
	public void setUp()  {
		Map map = new Map();
		map.setName("南苑地图");
		map.setArea("800亩");
		this.entity = this.manager.save(map);
	}
    
    @Test
	public void findbyMapname() {
		List<Map> result = this.mapManager.findbyMapname("南苑地图");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("南苑地图", result.get(0).getName());
        
		
	}
}
