package edu.zut.cs.software.navigation.account.web.spring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import edu.zut.cs.software.navigation.account.service.GatherManager;
import edu.zut.cs.software.navigation.admin.account.daomain.Gather;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;

@Controller
@RequestMapping("/gather")
public class GatherController extends GenericController<Gather, Long, GatherManager>{

	
	GatherManager gatherManager;
	
	@Autowired
    public void setGatherManager(GatherManager gatherManager) {
        this.gatherManager =gatherManager;
        this.manager = this.gatherManager;
    }
	@RequestMapping("/index")
    public String index() {
        return "gather/index";
    }



    @ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String findAllPlace() {
    	List<Gather> placeList = this.manager.findAll();
        PageInfo pageInfo = new PageInfo(placeList);
        return JSON.toJSONString(pageInfo);
	}
    
    @ResponseBody
	@GetMapping(value = "allex",produces = "application/json;charset=utf-8")
	public List<Gather> findAllPlaceex(){
		return this.manager.findAll();
	}


	
}