package edu.zut.cs.software.navigation.map.service;

import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

import java.util.List;

import edu.zut.cs.software.navigation.admin.map.domain.Map;

public interface MapManager extends GenericTreeManager<Map, Long> {
	
	/**
	 * * fetch entity according given name
	 *
	 * @param name
	 * @return entity
	 */
	List<Map> findbyMapname(String name);

	/**
	 * * update entity according given id
	 *
	 * @param id
	 */
	void updateById(Long id,String name,String area,String placenum);
	 
}