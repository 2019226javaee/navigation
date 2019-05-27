package edu.zut.cs.software.navigation.device.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.admin.device.dao.DeviceDao;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.device.service.DeviceManager;

@Component
public class DeviceManagerImpl extends GenericManagerImpl<Device, Long> implements DeviceManager{
	DeviceDao deviceDao;
	@Override
	public Device findbyDevicename(String devicename) {
		return null;
	}
	
	@Autowired
	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
		this.dao = this.deviceDao;
	}
}
