package com.imm.agroapp.entities.apimeteo.prediccioUvi;

import lombok.Data;

import java.util.List;

@Data
public class PrediccioUviMunicipal {

    private String ine;

    private String nom;

    private Integer comarca;

    private Boolean capital;

    private List<Uvi> uvi;
}
