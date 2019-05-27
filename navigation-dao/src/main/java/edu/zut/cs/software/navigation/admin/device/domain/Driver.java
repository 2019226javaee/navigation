package edu.zut.cs.software.navigation.admin.device.domain;

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

@Table(name = "N_Driver")
@Entity
@NamedQueries({ @NamedQuery(name = "Driver.getRoot", query = "select d from Driver d where d.parent is null") })

public class Driver extends BaseTreeEntity<Driver> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "driver", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Device> devices;
	
	@Column(name = "Name")
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
