package com.example.inventario_catalogo_service.service;

import com.example.inventario_catalogo_service.dto.ProductoDTO;
import com.example.inventario_catalogo_service.model.Producto;
import com.example.inventario_catalogo_service.repository.ProductoRepository;

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
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void listarProductos_deberiaRetornarListaDeProductos() {
        // 1 crear producto de ejemplo
        Producto producto = new Producto(
                1L,
                "PARACETAMOL ORGANICO",
                "Paracetamol de hierbas con ingredientes naturales",
                "SALUD",
                25,
                2990.0,
                true,
                4L
        );

        // 2 simular comportamiento del repositorio
        when(productoRepository.findAll()).thenReturn(List.of(producto));

        // 3 ejecutar el método de service
        List<ProductoDTO> resultado = productoService.listarProductos();

        // 4 resultados esperados
        assertEquals(1, resultado.size());
        assertEquals("PARACETAMOL ORGANICO", resultado.get(0).getNombre());
        assertEquals("SALUD", resultado.get(0).getCategoria());
        assertEquals(25, resultado.get(0).getStock());
        assertEquals(2990.0, resultado.get(0).getPrecio());
        assertTrue(resultado.get(0).getDisponible());
        assertEquals(4L, resultado.get(0).getIdTienda());
    }
}