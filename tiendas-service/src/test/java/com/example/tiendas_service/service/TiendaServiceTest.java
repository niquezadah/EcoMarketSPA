package com.example.tiendas_service.service;

import com.example.tiendas_service.dto.TiendaDTO;
import com.example.tiendas_service.model.Tienda;
import com.example.tiendas_service.repository.TiendaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TiendaServiceTest {

    @Mock
    private TiendaRepository tiendaRepository;

    @InjectMocks
    private TiendaService tiendaService;

    @Test
    void listarTiendas_deberiaRetornarListaDeTiendas() {
        // 1. guardar tienda de ejemplo
        Tienda tienda = new Tienda(
                1L,
                "ECOMARKET CONCEPCION",
                "PEDRO DE VALDIVIA 123",
                "CONCEPCION",
                "CONCEPCION",
                "BIO BIO",
                "+56912345678",
                "WACOLDO SOTO",
                "09:00",
                "19:00",
                true,
                "Uso de bolsas reutilizables"
        );

        // 2 simular comportamiento del repositorio
        when(tiendaRepository.findAll()).thenReturn(List.of(tienda));

        // 3 ejecutar el método de service
        List<TiendaDTO> resultado = tiendaService.listarTiendas();

        // 4 resultados esperados
        assertEquals(1, resultado.size());
        assertEquals("ECOMARKET CONCEPCION", resultado.get(0).getNombre());
        assertEquals("BIO BIO", resultado.get(0).getRegion());
        assertEquals(true, resultado.get(0).getActiva());
    }
}