package edu.zut.cs.software.navigation.admin.location.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;

/*
 * 路线
 * 路线  -  位置
 * 一对多
 */



@Entity
@Table(name = "N_Routes")
@NamedQueries({ @NamedQuery(name = "Routes.getRoot", query = "select m from Routes m where m.parent is null") })
public class Routes extends BaseTreeEntity<Routes> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3111061350105299632L;

	


	@OneToMany(mappedBy = "routes", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Locations> locations;

	@Column(name = "startLocation")
	String startLocation;
	
	@Column(name = "endLocation")
	String endLocation;
	
	@Column(name = "Name")
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Locations> getLocations() {
		return locations;
	}
	public void setLocations(Set<Locations> locations) {
		this.locations = locations;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	





}