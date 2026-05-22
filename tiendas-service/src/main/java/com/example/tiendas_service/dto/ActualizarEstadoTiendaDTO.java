package com.example.tiendas_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarEstadoTiendaDTO {

    @NotNull(message = "El ESTADO ACTIVO es OBLIGATORIO")
    private Boolean activa;
}