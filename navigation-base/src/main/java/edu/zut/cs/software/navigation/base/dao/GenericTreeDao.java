package edu.zut.cs.software.navigation.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;


@NoRepositoryBean
public abstract interface GenericTreeDao<T extends BaseTreeEntity<T>, PK extends Serializable>
		extends GenericDao<T, PK> {
	List<T> getRoot();
}