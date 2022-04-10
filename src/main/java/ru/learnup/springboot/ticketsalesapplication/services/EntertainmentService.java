package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.EntertainmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntertainmentService {
    private final EntertainmentRepository repository;

    @Autowired
    public EntertainmentService(EntertainmentRepository repository){
        this.repository = repository;
    }

    static Entertainment toDomain(EntertainmentEntity entertainmentEntity){
        return new Entertainment(entertainmentEntity.getId(),
                                 entertainmentEntity.getName(),
                                 entertainmentEntity.getDescr(),
                                 entertainmentEntity.getAgeGroup());
    }

    private static List<Entertainment> toDomain(List<EntertainmentEntity> entertainmentEntityList){
        return entertainmentEntityList.stream()
                .map(EntertainmentService::toDomain)
                .collect(Collectors.toList());
    }

    public List<Entertainment> getAll() {
        return toDomain(repository.findAll());
    }

    public Entertainment get(Integer id) {
        return toDomain(repository.getById(id));
    }

    public Integer add(Entertainment entertainment){
        final EntertainmentEntity savedEntertainment = repository.save(new EntertainmentEntity(null,
                entertainment.getName(),
                entertainment.getDescr(),
                entertainment.getAgeGroup(),
                new ArrayList<>()));
        return savedEntertainment.getId();
    }

    @Transactional
    public void update(Entertainment entertainment){
        final EntertainmentEntity entertainmentEntity = repository.getById(entertainment.getId());
        repository.save(new EntertainmentEntity(entertainment.getId(),
                entertainment.getName(),
                entertainment.getDescr(),
                entertainment.getAgeGroup(),
                new ArrayList<>()));
    }

    public void del(Integer entertainmentId){
        repository.deleteById(entertainmentId);
    }
}
