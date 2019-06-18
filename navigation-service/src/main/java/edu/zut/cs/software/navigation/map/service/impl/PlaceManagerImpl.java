package edu.zut.cs.software.navigation.map.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.navigation.admin.map.dao.PlaceDao;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.map.service.PlaceManager;

@Service("placeManager")
@Component
@Transactional
public class PlaceManagerImpl extends GenericManagerImpl<Place, Long> implements PlaceManager{
	
	PlaceDao placeDao;
	
	@Autowired
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
		this.dao = this.placeDao;
	}
	
	@Override
	public List<Place> findbyPlacename(String placename) {
		Place queryObject = new Place();
		queryObject.setName(placename);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("placename", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Place> example = Example.of(queryObject,matcher);
		List<Place> result = this.dao.findAll(example);
		return result;
	}
	
	
	@Override
	public List<Place> findbyLocation(String left,String right){
		return null;
	}
	@Override
	public List<String> findPlaceLocation(String name){
		Place queryObject = new Place();
		queryObject.setName(name);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Place> example = Example.of(queryObject,matcher);
		List<Place> result = this.dao.findAll(example);
		List<String> de = new ArrayList<String>();
		de.add(result.get(0).getX());
		de.add(result.get(0).getY());
		return de;
	}
	
	
}
