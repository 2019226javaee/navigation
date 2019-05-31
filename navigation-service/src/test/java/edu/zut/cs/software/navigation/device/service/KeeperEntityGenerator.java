package edu.zut.cs.software.navigation.device.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.device.domain.Keeper;
import edu.zut.cs.software.navigation.admin.device.domain.Device;
import edu.zut.cs.software.navigation.base.service.GenericGenerator;

public class KeeperEntityGenerator extends GenericGenerator {
	@Autowired
	KeeperManager keeperManager;
	@Autowired
    DeviceManager deviceManager;
	
	
	@Test
    public void testKeeperGeneration() {
        for (int i = 0; i < 3; i++) {
            Keeper k = new Keeper();
            k.setName("keeper_" + i);
            this.keeperManager.save(k);
            List<Keeper> list = new ArrayList<Keeper>();
            for (int j = 0; j < 3; j++) {
                Keeper keeper = new Keeper();
                keeper.setName("keeper_" + i + "_" + j);
                keeper.setParent(k);
                list.add(keeper);
            }
            this.keeperManager.save(list);
        }
    }
	
	public void testDeviceGeneration(Keeper k) {
		for(int i = 1; i < 5; i++) {
			Device d = new Device();
			d.setName("device_" + i);
			d.setKeeper(k);
			this.deviceManager.save(d);
		}
	}
	@Test
	public void test() {
		this.keeperManager.findAll();
	}
}
