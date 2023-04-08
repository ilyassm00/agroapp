package com.imm.agroapp.entities.apimeteo.prediccioDiaria;

import lombok.Data;

@Data
public class VarPrediccioDiaria {

    private VariableDiaria tmax;

    private VariableDiaria tmin;

    private VariableDiaria precipitacio;

    private EstatCelDiaria estatCel;
}
