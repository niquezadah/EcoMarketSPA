package com.example.tiendas_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiendaDTO {

    private Long idTienda;

    @NotBlank(message = "El NOMBRE de la TIENDA es OBLIGATORIO")
    @Size(max = 100, message = "El NOMBRE no puede superar los 100 caracteres")
    private String nombre;

    @NotBlank(message = "La DIRECCIÓN es OBLIGATORIA")
    @Size(max = 150, message = "La DIRECCIÓN no puede superar los 150 caracteres")
    private String direccion;

    @NotBlank(message = "La COMUNA es OBLIGATORIA")
    @Size(max = 50, message = "La COMUNA no puede superar los 50 caracteres")
    private String comuna;

    @NotBlank(message = "La CIUDAD es OBLIGATORIA")
    @Size(max = 50, message = "La CIUDAD no puede superar los 50 caracteres")
    private String ciudad;

    @NotBlank(message = "La REGIÓN es OBLIGATORIA")
    @Size(max = 50, message = "La REGIÓN no puede superar los 50 caracteres")
    private String region;

    @Size(max = 12, message = "El TELÉFONO no puede superar los 12 caracteres")
    private String telefono;

    @Size(max = 300, message = "El PERSONAL ASIGNADO no puede superar los 300 caracteres")
    private String personalAsignado;

    @NotBlank(message = "El HORARIO DE APERTURA es OBLIGATORIO")
    @Size(max = 10, message = "El HORARIO DE APERTURA no puede superar los 10 caracteres")
    private String horarioApertura;

    @NotBlank(message = "El HORARIO DE CIERRE es OBLIGATORIO")
    @Size(max = 10, message = "El HORARIO DE CIERRE no puede superar los 10 caracteres")
    private String horarioCierre;

    @NotNull(message = "El ESTADO ACTIVO es OBLIGATORIO")
    private Boolean activa;

    @Size(max = 500, message = "Las POLITICAS LOCALES no pueden superar los 500 caracteres")
    private String politicasLocales;
}