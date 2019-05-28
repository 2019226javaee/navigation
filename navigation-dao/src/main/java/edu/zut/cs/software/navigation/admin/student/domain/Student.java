package edu.zut.cs.software.navigation.admin.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;

@Table(name= "N_Student")
@Entity
public class Student extends BaseEntity{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2910318908919177390L;
	
	@Column(name="NAME")
	String Name;
	@Column(name="CLASS")
	String CLass;
	@Column(name="SNO")
	String Sno;
	@Column(name="SEX")
	String Sex;
	@Column(name="GRADE")
	String Grade;
	@Column(name="MAJOR")
	String Major;
	@Column(name="SERIAL")
	String Serial;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCLass() {
		return CLass;
	}
	public void setCLass(String class1) {
		CLass = class1;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getSerial() {
		return Serial;
	}
	public void setSerial(String serial) {
		Serial = serial;
	}
}
