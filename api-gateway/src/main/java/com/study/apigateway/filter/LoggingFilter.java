package com.study.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Path of the request received -> {}", exchange.getRequest().getPath());
        logger.info("Remote address of the request received -> {}", exchange.getRequest().getRemoteAddress());
        logger.info("Id of the request received -> {}", exchange.getRequest().getId());
        logger.info("Query params of the request received -> {}", exchange.getRequest().getQueryParams());
        return chain.filter(exchange);
    }
}
