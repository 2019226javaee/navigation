package edu.zut.cs.software.navigation.device.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.device.domain.Keeper;
import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

public interface KeeperManager extends GenericTreeManager<Keeper, Long>{
	List<Keeper> findbyKeepername(String name);
}