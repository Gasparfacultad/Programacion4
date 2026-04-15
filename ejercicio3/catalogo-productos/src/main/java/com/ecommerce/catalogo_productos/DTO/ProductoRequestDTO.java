package com.ecommerce.catalogo_productos.DTO;  

import jakarta.validation.constraints.*;
import java.math.BigDecimal;  
import java.time.LocalDate;   

public class ProductoRequestDTO {

    @NotBlank(message = "{producto.nombre.obligatorio}")
    @Size(min = 3, max = 100, message = "{producto.nombre.longitud}") 
    private String nombre;

    @Size(max = 500, message = "{producto.descripcion.maximo}") 
    private String descripcion;

    @NotNull(message = "{producto.precio.obligatorio}") 
    @Positive(message = "{producto.precio.positivo}") 
    @DecimalMax(value = "99999.99", message = "{producto.precio.maximo}") 
    private BigDecimal precio;

    @NotNull(message = "{producto.stock.obligatorio}") 
    @Min(value = 0, message = "{producto.stock.minimo}") 
    @Max(value = 9999, message = "{producto.stock.maximo}") 
    private Integer stock;

    @NotBlank(message = "{producto.email.obligatorio}") 
    @Email(message = "{producto.email.formato}") 
    private String emailProveedor;

    @Future(message = "{producto.fechaVencimiento.futura}") 
    private LocalDate fechaVencimiento;

    @Pattern(regexp = "[A-Z]{3}-\\d{4}", message = "{producto.codigoSKU.patron}")
    private String codigoSKU;

    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getEmailProveedor() { return emailProveedor; }
    public void setEmailProveedor(String emailProveedor) { this.emailProveedor = emailProveedor; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getCodigoSKU() { return codigoSKU; }
    public void setCodigoSKU(String codigoSKU) { this.codigoSKU = codigoSKU; }
}