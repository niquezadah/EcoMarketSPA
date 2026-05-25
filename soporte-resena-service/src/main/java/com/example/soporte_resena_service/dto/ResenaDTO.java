package com.example.soporte_resena_service.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResenaDTO {

    private Long idResena;

    @NotNull(message = "El ID del PRODUCTO es OBLIGATORIO")
    private Long idProducto;

    @NotBlank(message = "El NOMBRE del CLIENTE es OBLIGATORIO")
    @Size(max = 100, message = "El NOMBRE del CLIENTE no puede superar los 100 caracteres")
    private String nombreCliente;

    @NotNull(message = "La CALIFICACIÓN es OBLIGATORIA")
    @Min(value = 1, message = "La CALIFICACIÓN mínima es 1")
    @Max(value = 5, message = "La CALIFICACIÓN máxima es 5")
    private Integer calificacion;

    @NotBlank(message = "El COMENTARIO es OBLIGATORIO")
    @Size(max = 500, message = "El COMENTARIO no puede superar los 500 caracteres")
    private String comentario;

    @NotNull(message = "El estado ACTIVA es OBLIGATORIO")
    private Boolean activa;
}