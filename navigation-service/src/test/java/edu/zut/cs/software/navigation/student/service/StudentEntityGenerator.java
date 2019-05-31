package edu.zut.cs.software.navigation.student.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.student.domain.Student;
import edu.zut.cs.software.navigation.base.service.GenericGenerator;

public class StudentEntityGenerator extends GenericGenerator{

	List<Student> studentList;
	StudentManager studentManager;
	
	@Autowired
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}
	
	@Test
	public void setUp() throws IOException {
		this.studentList = new ArrayList<Student>();
		URL l=Thread.currentThread().getContextClassLoader().getResource("Software17_Student_JavaEE.xlsx");
		FileInputStream fileInputStream = new FileInputStream(l.getFile());
		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			Student s = new Student();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					if (j == 1)
						s.setGrade(String.valueOf(cell));
					if (j == 2)
						s.setMajor(String.valueOf(cell));
					if (j == 3)
						s.setCLass(String.valueOf(cell));
					if (j == 0)
						s.setSerial(String.valueOf(cell));
					if (j == 5)
						s.setSno(String.valueOf(cell));
					if (j == 6)
						s.setName(String.valueOf(cell));
					if (j == 7)
						s.setSex(String.valueOf(cell));
				}
			}
			studentList.add(s);
			this.studentManager.save(s);
		}
	}
	@Test
	public void testFindAll() {
		
		List<Student> result = this.studentManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Student> result=" + result); //$NON-NLS-1$
		}
	}

}
