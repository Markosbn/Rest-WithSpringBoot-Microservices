package com.schulzmarcos.bookservice.api.proxy;

import com.schulzmarcos.bookservice.api.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

//Classe usada para implementar o feign
@FeignClient(name = "cambio-service", url = "localhost:8000")
public interface CambioProxy {

    //replica a estrutura do endpoint do microserviço
    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") Double amount, @PathVariable("from") String from, @PathVariable("to") String to);

}
