package com.schulzmarcos.bookservice.api.resources;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("book-service")
public class TestController {

    //implementado o logger para fazermos o track das requisições
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")                                    //name, é o nome dado para esta endpoint. fall
    //@Retry(name= "default", fallbackMethod = "metodoRetorno")//implementado o retry, para quando a requisição não for concluida ele tentar novamente, por padrão o retry testa 3 vezes, mas pode ser configurado a quantidade pelos propriedades do app
    @CircuitBreaker(name = "default", fallbackMethod = "metodoRetorno") //Funciona como um disjuntor, onde se ha falhas ignora a requisição principal e vai direto para o fallbackMethod, e dps testa aos poucos, caso estabilize as falhas, retorna ao metodo principal, se não faz novamente o pulo para o fallback
    public String test(){
        logger.info("request para test recebido!!");//implementado o logger para fazermos o track das requisições

        //declarado variavel para retornar o erro, RestTemplate usado para gerar um erro forçado
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
//        return "TEST!!!";
        return response.getBody();
    }

    public String metodoRetorno(Exception exception){
        return "fallbackMethod TESTE!!";
    }
}
