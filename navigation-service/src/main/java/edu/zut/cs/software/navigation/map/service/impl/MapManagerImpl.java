package edu.zut.cs.software.navigation.map.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.map.dao.MapDao;
import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.navigation.map.service.MapManager;

@Component
public class MapManagerImpl extends GenericTreeManagerImpl<Map, Long> implements MapManager{

	MapDao mapDao;

    @Autowired
    public void setMapDao(MapDao mapDao) {
        this.mapDao = mapDao;
        this.dao = this.mapDao;
        this.dao = this.treeDao;
    }
}
