package edu.zut.cs.software.navigation.admin.device;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.device.dao.DeviceDao;
import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

public class DeviceDaoTest extends GenericDaoTestCase<Long,Device, DeviceDao> {
	
	private static final Logger logger = LogManager.getLogger(DeviceDaoTest.class.getName());

	@Autowired
	DeviceDao deviceDao;
	
	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
		this.dao = this.deviceDao;
	}
	
	@Test
	public void testGetRoot() {
		int root_size = 10;
		for (int i = 0; i < root_size; i++) {
			Device device = new Device();
			device.setName("device_" + i);
			for (int j = 0; j < 10; j++) {
				Device g = new Device();
				g.setName("device_" + i + "_" + j);
				g.setParent(device);
			}
			this.deviceDao.save(device);
		}
		
		List<Device> roots = this.deviceDao.findAll();
		assertEquals(root_size, roots.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Device> roots={}", roots); 
		}
}
}
