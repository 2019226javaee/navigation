package edu.zut.cs.software.navigation.device.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.device.domain.Driver;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class DriverManagerTest extends GenericManagerTestCase<Long, Driver, DriverManager>{
	@Autowired
    DriverManager driverManager; 

    public DriverManagerTest() {
        super(Driver.class);
    }
}
