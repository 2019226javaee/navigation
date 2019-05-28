package edu.zut.cs.software.navigation.admin.student;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.student.dao.StudentDao;
import edu.zut.cs.software.navigation.admin.student.domain.Student;
import edu.zut.cs.software.navigation.base.dao.GenericDaoTestCase;

public class StudentDaoTest extends GenericDaoTestCase<Long, Student, StudentDao>{

	
	//private static final Logger logger = LogManager.getLogger(PlaceDaoTest.class.getName());
	
	@Autowired
	StudentDao studentDao;
	
	@Test
	public void testCreate() {
		
	}
		
		
	
}
