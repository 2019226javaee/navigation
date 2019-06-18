package edu.zut.cs.software.navigation.admin.map.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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


	
	@Column(name="Name")
	String name;
	

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@Column(name="LocationX")
	String x;
	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}



	@Column(name="LocationY")
	String y;



	@ManyToOne
	@JoinColumn(name = "MAP_ID")
	Map map;

}
