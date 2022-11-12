package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.SportsIcon;
import com.spring.crud.demo.repository.SportsIconRepository;
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
    private SportsIconRepository repository;


    @Override
    public Flux<?> findAll() {
        //Flux<SportsIcon> sportsIcones = reactiveSportsIconRepository.findAll();

        List<SportsIcon> sportsMEN = repository.findAll();

        return Flux.fromIterable(sportsMEN)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(sportsIcon -> log.info("*** {}", sportsIcon))
                .map(sportsIcon -> sportsIcon)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SportsIcon> findById(int id) {
        //return reactiveSportsIconRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("** SportsIcon not found for id :: " + id)));

        SportsIcon sportsIcon = repository.findById(id).orElseThrow(() -> new NotFoundException("** SportsIcon not found for id :: " + id));
        return Mono.just(sportsIcon)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SportsIcon> save(SportsIcon sportsIcon) {
        //return reactiveSportsIconRepository.save(sportsIcon);

        sportsIcon = repository.save(sportsIcon);
        return Mono.just(sportsIcon)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<SportsIcon> update(int id, SportsIcon sportsIcon) {
        //reactiveSportsIconRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("** SportsIcon not found for id :: " + id)));

        repository.findById(id).orElseThrow(() -> new NotFoundException("** SportsIcon not found for id :: " + id));
        sportsIcon.setId(id);
        return this.save(sportsIcon);
    }

    @Override
    public Mono<Void> delete(int id) {
        //reactiveSportsIconRepository.findById(id).doOnNext(repository::delete);

        repository.findById(id).ifPresent(repository::delete);
        return Mono.empty();
    }
}
