package com.example.soporte_resena_service.controller;

import com.example.soporte_resena_service.dto.ResenaDTO;
import com.example.soporte_resena_service.service.ResenaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resenas")
public class ResenaController {

    private final ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping
    public ResponseEntity<List<ResenaDTO>> listarResenas() {
        List<ResenaDTO> resenas = resenaService.listarResenas();
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResenaDTO> buscarResenaPorId(@PathVariable Long id) {
        return resenaService.buscarResenaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResenaDTO> crearResena(@Valid @RequestBody ResenaDTO resenaDTO) {
        ResenaDTO nuevaResena = resenaService.guardarResena(resenaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaResena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResenaDTO> actualizarResena(
            @PathVariable Long id,
            @Valid @RequestBody ResenaDTO resenaDTO) {

        if (!resenaService.existeResenaPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        resenaDTO.setIdResena(id);
        ResenaDTO resenaActualizada = resenaService.guardarResena(resenaDTO);
        return ResponseEntity.ok(resenaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Long id) {
        if (!resenaService.existeResenaPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        resenaService.eliminarResena(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<ResenaDTO>> listarResenasPorProducto(@PathVariable Long idProducto) {
        List<ResenaDTO> resenas = resenaService.listarResenasPorProducto(idProducto);
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/activas")
    public ResponseEntity<List<ResenaDTO>> listarResenasActivas() {
        List<ResenaDTO> resenas = resenaService.listarResenasActivas();
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/calificacion/{calificacion}")
    public ResponseEntity<List<ResenaDTO>> listarResenasPorCalificacion(@PathVariable Integer calificacion) {
        List<ResenaDTO> resenas = resenaService.listarResenasPorCalificacion(calificacion);
        return ResponseEntity.ok(resenas);
    }
}