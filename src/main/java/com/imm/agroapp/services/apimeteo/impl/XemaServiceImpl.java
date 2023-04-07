package com.imm.agroapp.services.apimeteo.impl;

import com.imm.agroapp.services.apimeteo.XemaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class XemaServiceImpl implements XemaService {

    @Value("${api.meteocat.key}")
    private String apiKey;

    @Value("${api.meteocat.xema.url}")
    private String host;
}
