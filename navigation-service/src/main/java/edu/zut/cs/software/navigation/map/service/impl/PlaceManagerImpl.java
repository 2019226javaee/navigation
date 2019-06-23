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
	PlaceManager placeManager;
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
	@Override
	public List<Place> findbyTPlacename(String name1,String name2){
		Place demo1 = new Place();Place demo2 = new Place(); 
		demo1.setName(name1);demo2.setName(name2);
		demo1.setDateModified(null);demo1.setDateCreated(null);demo2.setDateCreated(null);demo2.setDateModified(null);
		ExampleMatcher matcher1 = ExampleMatcher.matching().withMatcher("name1", ExampleMatcher.GenericPropertyMatchers.startsWith());
		ExampleMatcher matcher2 = ExampleMatcher.matching().withMatcher("name2", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Place> example1 = Example.of(demo1,matcher1);
		Example<Place> example2 = Example.of(demo2,matcher2);
		List<Place> result1 = this.dao.findAll(example1);
		List<Place> result2 = this.dao.findAll(example2);
		List<Place> result = new ArrayList<Place>();
		result.add(result1.get(0));result.add(result2.get(0));
		return result;
		
		
		
	}
	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}
	
	@Override
	public void updateById(Long id,String name) {
		Place place = dao.getOne(id);
		place.setName(name);
		this.save(place);
	}
	
	@Override
	public void updateById(Long id,String name,String llocation,String rlocation) {
		Place place = dao.getOne(id);
		place.setName(name);
		place.setX(llocation);
		place.setY(rlocation);
		this.save(place);
	}
	
	@Override
	public void create(String name,String llocation,String rlocation) {
		Place place = new Place();
		place.setName(name);
		place.setX(llocation);
		place.setY(rlocation);
		this.save(place);
	}
}
