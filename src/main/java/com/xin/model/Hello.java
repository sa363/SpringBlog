package com.xin.model;

import javax.persistence.*;

/**
 * Author: Xin
 * Date: 14-5-4
 * Time: 下午1:52
 */
@Entity
@Table(name = "hello")
public class Hello {



    private Integer id;
    private String name;
    private String remarks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
