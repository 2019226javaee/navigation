package edu.zut.cs.software.navigation.admin.device.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;

@Table(name= "N_Device")
@Entity

public class Device extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="ID")
	Long id;
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    
    @Column(name="Name")
	String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(Device device) {
		// TODO Auto-generated method stub
		
	}
}
