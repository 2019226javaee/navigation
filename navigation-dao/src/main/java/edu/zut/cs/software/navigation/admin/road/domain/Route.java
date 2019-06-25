package edu.zut.cs.software.navigation.admin.road.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;

@Table(name="N_Route")
@Entity
public class Route extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name="Name")
	String name;
	
	@Column(name="Number")
	String number;
	
	@Column(name="Zlength")
	String zlength;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getZlength() {
		return zlength;
	}

	public void setZlength(String zlength) {
		this.zlength = zlength;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Road getRoad() {
		return road;
	}

	public void setroad(Road road) {
		this.road = road;
	}

	@ManyToOne
	@JoinColumn(name = "ROAD_ID")
	Road road;

}
