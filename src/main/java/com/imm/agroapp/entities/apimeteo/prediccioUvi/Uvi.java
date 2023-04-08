package com.imm.agroapp.entities.apimeteo.prediccioUvi;

import lombok.Data;

import java.util.List;

@Data
public class Uvi {

    private String date;

    private List<UviHoraria> hours;
}
