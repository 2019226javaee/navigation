package edu.zut.cs.software.navigation.device.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.device.domain.Driver;
import edu.zut.cs.software.navigation.admin.device.dao.DriverDao;
import edu.zut.cs.software.navigation.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.navigation.device.service.DriverManager;

@Component
public class DriverManagerImpl extends GenericTreeManagerImpl<Driver, Long> implements DriverManager{
	DriverDao driverDao;

    @Autowired
    public void setDriverDao(DriverDao driverDao) {
        this.driverDao = driverDao;
        this.dao = this.driverDao;
        this.dao = this.treeDao;
    }
}
