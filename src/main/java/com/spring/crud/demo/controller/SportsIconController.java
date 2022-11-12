package com.spring.crud.demo.controller;


import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.annotation.LogObjectBefore;
import com.spring.crud.demo.model.SportsIcon;
import com.spring.crud.demo.model.SportsIconList;
import com.spring.crud.demo.service.SportsIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/sport-icons")
public class SportsIconController {

    private SportsIconService sportsIconService;

    @Autowired
    public SportsIconController(SportsIconService service) {
        this.sportsIconService = service;
    }

    @LogObjectAfter
    @GetMapping
    public ResponseEntity<SportsIconList> findAll() {
        SportsIconList sportsIconList = new SportsIconList();
        sportsIconList.items = sportsIconService.findAll();
        return ResponseEntity.ok().body(sportsIconList);
    }

    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<SportsIcon> findById(@PathVariable int id) {
        SportsIcon sportsIcon = sportsIconService.findById(id);
        return ResponseEntity.ok().body(sportsIcon);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<SportsIcon> save(@RequestBody SportsIcon sportsIcon) {
        SportsIcon savedSportsIcon = sportsIconService.save(sportsIcon);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedSportsIcon.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedSportsIcon);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}")
    public ResponseEntity<SportsIcon> update(@PathVariable int id, @RequestBody SportsIcon sportsIcon) {
        SportsIcon updatedSportsIcon = sportsIconService.update(id, sportsIcon);
        return ResponseEntity.ok().body(updatedSportsIcon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        sportsIconService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
