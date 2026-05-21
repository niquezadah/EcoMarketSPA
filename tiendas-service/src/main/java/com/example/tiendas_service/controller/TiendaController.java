package com.example.tiendas_service.controller;

import com.example.tiendas_service.model.Tienda;
import com.example.tiendas_service.service.TiendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiendas")
public class TiendaController {

    private final TiendaService tiendaService;

    public TiendaController(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }

    @GetMapping
    public ResponseEntity<List<Tienda>> listarTiendas() {
        List<Tienda> tiendas = tiendaService.listarTiendas();
        return ResponseEntity.ok(tiendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tienda> buscarTiendaPorId(@PathVariable Long id) {
        return tiendaService.buscarTiendaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tienda> crearTienda(@RequestBody Tienda tienda) {
        Tienda nuevaTienda = tiendaService.guardarTienda(tienda);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTienda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tienda> actualizarTienda(
            @PathVariable Long id,
            @RequestBody Tienda tienda) {

        if (!tiendaService.existeTiendaPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        tienda.setIdTienda(id);
        Tienda tiendaActualizada = tiendaService.guardarTienda(tienda);
        return ResponseEntity.ok(tiendaActualizada);
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
