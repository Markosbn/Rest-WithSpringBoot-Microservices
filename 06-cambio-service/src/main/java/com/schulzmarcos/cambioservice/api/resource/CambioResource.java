package com.schulzmarcos.cambioservice.api.resource;

import com.schulzmarcos.cambioservice.domain.model.Cambio;
import com.schulzmarcos.cambioservice.domain.repositories.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Tag(name = "Cambio Service API")
@RestController
@RequestMapping("cambio-service")
public class CambioResource {

    @Autowired //Classe usada para recuperar dados da aplicação
    private Environment environment;

    @Autowired
    private CambioRepository repository;

    @Operation(description = "Get cambio from Currency!")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount")BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to){
        var cambio = repository.findByFromAndTo(from, to);
        if (cambio == null){
            throw new RuntimeException("Currency unsupported");
        }
        //getProperty, pode pegar diversas informações da aplicação
        var port = environment.getProperty("local.server.port"); // usado para recuperar a porta da aplicação

        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        cambio.setEnvironment(port);

        return cambio;
    }
}
