package edu.zut.cs.software.navigation.account.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.navigation.account.service.AccountManager;
import edu.zut.cs.software.navigation.admin.account.dao.AccountDao;
import edu.zut.cs.software.navigation.admin.account.daomain.Account;
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

}
