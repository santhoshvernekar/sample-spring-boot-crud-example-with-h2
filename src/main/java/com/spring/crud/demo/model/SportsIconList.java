package com.spring.crud.demo.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class SportsIconList {
    public List<SportsIcon> items= new ArrayList<>();
}
