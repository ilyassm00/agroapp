package com.imm.agroapp.jobs;

import com.imm.agroapp.entities.canalurgell.PuntoControl;
import com.imm.agroapp.repositories.canalurgell.PuntoControlRepository;
import com.imm.agroapp.utilities.Constants;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@EnableScheduling
public class Jobs {

    @Autowired
    PuntoControlRepository puntoControlRepository;

    @Scheduled(fixedRate = 300000)
    public void updateCanalUrgellData() {
        try {
            log.info("Jobs.updateCanalUrgellData() - Init");
            List<PuntoControl> puntosControlTotal = new ArrayList<>();
            List<PuntoControl> puntosControlA
                    = getPuntosControlFromAPI("http://95.130.52.185/urgell/indice/ultimosDatos/1");
            if(puntosControlA != null) {
                puntosControlTotal.addAll(puntosControlA);
            }
            List<PuntoControl> puntosControlB
                    = getPuntosControlFromAPI("http://95.130.52.185/urgell/indice/ultimosDatos/2");
            if(puntosControlB != null) {
                puntosControlTotal.addAll(puntosControlB);
            }
            List<PuntoControl> puntosControlC
                    = getPuntosControlFromAPI("http://95.130.52.185/urgell/indice/ultimosDatos/3");
            if(puntosControlC != null) {
                puntosControlTotal.addAll(puntosControlC);
            }
            puntoControlRepository.saveAll(puntosControlTotal);
        } finally {
            log.info("Jobs.updateCanalUrgellData() - End");
        }
    }

    private List<PuntoControl> getPuntosControlFromAPI(String url) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity entity = new HttpEntity("parameters", headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
            return convertToList(response.getBody());
        } catch (Exception ex) {
            System.out.println("Error executant la consulta " + ex);
            return null;
        }
    }

    private List<PuntoControl> convertToList(String json) {
        List<PuntoControl> puntosControl = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        for (int i = 1; i <= Constants.LINEA_MAXIMA; i++) {
            if (jsonObject.has(String.valueOf(i))) {
                JSONObject linea = jsonObject.getJSONObject(String.valueOf(i));
                for (String tipo: Constants.TIPOS) {
                    if (linea.has(tipo)) {
                        JSONArray jsonArray = linea.getJSONArray(tipo);
                        puntosControl.addAll(getPuntosControlFromJSONArray(jsonArray));
                    }
                }
            }
        }
        return puntosControl;
    }

    private List<PuntoControl> getPuntosControlFromJSONArray(JSONArray jsonArray) {
        List<PuntoControl> puntosControl = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject object = jsonArray.getJSONObject(i);
                PuntoControl pc = new PuntoControl();
                pc.setVariable(object.getString("variable"));
                pc.setVariableId(object.getInt("variable_id"));
                pc.setFecha(object.getString("fecha"));
                pc.setUnidades(object.getString("unidades"));
                pc.setValor(object.getString("valor"));
                pc.setRemota(object.getString("remota"));
                puntosControl.add(pc);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return puntosControl;
    }

}
