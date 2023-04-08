package com.imm.agroapp.entities.apimeteo.prediccioDiaria;

import lombok.Data;

import java.util.List;

@Data
public class PrediccioDiariaMunicipal {

    private String codiMunicipi;

    private List<DiesDiaria> dies;
}
