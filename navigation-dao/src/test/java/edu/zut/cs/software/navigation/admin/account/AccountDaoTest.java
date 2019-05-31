package edu.zut.cs.software.navigation.admin.account;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import edu.zut.cs.software.navigation.admin.account.dao.AccountDao;
import edu.zut.cs.software.navigation.admin.account.daomain.Account;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

public class AccountDaoTest extends GenericDaoTestCase<Long, Account, AccountDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(AccountDaoTest.class.getName());

	@Autowired
	AccountDao accountDao;

	@Test
	public void testFindAll() {

		List<Account> result = this.accountDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<Account> result={}", result); //$NON-NLS-1$
		}

	}

}
