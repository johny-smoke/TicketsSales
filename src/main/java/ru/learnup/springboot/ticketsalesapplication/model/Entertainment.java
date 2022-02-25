package ru.learnup.springboot.ticketsalesapplication.model;

public class Entertainment {

    private String name;
    private String desc;
    private String ageGroup;
    private String data;
    private Integer cntTickets;


    public Entertainment(String name, String desc, String ageGroup, String data, Integer cntTickets) {
        this.name = name;
        this.desc = desc;
        this.ageGroup = ageGroup;
        this.data = data;
        this.cntTickets = cntTickets;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getAgeGroup() {
        return ageGroup;
    }
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Integer getCntTickets() {
        return cntTickets;
    }
    public void setCntTickets(Integer cntTickets) {
        this.cntTickets = cntTickets;
    }
}
