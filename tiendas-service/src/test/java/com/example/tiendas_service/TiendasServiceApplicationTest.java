package com.example.tiendas_service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

class TiendasServiceApplicationTest {

    @Test
    void main_deberiaEjecutarSpringApplicationRun() {
        // Given
        String[] args = {};

        try (MockedStatic<SpringApplication> springApplicationMock = Mockito.mockStatic(SpringApplication.class)) {

            // When
            TiendasServiceApplication.main(args);

            // Then
            springApplicationMock.verify(
                    () -> SpringApplication.run(TiendasServiceApplication.class, args)
            );
        }
    }
}
