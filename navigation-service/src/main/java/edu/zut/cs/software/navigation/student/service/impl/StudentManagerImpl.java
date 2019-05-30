package edu.zut.cs.software.navigation.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.student.dao.StudentDao;
import edu.zut.cs.software.navigation.admin.student.domain.Student;
import edu.zut.cs.software.navigation.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.navigation.student.service.StudentManager;

@Component
public class StudentManagerImpl extends GenericManagerImpl<Student, Long> implements StudentManager{

	StudentDao studentDao;
	
	
	@Override
	public List<Student> findbyStudentname(String student){
		return null;
	}
	@Autowired
	public void setPlaceDao(StudentDao studentDao) {
		this.studentDao = studentDao;
		this.dao = this.studentDao;
	}
}
