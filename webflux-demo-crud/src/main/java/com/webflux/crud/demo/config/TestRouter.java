package com.webflux.crud.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class TestRouter {

    @Bean
    public RouterFunction<ServerResponse> routeDemo(TestHandle testHandle) {
        return route(GET("/test/").and(
                accept(MediaType.APPLICATION_JSON)), request -> testHandle.getTestDOs())
                .andRoute(GET("/test/{id}").and(accept(MediaType.APPLICATION_JSON)), testHandle::getTestDO)
                .andRoute(POST("/test/").and(accept(MediaType.APPLICATION_JSON)), testHandle::saveTestDO)
                .andRoute(PUT("/test/").and(accept(MediaType.APPLICATION_JSON)), testHandle::updateTestDO)
                .andRoute(DELETE("/test/{id}").and(accept(MediaType.APPLICATION_JSON)), testHandle::deleteTestDO);
    }
}
