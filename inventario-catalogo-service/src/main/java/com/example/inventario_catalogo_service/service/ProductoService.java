package com.example.inventario_catalogo_service.service;

import com.example.inventario_catalogo_service.dto.ProductoDTO;
import com.example.inventario_catalogo_service.model.Producto;
import com.example.inventario_catalogo_service.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public Optional<ProductoDTO> buscarProductoPorId(Long id) {
        return productoRepository.findById(id)
                .map(this::convertirADTO);
    }

    public ProductoDTO guardarProducto(ProductoDTO productoDTO) {
        Producto producto = convertirAEntidad(productoDTO);
        Producto productoGuardado = productoRepository.save(producto);
        return convertirADTO(productoGuardado);
    }

    public boolean existeProductoPorId(Long id) {
        return productoRepository.existsById(id);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public List<ProductoDTO> listarProductosPorTienda(Long idTienda) {
        return productoRepository.findByIdTienda(idTienda)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<ProductoDTO> listarProductosDisponibles() {
        return productoRepository.findByDisponible(true)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<ProductoDTO> listarProductosPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private ProductoDTO convertirADTO(Producto producto) {
        return new ProductoDTO(
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCategoria(),
                producto.getStock(),
                producto.getPrecio(),
                producto.getDisponible(),
                producto.getIdTienda()
        );
    }

    private Producto convertirAEntidad(ProductoDTO productoDTO) {
        return new Producto(
                productoDTO.getIdProducto(),
                productoDTO.getNombre(),
                productoDTO.getDescripcion(),
                productoDTO.getCategoria(),
                productoDTO.getStock(),
                productoDTO.getPrecio(),
                productoDTO.getDisponible(),
                productoDTO.getIdTienda()
        );
    }
}