package edu.zut.cs.software.navigation.offset.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
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
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<Offset> findAllOffset() {
    	List<Offset> offsetList = this.manager.findAll();
        return offsetList;
	}
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Offset saveOne( Offset m){
        this.offsetManager.save(m);
        return m;
    }
    
    @RequestMapping(path = "/info",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public @ResponseBody Offset updateOne( Offset m){
        Offset m1=this.offsetManager.findById(m.getId());
        this.offsetManager.updateById(m1.getId(),m1.getName(),m1.getCoordinate(),m1.getDirection(),m1.getSize());
        return m1;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Offset  deleteOne(@PathVariable(value = "id") Long id) {
        Offset m = this.offsetManager.findById(id);
        this.offsetManager.deleteById(id);
        return m;
    }
	


	
}