package com.sofka.hardwarepublisher.infra.repository;

import com.sofka.hardwarepublisher.infra.document.ProviderDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProviderRepository extends ReactiveMongoRepository<ProviderDocument, String> {
}
