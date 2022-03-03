package com.schulzmarcos.apigateway.api.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//classe criada para gerenciar as logs, com filtros de transações realizadas.
@Component
public class LoggingFilter implements GlobalFilter {

    //chama o logger
    //chamada do logger tbm traz no console o id dos log do ZIPKIN
    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override //chama a mensagem, e a requisição. passando o caminho acessado.
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //logger.info("Original request path -> {}", exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
