package edu.zut.cs.software.navigation.account.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.navigation.account.service.AccountManager;
import edu.zut.cs.software.navigation.admin.account.dao.AccountDao;
import edu.zut.cs.software.navigation.admin.account.daomain.Account;
import edu.zut.cs.software.navigation.admin.location.domain.Locations;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
@Service("accountManager")
public class AccountManagerImpl extends GenericManagerImpl<Account,Long> implements AccountManager {

	
	AccountDao accountDao;
	
	@Autowired
	public void setUserDao(AccountDao accountDao) {
		this.accountDao = accountDao;
		this.dao = this.accountDao;
	}

	@Override
	public String sayHello(String name) {
		String result = "Hello, " + name + "!";
		if (logger.isInfoEnabled()) {
			logger.info("sayHello(String) - String result={}", result); //$NON-NLS-1$
		}

		return result;
	}

	@Override
	public List<Account> getAll() {
		List<Account> all = this.accountDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("getAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		return all;
	}

	@Override
	public Locations findbyName(String name){
		Account queryObject = new Account();
		queryObject.setUsername(name);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Account> example = Example.of(queryObject,matcher);
		List<Account> result = this.dao.findAll(example);
		Account ob = result.get(0);
		ob.getLocation();
		return ob.getLocation();
	}
}
