package edu.zut.cs.software.navigation.offset.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
	public List<Offset> findbyOffsetname(String offsetname) {
		Offset queryObject = new Offset();
		queryObject.setName(offsetname);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("offsetname", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Offset> example = Example.of(queryObject,matcher);
		List<Offset> result = this.dao.findAll(example);
		return result;
	}
	
}
