package edu.zut.cs.software.navigation.offset.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.offset.service.OffsetManager;

@Controller
@RequestMapping("/offset")
public class OffsetController extends GenericController<Offset, Long,OffsetManager>{

	
	OffsetManager offsetManager;
	
	@Autowired
    public void setOffsetManager(OffsetManager offsetManager) {
        this.offsetManager = offsetManager;
        this.manager = this.offsetManager;
    }
	@RequestMapping("/offsetdemo")
    public String index() {
        return "success";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is 偏移量!";
    }
    
    @ResponseBody
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Offset> findAllOffset(){
		return this.manager.findAll();
	}


	
}