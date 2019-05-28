package edu.zut.cs.software.navigation.admin.student;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public void testCreate() throws Exception{
		
		List<Student> all = new ArrayList<Student>();
		
		FileInputStream fis = new FileInputStream(new File("Software17_Student_JavaEE.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("hello");
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		for(int i=1;i<=row.getLastCellNum();i++) {
			for(int j=0;j<=7;j++) {
				
			}
		}
	}
		
		
	
}
