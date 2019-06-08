package edu.zut.cs.software.navigation.map.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.map.service.PlaceManager;

@Controller
@RequestMapping("/place")
public class PlaceController extends GenericController<Place, Long, PlaceManager> {

	PlaceManager placeManager;

    @Autowired
    public void setCustomerManager(PlaceManager placeManager) {
        this.placeManager = placeManager;
        this.manager = this.placeManager;
    }
    @RequestMapping("/index")
    public String index() {
        return "place/index";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Place!";
    }

    @RequestMapping("/helloworld")
    public String hellow() {
    	System.out.println("hello world");
    	return "success";
    }
}
