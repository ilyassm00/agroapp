package com.imm.agroapp.entities.apimeteo.referencia;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Xarxa {

    @Id
    private Integer codi;

    private String nom;
}
