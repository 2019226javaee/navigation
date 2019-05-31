package edu.zut.cs.software.navigation.location;

import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

import java.util.List;

import edu.zut.cs.software.navigation.admin.location.domain.Routes;

public interface RoutesManager extends GenericTreeManager<Routes, Long> {
	List<Routes> findbyName(String name);


}