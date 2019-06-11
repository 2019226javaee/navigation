package edu.zut.cs.software.navigation.map.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.map.service.PlaceManager;

@Controller
@RequestMapping("/place")
public class PlaceController extends GenericController<Place, Long, PlaceManager>{

	
	PlaceManager placeManager;
	
	@Autowired
    public void setPlaceManager(PlaceManager placeManager) {
        this.placeManager = placeManager;
        this.manager = this.placeManager;
    }
	@RequestMapping("/placedemo")
    public String index() {
        return "success";
    }


    @ResponseBody
	@RequestMapping(value = "name/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getPlace(@PathVariable String name) {
		return JSON.toJSONString(this.placeManager.findbyPlacename(name));
	}


	
}
