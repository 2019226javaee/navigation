package edu.zut.cs.software.navigation.base.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.zut.cs.software.navigation.base.dao.GenericTreeDao;
import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;
import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>
 * To register this class in your Spring context file, use the following XML.
 *
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
@Transactional
public class GenericTreeManagerImpl<T extends BaseTreeEntity<T>, PK extends Serializable>
		extends GenericManagerImpl<T, PK> implements GenericTreeManager<T, PK> {

	protected GenericTreeDao<T, PK> treeDao;

	@Override
	public List<T> getAncestors(PK id) {
		List<T> ancestors = new ArrayList<T>();
		T entity = this.treeDao.getOne(id);
		T parent = entity.getParent();
		while (parent != null) { // 追述祖先
			ancestors.add(parent);
			entity = parent;
			parent = entity.getParent();
		}
		return ancestors;
	}

	@Override
	public List<T> getChildren(PK id) {
		T entity = this.treeDao.getOne(id);
		return entity.getChildren();
	}

	@Override
	public List<T> getDescendants(PK id) {
		List<T> descendants = new ArrayList<T>();
		List<T> children = this.getChildren(id);
		if (children != null && children.size() > 0) { // 追加子孙
			descendants.addAll(children);
			for (T t : children) {
				@SuppressWarnings("unchecked")
				List<T> descendants2 = this.getDescendants((PK) t.getId());
				descendants.addAll(descendants2);
			}
		}
		// if (children != null && children.size() > 0) {
		// descendants.addAll(children);
		// for (T t : children) {
		// @SuppressWarnings("unchecked")
		// List<T> descendants2 = this.getDescendants((PK) t.getId());
		// descendants.addAll(descendants2);
		// }
		// }
		return descendants;
	}

	@Override
	public List<T> getRoot() {
		return this.treeDao.getRoot();
	}
}