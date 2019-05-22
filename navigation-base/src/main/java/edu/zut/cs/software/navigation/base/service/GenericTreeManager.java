package edu.zut.cs.software.navigation.base.service;

import java.io.Serializable;
import java.util.List;

import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;

/**
 * Generic Manager that talks to GenericDao to CRUD POJOs.
 * @author
 */
@SuppressWarnings("rawtypes")
public interface GenericTreeManager<T extends BaseTreeEntity, PK extends Serializable> extends GenericManager<T, PK> {

	/**
	 * 获取制定id的全部祖先实体集合；
	 *
	 * @param id
	 * @return
	 */
	public List<T> getAncestors(PK id);

	/**
	 * 获取制定id的直接孩子实体集合；
	 *
	 * @param id
	 * @return
	 */
	public List<T> getChildren(PK id);

	/**
	 * 获取制定id的全部子孙实体集合；
	 *
	 * @param id
	 * @return
	 */
	public List<T> getDescendants(PK id);

	/**
	 * 获取根节点实体集合
	 *
	 * @return
	 */
	public List<T> getRoot();

}