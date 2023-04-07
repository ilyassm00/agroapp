package com.imm.agroapp.entities.apimeteo.referencia;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Municipi {

    @Id
    private Integer codi;

    private String nom;

    private Coordenades coordenades;

    private Comarca comarca;

}
