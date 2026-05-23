package com.example.inventario_catalogo_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private Long idProducto;

    @NotBlank(message = "El NOMBRE del PRODUCTO es OBLIGATORIO")
    @Size(max = 120, message = "El NOMBRE no puede superar los 120 caracteres")
    private String nombre;

    @Size(max = 500, message = "La DESCRIPCIÓN no puede superar los 500 caracteres")
    private String descripcion;

    @NotBlank(message = "La CATEGORÍA es OBLIGATORIA")
    @Size(max = 80, message = "La CATEGORÍA no puede superar los 80 caracteres")
    private String categoria;

    @NotNull(message = "El STOCK es OBLIGATORIO")
    @Min(value = 0, message = "El STOCK no puede ser negativo")
    private Integer stock;

    @NotNull(message = "El PRECIO es OBLIGATORIO")
    @PositiveOrZero(message = "El PRECIO no puede ser negativo")
    private Double precio;

    @NotNull(message = "El estado DISPONIBLE es OBLIGATORIO")
    private Boolean disponible;

    @NotNull(message = "El ID de la TIENDA es OBLIGATORIO")
    private Long idTienda;
}