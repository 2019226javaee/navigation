package edu.zut.cs.software.navigation.device.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.device.domain.Keeper;
import edu.zut.cs.software.navigation.admin.device.dao.KeeperDao;
import edu.zut.cs.software.navigation.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.navigation.device.service.KeeperManager;

@Component
public class KeeperManagerImpl extends GenericTreeManagerImpl<Keeper, Long> implements KeeperManager{
	KeeperDao keeperDao;

    @Autowired
    public void setDriverDao(KeeperDao keeperDao) {
        this.keeperDao = keeperDao;
        this.dao = this.keeperDao;
        this.dao = this.treeDao;
    }

	@Override
	public List<Keeper> findbyKeepername(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
