package edu.zut.cs.software.navigation.device.service;

import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface DeviceManager extends GenericManager<Device, Long>{
	Device findbyDevicename(String device);
}
