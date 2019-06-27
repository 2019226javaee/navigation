package edu.zut.cs.software.navigation.map.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface PlaceManager extends GenericManager<Place, Long> {

	
	/**
	 * * fetch entity according given name
	 *
	 * @param name
	 * @return entity
	 */
	List<Place> findbyPlacename(String place);
	
	/**
	 * * fetch entity according given name 
	 *
	 * @param name
	 * @return entity
	 */
	List<Place> findbyTPlacename(String place1,String place2);
	
	/**
	 * * fetch entity according given location
	 *
	 * @param location
	 * @return entity
	 */
	List<Place> findbyLocation(String leftlocation,String rightlocation);
	
	
	/**
	 * * fetch location according given name
	 *
	 * @param name
	 * @return entity
	 */
	List<String> findPlaceLocation(String name);
	 
	/**
	 * * update entity according given id
	 *
	 * @param id
	 */
	void updateById(Long id,String name);
	 
	/**
	 * * update entity according given id
	 *
	 * @param id
	 */
	void updateById(Long id,String name,String llocation,String rlocation);
	 
}
