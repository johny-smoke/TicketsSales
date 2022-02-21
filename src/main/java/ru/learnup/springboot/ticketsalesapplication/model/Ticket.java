package ru.learnup.springboot.ticketsalesapplication.model;

public class Ticket {
    private String eventName;

    public Ticket(String eventName) {
        this.eventName = eventName;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
