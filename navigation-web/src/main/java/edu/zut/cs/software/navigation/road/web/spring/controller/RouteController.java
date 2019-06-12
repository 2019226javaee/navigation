package edu.zut.cs.software.navigation.road.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

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
	public String findAllRoute() {
    	List<Route> routeList = this.manager.findAll();
        PageInfo pageInfo = new PageInfo(routeList);
        return JSON.toJSONString(pageInfo);
	}
    
    @ResponseBody
	@GetMapping(value = "allex",produces = "application/json;charset=utf-8")
	public List<Route> findAllRouteex(){
		return this.manager.findAll();
	}


	
}

