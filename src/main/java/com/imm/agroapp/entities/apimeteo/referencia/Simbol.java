package com.imm.agroapp.entities.apimeteo.referencia;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Simbol {

    private String nom;

    private String descripcio;

    private List<SimbolValors> valors;
}
