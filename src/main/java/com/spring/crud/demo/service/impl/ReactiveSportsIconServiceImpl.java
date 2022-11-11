package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.SportsIcon;
import com.spring.crud.demo.repository.SuperHeroRepository;
import com.spring.crud.demo.service.ReactiveSportsIconService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
public class ReactiveSportsIconServiceImpl implements ReactiveSportsIconService {

    @Autowired
    private SuperHeroRepository repository;

    //@Autowired
    //private ReactiveSuperHeroRepository reactiveSuperHeroRepository;

    @Override
    public Flux<?> findAll() {
        //Flux<SuperHero> superHeroes = reactiveSuperHeroRepository.findAll();

        List<SportsIcon> sportsMEN = repository.findAll();

        return Flux.fromIterable(sportsMEN)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(superHero -> log.info("*** {}", superHero))
                .map(superHero -> superHero)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SportsIcon> findById(int id) {
        //return reactiveSuperHeroRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("** Superhero not found for id :: " + id)));

        SportsIcon sportsIcon = repository.findById(id).orElseThrow(() -> new NotFoundException("** Superhero not found for id :: " + id));
        return Mono.just(sportsIcon)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SportsIcon> save(SportsIcon sportsIcon) {
        //return reactiveSuperHeroRepository.save(superHero);

        sportsIcon = repository.save(sportsIcon);
        return Mono.just(sportsIcon)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SportsIcon> update(int id, SportsIcon sportsIcon) {
        //reactiveSuperHeroRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("** Superhero not found for id :: " + id)));

        repository.findById(id).orElseThrow(() -> new NotFoundException("** Superhero not found for id :: " + id));
        sportsIcon.setId(id);
        return this.save(sportsIcon);
    }

    @Override
    public Mono<Void> delete(int id) {
        //reactiveSuperHeroRepository.findById(id).doOnNext(repository::delete);

        repository.findById(id).ifPresent(repository::delete);
        return Mono.empty();
    }
}
