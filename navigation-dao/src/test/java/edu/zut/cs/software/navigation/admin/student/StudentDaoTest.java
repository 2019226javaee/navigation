package edu.zut.cs.software.navigation.admin.student;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.map.PlaceDaoTest;
import edu.zut.cs.software.navigation.admin.student.dao.StudentDao;
import edu.zut.cs.software.navigation.admin.student.domain.Student;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

public class StudentDaoTest extends GenericDaoTestCase<Long, Student, StudentDao>{

private static final Logger logger = LogManager.getLogger(PlaceDaoTest.class.getName());
	
	@Autowired
	StudentDao studentDao;
	
	@Test
	public void testFindAll() {
		
		List<Student> all = this.studentDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<place> all={}", all); 
		}	
	}
}

