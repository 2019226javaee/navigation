package edu.zut.cs.software.navigation.admin.place.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.base.domain.BaseEntity;
/*
 * 地点
 * 地点-地图
 * Many to one
 */
@Table(name= "N_Place")
@Entity
public class Place extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8223175360331280998L;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Long id;
	@Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Column(name="Name")
	String name;
	
	public String getLeftlocation() {
		return leftlocation;
	}

	public void setLeftlocation(String leftlocation) {
		this.leftlocation = leftlocation;
	}

	public String getRightlocation() {
		return rightlocation;
	}

	public void setRightlocation(String rightlocation) {
		this.rightlocation = rightlocation;
	}

	@Column(name="LLocation")
	String leftlocation;
	@Column(name="RLocation")
	String rightlocation;
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@ManyToOne
	@JoinColumn(name = "map-id")
	Map map;

}
