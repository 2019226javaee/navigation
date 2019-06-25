package edu.zut.cs.software.navigation.device.web.spring.controller;

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

import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.device.service.DeviceManager;

@Controller
@RequestMapping("/device")
public class DeviceController extends GenericController<Device, Long, DeviceManager>{

	
	DeviceManager deviceManager;
	
	@Autowired
    public void setDeviceManager(DeviceManager deviceManager) {
        this.deviceManager = deviceManager;
        this.manager = this.deviceManager;
    }
	@RequestMapping("/index")
    public String index() {
        return "device/index";
    }



	@ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<Device> findAllPlace() {
    	List<Device> deviceList = this.manager.findAll();
        return deviceList;
	}
    
    @ResponseBody
	@GetMapping(value = "allex",produces = "application/json;charset=utf-8")
	public List<Device> findAllDeviceex(){
		return this.manager.findAll();
	}
    
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Device saveOne( Device d){
        this.deviceManager.save(d);
        return d;
    }
    
    @RequestMapping(path = "/info",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public @ResponseBody Device updateOne( Device d){
        Device d1 =this.deviceManager.findById(d.getId());
        this.deviceManager.updateById(d.getId(),d.getName());
        return d1;
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody Device  deleteOne(@PathVariable(value = "id") Long id) {
        Device d = this.deviceManager.findById(id);
        this.deviceManager.deleteById(id);
        return d;
    }


	
}
