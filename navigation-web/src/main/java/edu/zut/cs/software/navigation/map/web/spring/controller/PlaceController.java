package edu.zut.cs.software.navigation.map.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	/**
	 * @param null
	 * @return list<place>
	 */
    @ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<Place> findAllPlace() {
    	List<Place> placeList = this.manager.findAll();
        return placeList;
	}
    
    /**
	 * @param place
	 * @return place
	 */
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Place saveOne( Place p){
        this.placeManager.save(p);
        return p;
    }
    
    @RequestMapping(path = "/info",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public @ResponseBody void updateOne( Place p){
        this.placeManager.updateById(p.getId(),p.getName());
    }

    /**
	 * @param id the entity you want to delete
	 * @return null
	 */
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody void deleteOne(@PathVariable(value = "id") Long id) {
        this.placeManager.delete(id);//deleteById(id);
    }
	
}
