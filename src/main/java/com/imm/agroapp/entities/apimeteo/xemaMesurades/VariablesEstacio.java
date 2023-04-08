package com.imm.agroapp.entities.apimeteo.xemaMesurades;

import lombok.Data;

import java.util.List;

@Data
public class VariablesEstacio {

    private String codi;

    private List<VariableMesurada> variables;
}
