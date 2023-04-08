package com.imm.agroapp.entities.apimeteo.prediccioUvi;

import lombok.Data;

@Data
public class UviHoraria {

    private Integer hour;

    private Integer uvi;

    private Integer uvi_clouds;
}
