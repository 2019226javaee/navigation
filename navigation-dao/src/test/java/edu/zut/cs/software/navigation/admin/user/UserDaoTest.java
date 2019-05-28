package edu.zut.cs.software.navigation.admin.user;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.user.dao.UserDao;
import edu.zut.cs.software.navigation.admin.user.daomain.User;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

public class UserDaoTest extends GenericDaoTestCase<Long, User, UserDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserDaoTest.class.getName());

	@Autowired
	UserDao userDao;

	@Test
	public void testFindAll() {

		List<User> result = this.userDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<User> result={}", result); //$NON-NLS-1$
		}

	}

}
