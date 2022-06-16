package com.sofka.hardwarepublisher.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ProviderDTO {
    private final String id;
    private final String associationDate;
    private final String name;
    private final String phone;
    private final String dni;
    private final List<String> offeredProducts;
}
