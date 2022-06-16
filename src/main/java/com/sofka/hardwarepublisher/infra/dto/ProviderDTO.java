package com.sofka.hardwarepublisher.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Data
public class ProviderDTO {
    private final String id;
    private final String associationDate;
    @NotBlank
    private final String name;
    @NotBlank
    private final String phone;
    @NotBlank
    private final String dni;
    @NotNull
    private final List<String> offeredProducts;
}
