package com.ecommerce.catalogo_productos.Service;

import com.ecommerce.catalogo_productos.DTO.ProductoRequestDTO;
import com.ecommerce.catalogo_productos.DTO.ProductoResponseDTO;
import com.ecommerce.catalogo_productos.Model.Producto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    private Long contadorId = 1L; 

    public ProductoResponseDTO crear(ProductoRequestDTO requestDTO) {

        Producto producto = new Producto();

        producto.setId(contadorId++); 

        producto.setNombre(requestDTO.getNombre()); 

        producto.setDescripcion(requestDTO.getDescripcion()); 

        producto.setPrecio(requestDTO.getPrecio()); 

        producto.setStock(requestDTO.getStock()); 

        producto.setEmailProveedor(requestDTO.getEmailProveedor()); 

        producto.setFechaVencimiento(requestDTO.getFechaVencimiento()); 

        producto.setCodigoSKU(requestDTO.getCodigoSKU()); 

        producto.setFechaRegistro(LocalDateTime.now()); 

        productos.add(producto); 

        return mapearAResponseDTO(producto); 
    }

    private ProductoResponseDTO mapearAResponseDTO(Producto producto) {

        ProductoResponseDTO responseDTO = new ProductoResponseDTO();

        responseDTO.setId(producto.getId());
        responseDTO.setNombre(producto.getNombre());
        responseDTO.setPrecio(producto.getPrecio());
        responseDTO.setStock(producto.getStock());
        responseDTO.setCodigoSKU(producto.getCodigoSKU());
        responseDTO.setFechaRegistro(producto.getFechaRegistro());

        responseDTO.setEstadoStock(calcularEstadoStock(producto.getStock()));

        return responseDTO;
    }

    private String calcularEstadoStock(Integer stock) {
        if (stock == 0) {
            return "SIN STOCK"; 
        } else if (stock < 10) {
            return "STOCK BAJO";     
        } else {
            return "DISPONIBLE"; 
        }
    }
}