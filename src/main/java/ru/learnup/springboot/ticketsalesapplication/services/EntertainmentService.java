package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.stereotype.Service;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;

import java.util.HashMap;
import java.util.Map;

@Service
public class EntertainmentService {

    public Map<String, Entertainment> events = new HashMap<>();

    public Entertainment checkEvent(String name){
        if (!events.containsKey(name)) {
            throw new IllegalArgumentException("Премьеры с таким именем не существует");
        }
        else {
            return events.get(name);
        }
    }
    public void addEvent(Entertainment premier){
        events.put(premier.getName(), premier);
    }
    public Entertainment getEvent(String name) {
        return checkEvent(name);
    }
    public Map<String, Entertainment> getAllEvents() {
        return events;
    }
    public void showAllEvents() {
        for (Map.Entry<String, Entertainment> row : this.events.entrySet()) {
            Entertainment premier = row.getValue();
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
        Entertainment premier = checkEvent(oldName);
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
        Entertainment premier = checkEvent(name);
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
        Entertainment premier = checkEvent(name);
        if (cnt < 0) {
            throw new IllegalArgumentException("Запрашиваемое количество билетов должно быть положительным.");
        }
        Integer nowTickets = premier.getCntTickets();
        nowTickets += cnt;
        System.out.println("На премьеру " + premier.getName() + " вернули " + cnt + " билетов. Билетов стало " + nowTickets);
        premier.setCntTickets(nowTickets);
    }
}
