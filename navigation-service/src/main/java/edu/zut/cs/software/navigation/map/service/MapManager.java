package edu.zut.cs.software.navigation.map.service;

import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

import java.util.List;

import edu.zut.cs.software.navigation.admin.map.domain.Map;

public interface MapManager extends GenericTreeManager<Map, Long> {
	List<Map> findbyMapname(String name);

	List<Map> findAll();
	
}