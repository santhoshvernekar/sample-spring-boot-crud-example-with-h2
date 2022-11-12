package com.spring.crud.demo.controller;

import com.spring.crud.demo.model.SportsIcon;
import com.spring.crud.demo.service.ReactiveSportsIconService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/sport-icons")
public class ReactiveSportsIconController {

    private ReactiveSportsIconService reactiveSportsIconService;

    @Autowired
    public ReactiveSportsIconController(ReactiveSportsIconService service) {
        this.reactiveSportsIconService = service;
    }

    @Operation(summary = "Try this endpoint in chrome, postman doesn't support for reactive programming")
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<?>> findAll() {
        Flux<?> list = reactiveSportsIconService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public Mono<SportsIcon> findById(@PathVariable int id) {
        return reactiveSportsIconService.findById(id);
    }


    @PostMapping
    public Mono<SportsIcon> save(@RequestBody SportsIcon sportsIcon) {
        return reactiveSportsIconService.save(sportsIcon);
    }


    @PutMapping("/{id}")
    public Mono<SportsIcon> update(@PathVariable int id, @RequestBody SportsIcon sportsIcon) {
        return reactiveSportsIconService.update(id, sportsIcon);
    }


    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable int id) {
        Mono<Void> monoVoid = reactiveSportsIconService.delete(id);
        return Mono.just("Deleted successfully...!");
    }
}
