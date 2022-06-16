package com.sofka.hardwarepublisher.infra.mapper;

import com.sofka.hardwarepublisher.domain.Provider;
import com.sofka.hardwarepublisher.infra.document.ProviderDocument;
import com.sofka.hardwarepublisher.infra.dto.ProviderDTO;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {
    public ProviderDTO fromDocumentToDTO(ProviderDocument document) {
        return new ProviderDTO(
                document.getId(),
                document.getAssociationDate(),
                document.getName(),
                document.getPhone(),
                document.getDni(),
                document.getOfferedProducts());
    }
    public ProviderDocument fromDomainToDocument(Provider providerDomain) {
        return new ProviderDocument(
                providerDomain.getId(),
                providerDomain.getAssociationDate(),
                providerDomain.getName(),
                providerDomain.getPhone(),
                providerDomain.getDni(),
                providerDomain.getOfferedProducts());
    }

    public Provider fromDTOToDomain(ProviderDTO dto) {
        return new Provider(
                dto.getId(),
                dto.getAssociationDate(),
                dto.getName(),
                dto.getPhone(),
                dto.getDni(),
                dto.getOfferedProducts()
        );

    }

}
