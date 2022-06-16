package com.sofka.hardwarepublisher.usecase;

import com.sofka.hardwarepublisher.domain.Provider;
import com.sofka.hardwarepublisher.infra.dto.ProviderDTO;
import com.sofka.hardwarepublisher.infra.mapper.ProviderMapper;
import com.sofka.hardwarepublisher.infra.repository.ProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;

@Service
@Validated
public class CreateProviderUseCase {

    private final ProviderMapper mapper;

    private final ProviderRepository repository;

    public CreateProviderUseCase(ProviderMapper mapper, ProviderRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Mono<ProviderDTO> apply(@Valid ProviderDTO providerDTO) {
        Provider provider = mapper.fromDTOToDomain(providerDTO);
        provider.setAssociationDate(LocalDate.now().toString());

        return repository.save(mapper.fromDomainToDocument(provider)).map(mapper::fromDocumentToDTO);

    }
}
