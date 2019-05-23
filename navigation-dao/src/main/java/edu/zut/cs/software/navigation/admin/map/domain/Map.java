package edu.zut.cs.software.navigation.admin.map.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.admin.place.domain.Place;
import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;

/*
 * 地图
 * 地图  -  地点
 * 一对多
 */



@Entity
@Table(name = "N_Map")
@NamedQueries({ @NamedQuery(name = "Shop.getmap", query = "select m from Map m") })
public class Map extends BaseTreeEntity<Map> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 514354346389706981L;


	@OneToMany(mappedBy = "map", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Place> places;

	@Column(name = "Name")
	String name;

	@Column(name = "Area")
	String area;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}




}