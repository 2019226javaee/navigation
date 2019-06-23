package edu.zut.cs.software.navigation.map.service;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;
import edu.zut.cs.software.navigation.location.LocationsManager;
import edu.zut.cs.software.navigation.map.service.PlaceManager;

public class PlaceManagerTest extends GenericManagerTestCase<Long, Place, PlaceManager>{

	PlaceManager placeManager;
	LocationsManager locationManager;
	public PlaceManagerTest() {
		super(Place.class);
	}
	
	@Autowired
	public void setPlaceManager(PlaceManager placeManager) {
		this.placeManager = placeManager;
		this.manager = this.placeManager;
	}

	@Override
	public void setUp()  {
	}
	
	
	
	/*@Test
	public void findbyPlacename() {
		List<Place> result = this.placeManager.findbyPlacename("图书馆");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("图书馆", result.get(0).getName());
        
		
	}*/
	/*@Test
	public void findPlaceLocation() {
		String name = "图书馆";
		List<String> demo = this.placeManager.findPlaceLocation(name);
		System.out.println(demo.get(0));
		System.out.println(demo.get(1));
	}*/

	/*
	@Test
	public void createcase() {
		//创建一个名为南苑十二号宿舍楼的地点数据
		placeManager.create( "南十二宿舍楼", "151", "115");
		System.out.println("南十二数据已经被创建");
	}
	@Test
	public void updatecase() {
		placeManager.updateById((long)687,"南十研究生宿舍楼","21","44");
		System.out.println("南十数据已经被修改");
	}*/
}
