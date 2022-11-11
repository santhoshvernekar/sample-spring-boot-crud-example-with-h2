package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.SportsIcon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SuperHeroRepository extends JpaRepository<SportsIcon, Integer> {

}
