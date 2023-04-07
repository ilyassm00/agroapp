package com.imm.agroapp.services.apimeteo.impl;

import com.imm.agroapp.entities.apimeteo.prediccioHoraria.PrediccioHorariaMunicipal;
import com.imm.agroapp.services.apimeteo.PrediccioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PrediccioServiceImpl implements PrediccioService {

    @Value("${api.meteocat.key}")
    private String apiKey;

    @Value("${api.meteocat.pronostic.url}")
    private String host;

    @Override
    public Mono<PrediccioHorariaMunicipal> findPrediccioHorariaMunicipal(String codiMunicipi) {
        WebClient webClient = WebClient.create(host);
        return webClient.get()
                .uri("/municipalHoraria/" + codiMunicipi)
                .header("x-api-key", apiKey)
                .retrieve()
                .bodyToMono(PrediccioHorariaMunicipal.class);

    }
}
