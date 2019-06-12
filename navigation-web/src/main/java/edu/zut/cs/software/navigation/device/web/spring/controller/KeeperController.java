package edu.zut.cs.software.navigation.device.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.device.domain.Keeper;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.device.service.KeeperManager;

@Controller
@RequestMapping("/keeper")
public class KeeperController extends GenericController<Keeper, Long, KeeperManager>{

	
	KeeperManager keeperManager;
	
	@Autowired
    public void setKeeperManager(KeeperManager keeperManager) {
        this.keeperManager = keeperManager;
        this.manager = this.keeperManager;
    }
	@RequestMapping("/keeperdemo")
    public String index() {
        return "success";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Keeper!";
    }
    
    @ResponseBody
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Keeper> findAllKeeper(){
		return this.manager.findAll();
	}


	
}