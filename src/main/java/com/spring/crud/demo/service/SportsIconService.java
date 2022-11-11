package com.spring.crud.demo.service;

import com.spring.crud.demo.model.SportsIcon;

import java.util.List;

public interface SportsIconService {

    List<SportsIcon> findAll();

    SportsIcon findById(int id);

    SportsIcon save(SportsIcon sportsIcon);

    SportsIcon update(int id, SportsIcon sportsIcon);

    void delete(int id);
}
