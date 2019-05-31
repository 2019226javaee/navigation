package edu.zut.cs.software.navigation.admin.account.daomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;


@Table(name = "N_Account")
@Entity
public class Account extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = -4376674977047164142L;

	@Column(name = "EMAIL")
	String email;
	@ManyToOne
	@JoinColumn(name = "Gather_ID")
	Gather gather;
	@Column(name = "PASSWORD")
	String password;
	@Column(name = "USERNAME")
	String username;
	@Column(name = "Sex")
	String sex;
	@Column(name = "Tel")
	String tel;
	@Column(name = "Wall")
	int wall;
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
			this.tel=tel;
	}public int getWall() {
		return wall;
	}

	public void setWall(int wall) {
		this.wall = wall;
	}


	public String getEmail() {
		return email;
	}

	public Gather getGather() {
		return gather;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoute(Gather gather) {
		this.gather = gather;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
