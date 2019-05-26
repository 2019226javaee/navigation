package edu.zut.cs.software.navigation.base.dao;

import java.io.Serializable;
import java.util.List;

import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;

import edu.zut.cs.software.navigation.base.BaseAbstractTestCase;
import edu.zut.cs.software.navigation.base.domain.BaseEntity;

/**
 */
@ContextConfiguration(locations = { "classpath:/applicationContextTest-resources.xml",
"classpath:/applicationContext-dao.xml" })
public class GenericDaoTestCase<PK extends Serializable, T extends BaseEntity, D extends GenericDao<T, PK>>
		extends BaseAbstractTestCase {

	protected D dao;

	protected T entity;

	protected PK id;

	protected List<T> list;

	@Before
	public void setUp() throws Exception {

	}
}