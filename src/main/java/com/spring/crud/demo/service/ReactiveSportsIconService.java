package com.spring.crud.demo.service;

import com.spring.crud.demo.model.SportsIcon;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveSportsIconService {

    Flux<?> findAll();

    Mono<SportsIcon> findById(int id);

    Mono<SportsIcon> save(SportsIcon sportsIcon);

    Mono<SportsIcon> update(int id, SportsIcon sportsIcon);

    Mono<Void> delete(int id);
}
