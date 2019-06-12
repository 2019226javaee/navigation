package edu.zut.cs.software.navigation.road.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.road.service.RoadManager;

@Controller
@RequestMapping("/road")
public class RoadController extends GenericController<Road, Long, RoadManager>{

	
	RoadManager roadManager;
	
	@Autowired
    public void setRoadManager(RoadManager roadManager) {
        this.roadManager = roadManager;
        this.manager = this.roadManager;
    }
	@RequestMapping("/raoddemo")
    public String index() {
        return "success";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Road!";
    }
    
    @ResponseBody
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Road> findAllRoad(){
		return this.manager.findAll();
	}


	
}
