package edu.zut.cs.software.navigation.device.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody List<Keeper> getAll(){
        List<Keeper> all = this.keeperManager.findAll();
        return all;
    }
   

    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Keeper saveOne( Keeper k){
        this.keeperManager.save(k);
        return k;
    }
    
    @RequestMapping(path = "/info",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public @ResponseBody Keeper updateOne( Keeper k){
        Keeper  k1=this.keeperManager.findById(k.getId());
        this.keeperManager.updateById(k.getId(),k.getName(),k.getAccess());
        return k1;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Keeper  deleteOne(@PathVariable(value = "id") Long id) {
        Keeper k = this.keeperManager.findById(id);
        this.keeperManager.deleteById(id);
        return k;
    }

	
}