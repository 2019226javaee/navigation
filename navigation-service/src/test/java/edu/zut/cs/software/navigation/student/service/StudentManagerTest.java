package edu.zut.cs.software.navigation.student.service;


import edu.zut.cs.software.navigation.admin.student.domain.Student;
import edu.zut.cs.software.navigation.base.service.GenericManagerTestCase;

public class StudentManagerTest extends GenericManagerTestCase<Long, Student, StudentManager>{

	StudentManager studentManager;
	
	public StudentManagerTest() {
		super(Student.class);
	}
	
}
