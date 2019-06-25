package edu.zut.cs.software.navigation.road.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
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
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<Road> findAllRoad() {
    	List<Road> roadList = this.manager.findAll();
        return roadList;
	}
    
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Road saveOne( Road p){
        this.roadManager.save(p);
        return p;
    }
    
    @RequestMapping(path = "/info",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public @ResponseBody Road updateOne(Road p){
        Road p1 =this.roadManager.findById(p.getId());
        this.roadManager.updateById(p.getId(),p.getname());
        return p1;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Road  deleteOne(@PathVariable(value = "id") Long id) {
        Road p = this.roadManager.findById(id);
        this.roadManager.deleteById(id);
        return p;
    }
}
