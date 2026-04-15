package com.ecommerce.catalogo_productos.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductoResponseDTO {

    private Long id;           
    private String nombre;     
    private BigDecimal precio;  
    private Integer stock;      
    private String codigoSKU;   
    private LocalDateTime fechaRegistro; 
    private String estadoStock; 

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getCodigoSKU() { return codigoSKU; }
    public void setCodigoSKU(String codigoSKU) { this.codigoSKU = codigoSKU; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public String getEstadoStock() { return estadoStock; }
    public void setEstadoStock(String estadoStock) { this.estadoStock = estadoStock; }
}