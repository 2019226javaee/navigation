package edu.zut.cs.software.navigation.admin.offset.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;

@Table(name="N_Point")
@Entity
public class Point extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="Name")
	String name;
	
	
	public Offset getOffset() {
		return offset;
	}

	public void setroad(Offset offset) {
		this.offset= offset;
	}

	@ManyToOne
	@JoinColumn(name = "ROAD_ID")
	Offset offset;

}