package edu.zut.cs.software.navigation.admin.car.domain;

import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*
 * 汽车
 * 汽车  -  司机
 * 多对一
 */
@Entity
@Table(name = "N_Car")
@NamedQueries({ @NamedQuery(name = "car.getcar", query = "select m from Car m") })
public class Car extends BaseTreeEntity<Car> {
    private static final long serialVersionUID = 4544984464660125071L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
