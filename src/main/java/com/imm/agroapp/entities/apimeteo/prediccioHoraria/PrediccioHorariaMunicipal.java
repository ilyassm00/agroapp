package com.imm.agroapp.entities.apimeteo.prediccioHoraria;

import com.imm.agroapp.entities.apimeteo.prediccioHoraria.DiesHoraria;
import lombok.Data;

import java.util.List;

@Data
public class PrediccioHorariaMunicipal {

    private String codiMunicipi;

    private List<DiesHoraria> dies;
}
