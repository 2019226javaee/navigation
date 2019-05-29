package edu.zut.cs.software.navigation.admin.car.domain;

import edu.zut.cs.software.navigation.admin.map.domain.Place;
import edu.zut.cs.software.navigation.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/*
 * 司机
 * 司机  -  车
 * 一对多
 */
@Entity
@Table(name = "N_Driver")
public class Driver extends BaseTreeEntity<Driver> {


    private static final long serialVersionUID = -6482806358337009465L;


    @OneToMany(mappedBy = "driver", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Place> cars;

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
