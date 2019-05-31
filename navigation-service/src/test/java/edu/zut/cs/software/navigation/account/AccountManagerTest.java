package edu.zut.cs.software.navigation.account;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.account.service.AccountManager;
import edu.zut.cs.software.navigation.admin.account.daomain.Account;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;
public class AccountManagerTest extends GenericManagerTestCase<Long, Account, AccountManager> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(AccountManagerTest.class.getName());

	AccountManager accountManager;

	public AccountManagerTest() {
		super(Account.class);
	}

	@Autowired
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	@Test
	public void testGetAll() {
		List<Account> all = this.accountManager.getAll();
		assertNotNull(all);
//		assertEquals(100, all.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<User> all={}", all); //$NON-NLS-1$
		}
	}

	@Test
	public void testSayHello() {
		String expected = "Hello, world!";
		String result = this.accountManager.sayHello("world");
		if (logger.isInfoEnabled()) {
			logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected, result);
	}
}
