package com.imm.agroapp.entities.canalurgell;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PuntoControl {
    @Id
    private Integer variableId;

    private String remota;

    private String fecha;

    private String unidades;

    private Double fechaseg;

    private String valor;

    private String variable;
}
