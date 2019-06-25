package edu.zut.cs.software.navigation.map.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.map.service.MapManager;

@Controller
@RequestMapping("/map")
public class MapController extends GenericController<Map, Long, MapManager>{

	
	MapManager mapManager;
	
	@Autowired
    public void setPlaceManager(MapManager mapManager) {
        this.mapManager = mapManager;
        this.manager = this.mapManager;
    }
	@RequestMapping("/mapdemo")
    public String index() {
        return "success";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Map!";
    }
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody List<Map> getAll(){
        List<Map> all = this.mapManager.findAll();
        return all;
    }
   

    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Map saveOne( Map m){
        this.mapManager.save(m);
        return m;
    }
    
    @RequestMapping(path = "/info",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public @ResponseBody Map updateOne( Map m){
        Map  m1=this.mapManager.findById(m.getId());
        this.mapManager.updateById(m1.getId(),m1.getName(),m1.getArea(),m.getPlacenum());
        return m1;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Map  deleteOne(@PathVariable(value = "id") Long id) {
        Map m = this.mapManager.findById(id);
        this.mapManager.deleteById(id);
        return m;
    }
	
}