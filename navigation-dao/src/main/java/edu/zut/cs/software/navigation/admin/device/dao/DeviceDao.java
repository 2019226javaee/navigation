package edu.zut.cs.software.navigation.admin.device.dao;

import java.util.List;

import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.base.dao.GenericDao;

public interface DeviceDao extends GenericDao<Device, Long> {

	List<Device> getRoot();

}