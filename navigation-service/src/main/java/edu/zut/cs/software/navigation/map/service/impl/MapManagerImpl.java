package edu.zut.cs.software.navigation.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        this.treeDao = this.mapDao;
        this.dao = this.treeDao;
    }
    
    @Override
    public List<Map> findbyMapname(String mapname){
    	Map queryObject = new Map();
		queryObject.setName(mapname);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("mapname", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Map> example = Example.of(queryObject,matcher);
		List<Map> result = this.dao.findAll(example);
		return result;
    }
    
    @Override
    public List<Map> findAll(){
    	List<Map> result = this.dao.findAll();
    	return result;
    }
    
   
}
