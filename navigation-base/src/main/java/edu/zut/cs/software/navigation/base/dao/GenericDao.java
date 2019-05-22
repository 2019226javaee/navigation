package edu.zut.cs.software.navigation.base.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;


@NoRepositoryBean
public interface GenericDao<T extends BaseEntity, PK extends Serializable>
		extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
}