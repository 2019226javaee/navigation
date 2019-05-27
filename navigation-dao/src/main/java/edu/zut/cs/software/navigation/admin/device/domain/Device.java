package edu.zut.cs.software.navigation.admin.device.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.admin.device.domain.Driver;
import edu.zut.cs.software.navigation.base.domain.BaseEntity;

@Table(name= "N_Device")
@Entity

public class Device extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

    
    @Column(name="Name")
	String name;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(Device device) {
		// TODO Auto-generated method stub
		
	}
	@ManyToOne
	@JoinColumn(name = "Driver_ID")
	Driver driver;
}
