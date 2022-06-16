package com.sofka.hardwarepublisher.usecase;

import com.sofka.hardwarepublisher.domain.Provider;
import com.sofka.hardwarepublisher.infra.dto.ProviderDTO;
import com.sofka.hardwarepublisher.infra.mapper.ProviderMapper;
import com.sofka.hardwarepublisher.infra.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class CreateProviderUseCase {

    private final ProviderMapper mapper;

    private final ProviderRepository repository;

    public CreateProviderUseCase(ProviderMapper mapper, ProviderRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Mono<ProviderDTO> apply(ProviderDTO providerDTO) {
        Provider provider = mapper.fromDTOToDomain(providerDTO);
        provider.setAssociationDate(LocalDate.now().toString());

        return repository.save(mapper.fromDomainToDocument(provider)).map(document -> mapper.fromDocumentToDTO(document));

    }
}
