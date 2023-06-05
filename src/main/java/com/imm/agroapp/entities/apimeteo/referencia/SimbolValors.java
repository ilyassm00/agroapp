package com.imm.agroapp.entities.apimeteo.referencia;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SimbolValors {

    private Integer codi;

    private String nom;

    private String descripcio;

    private String categoria;

    private String icona;

    private String icona_nit;
}
