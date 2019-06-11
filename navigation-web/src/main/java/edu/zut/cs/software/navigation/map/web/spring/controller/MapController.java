package edu.zut.cs.software.navigation.map.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.map.service.MapManager;

@Controller
@RequestMapping("/map")
public class MapController extends GenericController<Map, Long, MapManager>{

	
	MapManager mapManager;
	
	@Autowired
    public void setPlaceManager(MapManager mapManager) {
        this.mapManager = mapManager;
        this.manager = this.mapManager;
    }
	@RequestMapping("/mapdemo")
    public String index() {
        return "success";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Map!";
    }


	
}