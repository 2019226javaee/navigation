package edu.zut.cs.software.navigation.device.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface DeviceManager extends GenericManager<Device, Long>{
	List<Device> findbyDevicename(String device);
	

	List<Device> findbydevicename(String devicename);
	
	
	 void deleteById(Long id);
	 
	 void updateById(Long id,String name);
	 
	 void updateById(Long id,String name,String app);
	 
	 void create(String name,String app);


}
