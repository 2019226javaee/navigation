package edu.zut.cs.software.navigation.device.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.device.domain.Keeper;
import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

public interface KeeperManager extends GenericTreeManager<Keeper, Long>{
	List<Keeper> findbyKeepername(String name);
	
	List<Keeper> findAll();
	
	void deleteById(Long id);
	 
	 void updateById(Long id,String name,String access);
	 
	 void create(String name,String access);
}