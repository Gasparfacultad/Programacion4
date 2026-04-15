package com.ecommerce.catalogo_productos.Controller;

import com.ecommerce.catalogo_productos.DTO.ProductoRequestDTO;
import com.ecommerce.catalogo_productos.DTO.ProductoResponseDTO;
import com.ecommerce.catalogo_productos.Service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/productos") 
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crear(
            @Valid @RequestBody ProductoRequestDTO requestDTO) {

        ProductoResponseDTO responseDTO = productoService.crear(requestDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()        
                .path("/{id}")               
                .buildAndExpand(responseDTO.getId()) 
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }
}