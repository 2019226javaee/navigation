package edu.zut.cs.software.navigation.device.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.device.domain.Keeper;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class KeeperManagerTest extends GenericManagerTestCase<Long, Keeper, KeeperManager>{
	@Autowired
    KeeperManager keeperManager; 

    public KeeperManagerTest() {
        super(Keeper.class);
    }
}
