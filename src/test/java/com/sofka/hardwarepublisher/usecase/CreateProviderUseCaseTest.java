package com.sofka.hardwarepublisher.usecase;

import com.sofka.hardwarepublisher.infra.document.ProviderDocument;
import com.sofka.hardwarepublisher.infra.dto.ProviderDTO;
import com.sofka.hardwarepublisher.infra.mapper.ProviderMapper;
import com.sofka.hardwarepublisher.infra.repository.ProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CreateProviderUseCaseTest {

    private CreateProviderUseCase useCase;

    @Mock
    private ProviderRepository repository;

    private final ProviderMapper mapper =  new ProviderMapper();

    @BeforeEach
    void setUp() {
        useCase = new CreateProviderUseCase(mapper, repository);

    }


    @Test
    void createProviderSuccessfully() {
//        given
        var providerDTO = new ProviderDTO(
                "id",
                "17/06/2022",
                "david",
                "320000",
                "1111111",
                List.of("brush", "shovel"));

        var providerDocument = new ProviderDocument(
                "id",
                "17/06/2022",
                "david",
                "320000",
                "1111111",
                List.of("brush", "shovel"));
//        when

        Mockito.when(repository.save(any(ProviderDocument.class))).thenReturn(Mono.just(providerDocument));

//        assert

        var publisher = useCase.apply(providerDTO);

        StepVerifier.create(publisher)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).save(Mockito.any(ProviderDocument.class));
    }


}