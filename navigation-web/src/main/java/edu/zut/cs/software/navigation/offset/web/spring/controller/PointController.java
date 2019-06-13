package edu.zut.cs.software.navigation.offset.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import edu.zut.cs.software.navigation.admin.offset.domain.Point;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.offset.service.PointManager;

@Controller
@RequestMapping("/point")
public class PointController extends GenericController<Point, Long, PointManager>{

	
	PointManager pointManager;
	
	@Autowired
    public void setPlaceManager(PointManager pointManager) {
        this.pointManager = pointManager;
        this.manager = this.pointManager;
    }
	@RequestMapping("/index")
    public String index() {
        return "point/index";
    }



    @ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String findAllPoint() {
    	List<Point> pointList = this.manager.findAll();
        PageInfo pageInfo = new PageInfo(pointList);
        return JSON.toJSONString(pageInfo);
	}
    
    @ResponseBody
	@GetMapping(value = "allex",produces = "application/json;charset=utf-8")
	public List<Point> findAllRouteex(){
		return this.manager.findAll();
	}


	
}
