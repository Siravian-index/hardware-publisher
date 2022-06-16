package com.sofka.hardwarepublisher.usecase;

import com.sofka.hardwarepublisher.infra.dto.ProviderDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProviderUseCase {

    public Mono<ProviderDTO> apply(ProviderDTO providerDTO) {
        return null;
    }
}
