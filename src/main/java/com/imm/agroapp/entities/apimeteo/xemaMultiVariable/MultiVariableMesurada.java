package com.imm.agroapp.entities.apimeteo.xemaMultiVariable;

import lombok.Data;

import java.util.List;

@Data
public class MultiVariableMesurada {

    private Integer codi;

    private List<LecturaMultiVariableMesurada> lectures;
}
