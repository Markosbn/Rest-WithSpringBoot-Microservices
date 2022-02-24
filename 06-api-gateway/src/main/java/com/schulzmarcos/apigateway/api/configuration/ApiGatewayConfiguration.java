package com.schulzmarcos.apigateway.api.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(function -> function.path("/get").filters(f -> f.addRequestHeader("Hello", "World").addRequestParameter("Hello", "World")).uri("http://httpbin.org:80"))
                .route(function -> function.path("/cambio-service/**").uri("lb://cambio-service"))
                .route(function -> function.path("/book-service/**").uri("lb://book-service"))
                .build();
    }
}
