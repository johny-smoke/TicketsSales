package ru.learnup.springboot.ticketsalesapplication.model;

import lombok.Data;

@Data
public class Entertainment {

    private String name;
    private String descr;
    private String ageGroup;

    public Entertainment(String name, String descr, String ageGroup) {
        this.name = name;
        this.descr = descr;
        this.ageGroup = ageGroup;
    }
}
