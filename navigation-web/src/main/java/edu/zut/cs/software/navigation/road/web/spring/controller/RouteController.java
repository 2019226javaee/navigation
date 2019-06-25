package edu.zut.cs.software.navigation.road.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import edu.zut.cs.software.navigation.admin.road.domain.Road;
import edu.zut.cs.software.navigation.admin.road.domain.Route;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.road.service.RouteManager;

@Controller
@RequestMapping("/route")
public class RouteController extends GenericController<Route, Long, RouteManager>{

	
	RouteManager routeManager;
	
	@Autowired
    public void setPlaceManager(RouteManager routeManager) {
        this.routeManager = routeManager;
        this.manager = this.routeManager;
    }
	@RequestMapping("/index")
    public String index() {
        return "route/index";
    }
	

    
    @ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<Route> findAllRouted() {
    	List<Route> routeList = this.manager.findAll();
        return routeList;
	}
    
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Route saveOne( Route p){
        this.routeManager.save(p);
        return p;
    }
    
    @RequestMapping(path = "/info",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public @ResponseBody Route updateOne(Route p){
        Route p1 =this.routeManager.findById(p.getId());
        this.routeManager.updateById(p.getId(),p.getName());
        return p1;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Route  deleteOne(@PathVariable(value = "id") Long id) {
        Route p = this.routeManager.findById(id);
        this.routeManager.deleteById(id);
        return p;
    }

	
}

