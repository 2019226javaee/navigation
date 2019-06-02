package edu.zut.cs.software.navigation.admin.location.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;
/*
 * 地点
 * 地点-地图
 * Many to one
 */
@Table(name= "N_Locations")
@Entity
public class Locations extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8223175360331280998L;
	
	
	@Column(name="X")
	Integer X;
	
	@Column(name="Y")
	Integer Y;
	@Column(name="name")
	String name;

	@ManyToOne
	@JoinColumn(name = "Route_ID")
	Routes routes;

	public Integer getX() {
		return X;
	}

	public void setX(Integer leftlocation) {
		this.X = leftlocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getY() {
		return Y;
	}

	public void setY(Integer Y) {
		this.Y = Y;
	}
	
	public Routes getRoutes() {
		return routes;
	}

	public void setRoutes(Routes routes) {
		this.routes = routes;
	}

	
}
