package edu.zut.cs.software.navigation.admin.device;

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
	
	@Test
	public void testFindAll() {
		
		List<Device> all = this.deviceDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<device> all={}", all); 
		}	
	}

}
