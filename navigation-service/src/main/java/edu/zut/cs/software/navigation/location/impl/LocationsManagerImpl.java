package edu.zut.cs.software.navigation.location.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.location.dao.LocationsDao;
import edu.zut.cs.software.navigation.admin.location.domain.Locations;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.location.LocationsManager;

@Component
public class LocationsManagerImpl extends GenericManagerImpl<Locations, Long> implements LocationsManager{

	LocationsDao locationsDao;
	

	@Autowired
	public void setLocationsDao(LocationsDao locationsDao) {
		this.locationsDao = locationsDao;
		this.dao = this.locationsDao;
	}

	@Override
	public List<Locations> findbyLocationsName(String locations_name) {
		Locations queryObject = new Locations();
		queryObject.setName(locations_name);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("locations_name", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Locations> example = Example.of(queryObject,matcher);
		List<Locations> result = this.dao.findAll(example);
		return result;
	}

}

