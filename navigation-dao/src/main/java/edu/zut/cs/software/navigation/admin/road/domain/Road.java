package edu.zut.cs.software.navigation.admin.road.domain;

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



@Entity
@Table(name= "N_Road")
@NamedQueries(value = { @NamedQuery(name = "Road.getRoot", query = "select m from Road m") })
public class Road extends BaseTreeEntity<Road>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@OneToMany(mappedBy = "road", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Route> routes;

	@Column(name="Name")
	String name;
	
	@Column(name="Length")
	float length;
	
	@Column(name="Start")
		String start;
	
	@Column(name="End")
	String end;
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	
	public float getlength() {
		return length;
	}
	public void setlength(float length) {
		this.length=length;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public void setParent(Road road) {
		// TODO Auto-generated method stub
		
	}
}