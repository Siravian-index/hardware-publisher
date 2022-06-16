package com.sofka.hardwarepublisher.infra.route;

import com.sofka.hardwarepublisher.infra.dto.ProviderDTO;
import com.sofka.hardwarepublisher.usecase.CreateProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateProviderRoute {

    @Bean
    public RouterFunction<ServerResponse> createProvider(CreateProviderUseCase useCase) {
        return route(POST("/provider"),
                request -> request.bodyToMono(ProviderDTO.class)
                        .flatMap(providerDTO -> useCase.apply(providerDTO)
                                .flatMap(providerDTO1 -> ServerResponse.status(HttpStatus.CREATED)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(providerDTO1))));
    }
}
