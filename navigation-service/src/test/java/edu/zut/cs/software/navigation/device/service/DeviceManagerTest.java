package edu.zut.cs.software.navigation.device.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class DeviceManagerTest extends GenericManagerTestCase<Long, Device, DeviceManager>{
	DeviceManager deviceManager;
	
	public DeviceManagerTest() {
		super(Device.class);
	}
	
	@Autowired
	public void setCustomerManager(DeviceManager deviceManager) {
		this.deviceManager = deviceManager;
		this.manager = this.deviceManager;
	}

	@Override
	public void setUp() throws Exception {
		Device device = new Device();
		device.setName("手机");
		this.entity = this.manager.save(device);
	}
	
	
	
	@Test
	public void testfindAll() {
		List<Device> all = this.deviceManager.findAll();
		all.toString();
	}
}