package edu.zut.cs.software.navigation.device.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.admin.device.dao.DeviceDao;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.device.service.DeviceManager;

@Component
public class DeviceManagerImpl extends GenericManagerImpl<Device, Long> implements DeviceManager{
	
	DeviceDao deviceDao;
	  @Autowired
	    public void setDeviceDao(DeviceDao deviceDao) {
	        this.deviceDao = deviceDao;
	        this.dao = this.deviceDao;
	    }

		@Override
		public List <Device> findbyDevicename(String devicename) {
			Device queryObject = new Device();
			queryObject.setName(devicename);
			queryObject.setDateCreated(null);
			queryObject.setDateModified(null);
			ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("devicename", ExampleMatcher.GenericPropertyMatchers.startsWith());
			Example<Device> example = Example.of(queryObject,matcher);
			List<Device> result = this.dao.findAll(example);
			return result;
		}
		
		   @Override
		    public List<Device> findAll(){
		    	List<Device> result = this.dao.findAll();
		    	return result;
		    }
		    
		    @Override
			public void deleteById(Long id) {
				dao.deleteById(id);
			}
		    @Override
			public void updateById(Long id,String name,String app) {
		    	Device d = dao.getOne(id);
				d.setName(name);
				d.setApp(app);
				this.save(d);
		    }
		    @Override
			public void create(String name,String app) {
				Device d = new Device();
				d.setName(name);
				d.setApp(app);
				this.save(d);
			}

			@Override
			public List<Device> findbydevicename(String devicename) {
				// TODO Auto-generated method stub
				return null;
			}

			

			@Override
			public void updateById(Long id, String name) {
				// TODO Auto-generated method stub
				
			}

}

