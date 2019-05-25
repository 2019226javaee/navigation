package edu.zut.cs.software.navigation.map.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class MapManagerTest extends GenericManagerTestCase<Long, Map, MapManager> {

	
	
	@Autowired
    MapManager mapManager;

    public MapManagerTest() {
        super(Map.class);
    }
}
