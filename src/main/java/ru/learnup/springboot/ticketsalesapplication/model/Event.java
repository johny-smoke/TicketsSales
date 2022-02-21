package ru.learnup.springboot.ticketsalesapplication.model;

public class Event {

    private String name;
    private String desc;
    private String ageGroup;
    private Integer cntTickets;

    public Event(String name, String desc, String ageGroup, Integer cntTickets) {
        this.name = name;
        this.desc = desc;
        this.ageGroup = ageGroup;
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
    public Integer getCntTickets() {
        return cntTickets;
    }
    public void setCntTickets(Integer cntTickets) {
        this.cntTickets = cntTickets;
    }
}
