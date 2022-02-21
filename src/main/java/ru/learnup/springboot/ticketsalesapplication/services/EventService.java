package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.stereotype.Service;
import ru.learnup.springboot.ticketsalesapplication.model.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    public Map<String, Event> events = new HashMap<>();

    public Event checkEvent(String name){
        if (!events.containsKey(name)) {
            throw new IllegalArgumentException("Премьеры с таким именем не существует");
        }
        else {
            return events.get(name);
        }
    }
    public void addEvent(Event premier){
        events.put(premier.getName(), premier);
    }
    public Event getEvent(String name) {
        return checkEvent(name);
    }
    public Map<String, Event> getAllEvents() {
        return events;
    }
    public void showAllEvents() {
        for (Map.Entry<String, Event> row : this.events.entrySet()) {
            Event premier = row.getValue();
            System.out.println("Премьера " + premier.getName() +
                               ": " + premier.getDesc() +
                               " возрастная категория " + premier.getAgeGroup() +
                               " количество билетов в наличии " + premier.getCntTickets());
        }
    }

    public void delEvent(String name){
        events.remove(checkEvent(name).getName());
    }
    public void updEventName(String oldName, String newName){
        Event premier = checkEvent(oldName);
        premier.setName(newName);
        events.remove(oldName);
        addEvent(premier);
    }
    public void updEventDesc(String name, String newDesc){
        checkEvent(name).setDesc(newDesc);
    }
    public void updEventAgeGroup(String name, String newAgeGroup){
        checkEvent(name).setAgeGroup(newAgeGroup);
    }
    public void updEventCntTickets(String name, Integer newCntTickets){
        checkEvent(name).setCntTickets(newCntTickets);
    }
    public void buyTicket(String name, Integer cnt){
        Event premier = checkEvent(name);
        Integer nowTickets = premier.getCntTickets();
        if (cnt < 0) {
            throw new IllegalArgumentException( "Запрашиваемое количество билетов должно быть положительным." );
        }
        else if (nowTickets - cnt < 0){
            throw new IllegalArgumentException( ((nowTickets == 0) ? "Билеты на данную премьеру закончились" : "Нет нужнего количества билетов. Осталось лишь " + nowTickets) );
        } else {
            nowTickets -= cnt;
            System.out.println("На премьеру " + name + " куплено " + cnt + " билетов. Осталось " + nowTickets + " билетов");
            premier.setCntTickets(nowTickets);
        }
    }
    public void returnTicket(String name, Integer cnt){
        Event premier = checkEvent(name);
        if (cnt < 0) {
            throw new IllegalArgumentException("Запрашиваемое количество билетов должно быть положительным.");
        }
        Integer nowTickets = premier.getCntTickets();
        nowTickets += cnt;
        System.out.println("На премьеру " + premier.getName() + " вернули " + cnt + " билетов. Билетов стало " + nowTickets);
        premier.setCntTickets(nowTickets);
    }
}
