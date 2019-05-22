package edu.zut.cs.software.navigation.base.domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@MappedSuperclass
@Access(value=AccessType.FIELD)
public class BaseTreeEntity<T extends BaseTreeEntity<T>> extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = -5961264427451119166L;

	@JsonManagedReference("parent-children")
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<T> children;

	@Transient
	boolean leaf = true;

	@JsonBackReference("parent-children")
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	T parent;

	@Column(name = "TEXT")
	String text;

	public List<T> getChildren() {
		return children;
	}

	public T getParent() {
		return parent;
	}

	public String getText() {
		return text;
	}

	public boolean isLeaf() {
		if (null != this.children && this.children.size() > 0) {
			this.leaf = false;
		} else {
			this.leaf = true;
		}
		return leaf;
	}

	public void setChildren(List<T> children) {
		this.children = children;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public void setParent(T parent) {
		this.parent = parent;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE, false);
	}

}