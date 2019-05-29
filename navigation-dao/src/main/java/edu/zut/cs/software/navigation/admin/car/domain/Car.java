package edu.zut.cs.software.navigation.admin.car.domain;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.*;

/*
 * 汽车
 * 汽车  -  司机
 * 多对一
 */
@Entity
@Table(name = "N_Car")
@NamedQueries({ @NamedQuery(name = "Car.getcar", query = "select m from Car m") })
public class Car extends BaseEntity{
    private static final long serialVersionUID = 4544984464660125071L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name="Name")
    String name;

    public String getFastcar() { return fastcar; }

    public void setFastcar(String fastcar) {
        this.fastcar = fastcar;
    }

    public String getShunfengcar() {
        return shunfengcar;
    }

    public void setShunfengcar(String sunfengcar) {
        this.shunfengcar = shunfengcar;
    }

    @Column(name="Fastcar")
    String fastcar;
    @Column(name="Sfcar")
    String shunfengcar;
    public Driver getDriver() {
        return driver;
    }

    public void setDriver( Driver driver) {
        this.driver = driver;
    }

    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    Driver driver;
}
