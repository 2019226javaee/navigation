package edu.zut.cs.software.navigation.base.service;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;

import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;

public abstract class GenericTreeManagerTestCase<PK extends Serializable, T extends BaseTreeEntity<T>, M extends GenericTreeManager<T, PK>>
		extends GenericManagerTestCase<PK, T, M> {

	public GenericTreeManagerTestCase(Class<T> persistentClass) {
		super(persistentClass);
	}

	@Test
	public void testGetRoot() {
		List<T> result = this.manager.getRoot();
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<T> result=" + result); //$NON-NLS-1$
		}

	}

}