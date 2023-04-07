package com.imm.agroapp.entities.apimeteo.prediccioHoraria;

import lombok.Data;

import java.util.List;

@Data
public class VariableHoraria {

    private String unitat;

    private List<ValorsHoraria> valors;
}
