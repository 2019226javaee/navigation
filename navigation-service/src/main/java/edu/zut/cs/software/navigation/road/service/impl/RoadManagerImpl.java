package edu.zut.cs.software.navigation.road.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.admin.road.dao.RoadDao;
import edu.zut.cs.software.navigation.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.navigation.road.service.RoadManager;

@Service(value = "roadManager")
public  class RoadManagerImpl extends GenericTreeManagerImpl<Road, Long> implements RoadManager{

	RoadDao roadDao;
	@Autowired
	public void setRoadDao( RoadDao roadDao) {
		this.roadDao = roadDao;
		this.treeDao = this.roadDao;
		this.dao=this.treeDao;
	}
	public List<Road> findbyRoadname(String road) {
		Road queryObject = new Road();
		queryObject.setname(road);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("road", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Road> example = Example.of(queryObject,matcher);
		List<Road> result = this.dao.findAll(example);
		return result;
	}
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	@Override
	public void updateById(Long id, String name) {
		// TODO Auto-generated method stub
		Road road = dao.getOne(id);
		road.setname(name);
		this.save(road);
	}
	@Override
	public void updateById(Long id, String name, String start, String end, float length) {
		// TODO Auto-generated method stub
		Road road = dao.getOne(id);
		road.setname(name);
		road.setStart(start);
		road.setEnd(end);
		road.setlength(length);
		this.save(road);
	}
	@Override
	public void create(String name, String start, String end, float length) {
		// TODO Auto-generated method stub
		Road road= new Road();
		road.setname(name);
		road.setStart(start);
		road.setEnd(end);
		road.setlength(length);
		this.save(road);
	}
	
}