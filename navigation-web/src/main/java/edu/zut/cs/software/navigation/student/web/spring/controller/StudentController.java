package edu.zut.cs.software.navigation.student.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.admin.student.domain.Student;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
import edu.zut.cs.software.navigation.student.service.StudentManager;

@Controller
@RequestMapping("/student")
public class StudentController extends GenericController<Student, Long, StudentManager>{

	StudentManager studentManager;
	
	@Autowired
    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
        this.manager = this.studentManager;
    }
	
	@ResponseBody
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Student> findAllStudent(){
		return this.manager.findAll();
	}
}
