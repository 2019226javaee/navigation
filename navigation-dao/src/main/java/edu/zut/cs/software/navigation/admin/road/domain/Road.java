package edu.zut.cs.software.navigation.admin.road.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;



@Entity
@Table(name= "N_Road")
@NamedQueries(value = { @NamedQuery(name = "Road.getmap", query = "select m from Road m") })
public class Road extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	Long id;
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="Name")
	String name;
	
	@Column(name="Length")
	float length;
	
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
}