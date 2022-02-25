package ru.learnup.springboot.ticketsalesapplication.model;

public class Ticket {
    private String entertainmentName;

    public Ticket(String entertainmentName) {
        this.entertainmentName = entertainmentName;
    }
    public String getEntertainmentName() {
        return entertainmentName;
    }
    public void setEntertainmentName(String entertainmentName) {
        this.entertainmentName = entertainmentName;
    }
}
