package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.stereotype.Service;
import ru.learnup.springboot.ticketsalesapplication.annotations.Loggable;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;

import java.util.HashMap;
import java.util.Map;

@Service
public class EntertainmentService {

    public Map<String, Entertainment> entertainments = new HashMap<>();

    public Entertainment checkEntertainment(String name){
        if (!entertainments.containsKey(name)) {
            throw new IllegalArgumentException("Премьеры с таким именем не существует");
        }
        else {
            return entertainments.get(name);
        }
    }
    @Loggable
    public void addEntertainment(Entertainment premier){
        entertainments.put(premier.getName(), premier);
    }
    public Entertainment getEntertainment(String name) {
        return checkEntertainment(name);
    }
    public Map<String, Entertainment> getAllEntertainments() {
        return entertainments;
    }
    public void showAllEntertainments() {
        for (Map.Entry<String, Entertainment> row : this.entertainments.entrySet()) {
            Entertainment premier = row.getValue();
            System.out.println("Премьера " + premier.getName() +
                               ": " + premier.getDesc() +
                               " возрастная категория " + premier.getAgeGroup() +
                               " количество билетов в наличии " + premier.getCntTickets());
        }
    }

    public void delEntertainment(String name){
        entertainments.remove(checkEntertainment(name).getName());
    }
    public void updEntertainmentName(String oldName, String newName){
        Entertainment premier = checkEntertainment(oldName);
        premier.setName(newName);
        entertainments.remove(oldName);
        addEntertainment(premier);
    }
    public void updEntertainmentDesc(String name, String newDesc){
        checkEntertainment(name).setDesc(newDesc);
    }
    public void updEntertainmentAgeGroup(String name, String newAgeGroup){
        checkEntertainment(name).setAgeGroup(newAgeGroup);
    }
    @Loggable
    public void updEntertainmentData(String name, String newData){
        checkEntertainment(name).setData(newData);
    }
    public void updEntertainmentCntTickets(String name, Integer newCntTickets){
        checkEntertainment(name).setCntTickets(newCntTickets);
    }

    @Loggable
    public void buyTicket(String name, Integer cnt){
        Entertainment premier = checkEntertainment(name);
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
        Entertainment premier = checkEntertainment(name);
        if (cnt < 0) {
            throw new IllegalArgumentException("Запрашиваемое количество билетов должно быть положительным.");
        }
        Integer nowTickets = premier.getCntTickets();
        nowTickets += cnt;
        System.out.println("На премьеру " + premier.getName() + " вернули " + cnt + " билетов. Билетов стало " + nowTickets);
        premier.setCntTickets(nowTickets);
    }
}
