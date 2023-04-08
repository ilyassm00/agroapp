package com.imm.agroapp.entities.apimeteo.xemaMultiVariable;

import lombok.Data;

@Data
public class LecturaMultiVariableMesurada {

    private String data;

    private Double valor;

    private String estat;

    private String baseHoraria;
}
