package com.example.inventario_catalogo_service.controller;

import com.example.inventario_catalogo_service.dto.ProductoDTO;
import com.example.inventario_catalogo_service.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        List<ProductoDTO> productos = productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarProductoPorId(@PathVariable Long id) {
        return productoService.buscarProductoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        ProductoDTO nuevoProducto = productoService.guardarProducto(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductoDTO productoDTO) {

        if (!productoService.existeProductoPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        productoDTO.setIdProducto(id);
        ProductoDTO productoActualizado = productoService.guardarProducto(productoDTO);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (!productoService.existeProductoPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tienda/{idTienda}")
    public ResponseEntity<List<ProductoDTO>> listarProductosPorTienda(@PathVariable Long idTienda) {
        List<ProductoDTO> productos = productoService.listarProductosPorTienda(idTienda);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<ProductoDTO>> listarProductosDisponibles() {
        List<ProductoDTO> productos = productoService.listarProductosDisponibles();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoDTO>> listarProductosPorCategoria(@PathVariable String categoria) {
        List<ProductoDTO> productos = productoService.listarProductosPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }
}
