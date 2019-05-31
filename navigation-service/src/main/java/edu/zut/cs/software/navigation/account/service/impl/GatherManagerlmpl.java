package edu.zut.cs.software.navigation.account.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.navigation.account.service.GatherManager;
import edu.zut.cs.software.navigation.admin.account.dao.GatherDao;
import edu.zut.cs.software.navigation.admin.account.daomain.Gather;
import edu.zut.cs.software.navigation.base.service.impl.GenericTreeManagerImpl;
@Service(value = "gatherManager")
public class GatherManagerlmpl extends GenericTreeManagerImpl<Gather, Long> implements GatherManager {

	GatherDao gatherDao;

	@Autowired
	public void setGatherDao(GatherDao gatherDao) {
		this.gatherDao = gatherDao;
		this.treeDao = this.gatherDao;
		this.dao = this.treeDao;
	}

}
