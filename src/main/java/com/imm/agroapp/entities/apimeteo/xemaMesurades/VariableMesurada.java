package com.imm.agroapp.entities.apimeteo.xemaMesurades;

import lombok.Data;

import java.util.List;

@Data
public class VariableMesurada {

    private Integer codi;

    private List<LecturaVariableMesurada> lectures;
}
