package com.example.tiendas_service.controller;

import com.example.tiendas_service.dto.TiendaDTO;
import com.example.tiendas_service.service.TiendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.example.tiendas_service.dto.ActualizarEstadoTiendaDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiendas")
public class TiendaController {

    private final TiendaService tiendaService;

    public TiendaController(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }

    @GetMapping
    public ResponseEntity<List<TiendaDTO>> listarTiendas() {
        List<TiendaDTO> tiendas = tiendaService.listarTiendas();
        return ResponseEntity.ok(tiendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiendaDTO> buscarTiendaPorId(@PathVariable Long id) {
        return tiendaService.buscarTiendaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TiendaDTO> crearTienda(@Valid @RequestBody TiendaDTO tiendaDTO) {
        TiendaDTO nuevaTienda = tiendaService.guardarTienda(tiendaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTienda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiendaDTO> actualizarTienda(
            @PathVariable Long id,
            @Valid @RequestBody TiendaDTO tiendaDTO) {

        if (!tiendaService.existeTiendaPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        tiendaDTO.setIdTienda(id);
        TiendaDTO tiendaActualizada = tiendaService.guardarTienda(tiendaDTO);
        return ResponseEntity.ok(tiendaActualizada);
    }

    @PatchMapping("/{id}/estado")
public ResponseEntity<TiendaDTO> actualizarEstadoTienda(
        @PathVariable Long id,
        @Valid @RequestBody ActualizarEstadoTiendaDTO estadoDTO) {

    return tiendaService.actualizarEstadoTienda(id, estadoDTO.getActiva())
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTienda(@PathVariable Long id) {
        if (!tiendaService.existeTiendaPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        tiendaService.eliminarTienda(id);
        return ResponseEntity.noContent().build();
    }
}