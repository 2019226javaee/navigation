package edu.zut.cs.software.navigation.device.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
	public List<Keeper> findbyKeepername(String keepername) {
		Keeper queryObject = new Keeper();
		queryObject.setName(keepername);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("keepername", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Keeper> example = Example.of(queryObject,matcher);
		List<Keeper> result = this.dao.findAll(example);
		return result;
	}
	
	   @Override
	    public List<Keeper> findAll(){
	    	List<Keeper> result = this.dao.findAll();
	    	return result;
	    }
	    
	    @Override
		public void deleteById(Long id) {
			dao.deleteById(id);
		}
	    @Override
		public void updateById(Long id,String name,String access) {
	    	Keeper k = dao.getOne(id);
			k.setName(name);
			k.setAccess(access);
			this.save(k);
	    }
	    @Override
		public void create(String name,String access) {
			Keeper k = new Keeper();
			k.setName(name);
			k.setAccess(access);
			this.save(k);
		}
}
