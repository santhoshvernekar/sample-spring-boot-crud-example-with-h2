package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.SportsIcon;
import com.spring.crud.demo.repository.SportsIconRepository;
import com.spring.crud.demo.service.SportsIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class SportsIconServiceImpl implements SportsIconService {

    @Autowired
    private SportsIconRepository repository;

    @Override
    public List<SportsIcon> findAll() {
        return repository.findAll();
    }

    @Override
    public SportsIcon findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** SportsIcon not found for id :: " + id));
    }

    @Override
    public SportsIcon save(SportsIcon sportsIcon) {
        return repository.save(sportsIcon);
    }

    @Override
    public SportsIcon update(int id, SportsIcon sportsIcon) {
    	repository.findById(id).orElseThrow(() -> new NotFoundException("** SportsIcon not found for id :: " + id));
    	sportsIcon.setId(id);
        return repository.save(sportsIcon);
    }

    @Override
    public void delete(int id) {
       repository.findById(id).ifPresent(sportsIcon -> repository.delete(sportsIcon));
    }
}
