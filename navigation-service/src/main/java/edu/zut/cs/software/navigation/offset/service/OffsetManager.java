package edu.zut.cs.software.navigation.offset.service;


import java.util.List;

import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

public interface OffsetManager extends GenericTreeManager<Offset, Long> {
	List<Offset> findbyOffsetname(String name);

	List<Offset> findAll();
	
	void deleteById(Long id);
	 
	 void updateById(Long id,String name,String coordinate,String direction,String size);
	 
	 void create(String name,String coordinate,String direction,String size);
}