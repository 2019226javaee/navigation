package edu.zut.cs.software.navigation.offset.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.admin.offset.dao.OffsetDao;
import edu.zut.cs.software.navigation.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.navigation.offset.service.OffsetManager;
@Service(value = "offsetManager")
public  class OffsetManagerImpl extends GenericTreeManagerImpl<Offset, Long> implements OffsetManager{

	OffsetDao offsetDao;
	@Autowired
	public void setOffsetDao( OffsetDao offsetDao) {
		this.offsetDao = offsetDao;
		this.treeDao = this.offsetDao;
		this.dao=this.treeDao;
	}
	public Offset findbyOffsetname(String road) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
