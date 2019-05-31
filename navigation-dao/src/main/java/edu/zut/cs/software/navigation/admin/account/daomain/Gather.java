package edu.zut.cs.software.navigation.admin.account.daomain;

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


@Table(name = "N_Gather")
@Entity
@NamedQueries({ @NamedQuery(name = "Gather.getRoot", query = "select g from Gather g where g.parent is null") })
public class Gather extends BaseTreeEntity<Gather> {

	/**
	 *
	 */
	private static final long serialVersionUID = -1751952224371998469L;

	@Column(name = "NAME")
	String name;

	@OneToMany(mappedBy = "gather", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Account> accounts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
