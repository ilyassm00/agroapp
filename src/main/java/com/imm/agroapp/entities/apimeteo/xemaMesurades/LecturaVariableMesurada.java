package com.imm.agroapp.entities.apimeteo.xemaMesurades;

import lombok.Data;

@Data
public class LecturaVariableMesurada {

    private String data;

    private String dataExtrem;

    private Double valor;

    private String estat;

    private String baseHoraria;
}
