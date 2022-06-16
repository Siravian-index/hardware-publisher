package com.sofka.hardwarepublisher.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Provider {
    private String id;
    private String associationDate;
    private String name;
    private String phone;
    private String dni;
    private List<String> offeredProducts;

}
