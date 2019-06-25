package edu.zut.cs.software.navigation.map.web.spring.controller;

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

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.map.service.PlaceManager;

@Controller
@RequestMapping("/place")
public class PlaceController extends GenericController<Place, Long, PlaceManager>{

	
	PlaceManager placeManager;
	
	@Autowired
    public void setPlaceManager(PlaceManager placeManager) {
        this.placeManager = placeManager;
        this.manager = this.placeManager;
    }
	@RequestMapping("/index")
    public String index() {
        return "place/index";
    }



    @ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<Place> findAllPlace() {
    	List<Place> placeList = this.manager.findAll();
        return placeList;
	}
    
    @ResponseBody
	@GetMapping(value = "allex",produces = "application/json;charset=utf-8")
	public List<Place> findAllPlaceex(){
		return this.manager.findAll();
	}

    @ResponseBody
   	@GetMapping(value = "tt",produces = "application/json;charset=utf-8")
   	public List<Place> ttasd(){
    	Place p = new Place();
    	p.setName("z中原工学院");
    	placeManager.save(p);
    	System.out.println("该方法已经被调用");
   		return this.manager.findAll();
   	}
    
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Place saveOne( Place p){
        this.placeManager.save(p);
        return p;
    }
    
    @RequestMapping(path = "/info",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public @ResponseBody Place updateOne( Place p){
        Place p1 =this.placeManager.findById(p.getId());
        this.placeManager.updateById(p.getId(),p.getName());
        return p1;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Place  deleteOne(@PathVariable(value = "id") Long id) {
        Place p = this.placeManager.findById(id);
        this.placeManager.deleteById(id);
        return p;
    }
	
}
