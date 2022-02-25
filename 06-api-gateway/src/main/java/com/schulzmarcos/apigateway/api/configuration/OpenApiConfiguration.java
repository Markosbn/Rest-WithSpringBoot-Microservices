package com.schulzmarcos.apigateway.api.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Bean
    @Lazy(value = false)//não permite esperar para ser executado
    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters configParameters, RouteDefinitionLocator definitionLocator){

        //define a variavel para receber a lista das rotas
        var definitions = definitionLocator.getRouteDefinitions().collectList().block();
        //defina uma stream para a lista, para filtrar os nomes de serviços, e para cada serviço encontrado adicionar no configParameters
        //depois monta os caminhos conforme as urls das endpoints batem com as do arquivo YML
        definitions.stream().filter(routeDefinition -> routeDefinition.getId()
                .matches(".*-service")).forEach(routeDefinition -> {
                    String name = routeDefinition.getId();
                    configParameters.addGroup(name);
                    GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
                });

        return new ArrayList<>();
    }
}
