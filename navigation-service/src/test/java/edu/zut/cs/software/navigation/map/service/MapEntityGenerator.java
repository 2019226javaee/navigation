package edu.zut.cs.software.navigation.map.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericGenerator;

public class MapEntityGenerator extends GenericGenerator {

	@Autowired
	MapManager mapManager;
	@Autowired
    PlaceManager placeManager;
	
	
	@Test
    public void testMapGeneration() {
        for (int i = 0; i < 3; i++) {
            Map m = new Map();
            m.setName("map_" + i);
            this.mapManager.save(m);
            List<Map> list = new ArrayList<Map>();
            for (int j = 0; j < 3; j++) {
                Map map = new Map();
                map.setName("map_" + i + "_" + j);
                map.setParent(m);
                list.add(map);
            }
            this.mapManager.save(list);
        }
    }
	
	public void testPlaceGeneration(Map m) {
		for(int i = 1; i < 5; i++) {
			Place p = new Place();
			p.setName("place_" + i);
			p.setLeftlocation("行坐标"+i);
			p.setRightlocation("列坐标"+i);
			p.setMap(m);
			this.placeManager.save(p);
		}
	}
	@Test
	public void test() {
		this.mapManager.findAll();
	}
}
