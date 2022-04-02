package ru.learnup.springboot.ticketsalesapplication.model;

import lombok.Data;

@Data
public class Entertainment {

    private Integer id;
    private String name;
    private String descr;
    private String ageGroup;

    public Entertainment(Integer id, String name, String descr, String ageGroup) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.ageGroup = ageGroup;
    }
}
