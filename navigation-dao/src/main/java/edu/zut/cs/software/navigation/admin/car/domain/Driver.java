package edu.zut.cs.software.navigation.admin.car.domain;

import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * 司机
 * 司机  -  车
 * 一对多
 */
@Entity
@Table(name = "N_Driver")
@NamedQueries({ @NamedQuery(name = "Car.getRoot", query = "select m from Car m where m.parent is null") })
public class Driver extends BaseTreeEntity<Driver> {


    private static final long serialVersionUID = -6482806358337009465L;


    @OneToMany(mappedBy = "driver", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Car> cars;

    @Column(name = "Name")
    String name;

    @Column(name = "Sex")
    String sex;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
