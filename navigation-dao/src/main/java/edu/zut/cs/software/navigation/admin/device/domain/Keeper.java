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

@Table(name = "N_Keeper")
@Entity
@NamedQueries({ @NamedQuery(name = "Keeper.getRoot", query = "select k from Keeper k where k.parent is null") })

public class Keeper extends BaseTreeEntity<Keeper> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "keeper", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Device> devices;
	
	@Column(name = "Name")
	String name;
	
	@Column(name = "Access")
	String access;
	
	
	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

