package edu.zut.cs.software.navigation.student.service;

import java.util.List;

import edu.zut.cs.software.navigation.admin.student.domain.Student;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public interface StudentManager extends GenericManager<Student, Long>{

	List<Student> findbyStudentname(String student);
}
