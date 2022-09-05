package com.study.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routerLocatorBuilder){
        return routerLocatorBuilder.routes()
                .route(route -> route.path("/get")
                        .filters(filter -> filter
                                .addRequestHeader("HeaderName", "HeaderValue")
                                .addRequestParameter("Param", "Value"))
                        .uri("http://httpbin.org:80"))
                .route(route -> route.path("/api/v1/pedidos/**").uri("lb://rest-api-pedido"))
                .route(route -> route.path("/api/v1/pagamentos/**").uri("lb://rest-api-pagamento"))
                .build();
    }
}
