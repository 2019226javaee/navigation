package edu.zut.cs.software.navigation.admin.offset.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.admin.offset.domain.Point;
import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;

/*
 * 地图
 * 一对多
 */
@Entity
@Table(name = "N_Offset")
@NamedQueries({ @NamedQuery(name = "Offset.getRoot", query = "select m from Offset m where m.parent is null") })
public class Offset extends BaseTreeEntity<Offset> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 981L;


	@OneToMany(mappedBy = "offset", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Point> points;
	@Column(name = "Name")
	String name;

	@Column(name = "Coordinate")
	String coordinate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate=coordinate;
	}
}