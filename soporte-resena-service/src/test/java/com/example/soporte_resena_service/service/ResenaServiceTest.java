package com.example.soporte_resena_service.service;

import com.example.soporte_resena_service.dto.ResenaDTO;
import com.example.soporte_resena_service.model.Resena;
import com.example.soporte_resena_service.repository.ResenaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ResenaServiceTest {

    @Mock
    private ResenaRepository resenaRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ResenaService resenaService;

    @Test
    void listarResenas_deberiaRetornarListaDeResenas() {
        // 1 crear resena de ejemplo
        Resena resena = new Resena(
                1L,
                3L,
                "CLIENTE ECOMARKET",
                5,
                "Excelente producto ecológico, buena calidad y presentación",
                true
        );

        // 2 simular comportamiento del repositorio
        when(resenaRepository.findAll()).thenReturn(List.of(resena));

        // 3 ejecutar el método de service
        List<ResenaDTO> resultado = resenaService.listarResenas();

        // 4 resultados esperados
        assertEquals(1, resultado.size());
        assertEquals(1L, resultado.get(0).getIdResena());
        assertEquals(3L, resultado.get(0).getIdProducto());
        assertEquals("CLIENTE ECOMARKET", resultado.get(0).getNombreCliente());
        assertEquals(5, resultado.get(0).getCalificacion());
        assertEquals("Excelente producto ecológico, buena calidad y presentación", resultado.get(0).getComentario());
        assertTrue(resultado.get(0).getActiva());
    }
}