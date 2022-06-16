package com.sofka.hardwarepublisher.infra.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class ProviderDocument {
    @Id
    private final String id;
    private final String associationDate;
    private final String name;
    private final String phone;
    private final String dni;
    private final List<String> offeredProducts;
}
