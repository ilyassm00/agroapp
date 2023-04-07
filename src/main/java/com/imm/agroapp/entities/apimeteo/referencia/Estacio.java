package com.imm.agroapp.entities.apimeteo.referencia;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Estacio {

    @Id
    private String codi;

    private String nom;

    private String tipus;

    private Coordenades coordenades;

    private String emplacament;

    private Integer altitud;

    private Municipi municipi;

    private Comarca comarca;

    private Provincia provincia;

    private Xarxa xarxa;

    private List<Estat> estats;
}
