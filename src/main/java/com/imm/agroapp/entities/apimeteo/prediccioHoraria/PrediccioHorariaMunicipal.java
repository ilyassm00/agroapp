package com.imm.agroapp.entities.apimeteo.prediccioHoraria;

import lombok.Data;

import java.util.List;

@Data
public class PrediccioHorariaMunicipal {

    private String codiMunicipi;

    private List<DiesHoraria> dies;
}
