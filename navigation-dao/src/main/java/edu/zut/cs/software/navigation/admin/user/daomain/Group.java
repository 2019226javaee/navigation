package edu.zut.cs.software.navigation.admin.user.daomain;

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


@Table(name = "T_ADMIN_GROUP")
@Entity
@NamedQueries({ @NamedQuery(name = "Group.getRoot", query = "select g from Group g where g.parent is null") })
public class Group extends BaseTreeEntity<Group> {

	/**
	 *
	 */
	private static final long serialVersionUID = -1751952224371998469L;

	@Column(name = "NAME")
	String name;

	@OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
