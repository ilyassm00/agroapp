package com.imm.agroapp.services.apimeteo.impl;

import com.imm.agroapp.entities.apimeteo.xemaMesurades.VariablesEstacio;
import com.imm.agroapp.entities.apimeteo.xemaMultiVariable.MultiVariableMesurada;
import com.imm.agroapp.services.apimeteo.XemaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class XemaServiceImpl implements XemaService {

    @Value("${api.meteocat.key}")
    private String apiKey;

    @Value("${api.meteocat.xema.url}")
    private String host;


    @Override
    public Flux<VariablesEstacio> findVariablesMesuradesEstacio(String codiEstacio) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dataAvui = LocalDate.now().format(format);
        WebClient webClient = WebClient.create(host);
        return webClient.get()
                .uri("/estacions/mesurades/" + codiEstacio + "/" + dataAvui)
                .header("x-api-key", apiKey)
                .retrieve()
                .bodyToFlux(VariablesEstacio.class);
    }

    @Override
    public Mono<MultiVariableMesurada> findMultiVariablesMesuradesEstacio(String codiEstacio) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dataAvui = LocalDate.now().format(format);
        WebClient webClient = WebClient.create(host);
        return webClient.get()
                .uri("/variables/cmv/6006/" + dataAvui + "?codiEstacio=" + codiEstacio)
                .header("x-api-key", apiKey)
                .retrieve()
                .bodyToMono(MultiVariableMesurada.class);
    }
}
