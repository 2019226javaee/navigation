package edu.zut.cs.software.navigation.device.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import edu.zut.cs.software.navigation.admin.device.domain.Device;
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
	public String findAllDevice() {
    	List<Device> deviceList = this.manager.findAll();
        PageInfo pageInfo = new PageInfo(deviceList);
        return JSON.toJSONString(pageInfo);
	}
    
    @ResponseBody
	@GetMapping(value = "allex",produces = "application/json;charset=utf-8")
	public List<Device> findAllDeviceex(){
		return this.manager.findAll();
	}


	
}
