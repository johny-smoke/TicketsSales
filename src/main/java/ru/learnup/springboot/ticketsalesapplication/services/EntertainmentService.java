package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.springboot.ticketsalesapplication.mappers.MyMapper;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.EntertainmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntertainmentService {
    private final EntertainmentRepository repository;
    private final MyMapper mapper;

    @Autowired
    public EntertainmentService(EntertainmentRepository repository, MyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Entertainment> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    public Entertainment get(Integer id) {
        return mapper.toDomain(repository.getById(id));
    }

    @PreAuthorize("hasRole(\"ADMIN\")")
    public Integer add(Entertainment entertainment) {
        final EntertainmentEntity savedEntertainment = repository.save(new EntertainmentEntity(null,
                entertainment.getName(),
                entertainment.getDescr(),
                entertainment.getAgeGroup(),
                new ArrayList<>()));
        return savedEntertainment.getId();
    }

    @PreAuthorize("hasRole(\"ADMIN\")")
    @Transactional
    public void update(Entertainment entertainment) {
        final EntertainmentEntity entertainmentEntity = repository.getById(entertainment.getId());
        repository.save(new EntertainmentEntity(entertainment.getId(),
                entertainment.getName(),
                entertainment.getDescr(),
                entertainment.getAgeGroup(),
                new ArrayList<>()));
    }

    @PreAuthorize("hasRole(\"ADMIN\")")
    public void del(Integer entertainmentId) {
        repository.deleteById(entertainmentId);
    }
}
