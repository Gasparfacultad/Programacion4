package com.club.socios.controller;

import com.club.socios.dto.SocioRequestDTO;
import com.club.socios.dto.SocioResponseDTO;
import com.club.socios.service.SocioService;
import com.club.socios.validation.OnCreate;
import com.club.socios.validation.OnUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @PostMapping
    public ResponseEntity<SocioResponseDTO> crear(
            @Validated(OnCreate.class) @RequestBody SocioRequestDTO requestDTO) {

        SocioResponseDTO responseDTO = socioService.crearSocio(requestDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()               
                .path("/{id}")                      
                .buildAndExpand(responseDTO.getId()) 
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioResponseDTO> actualizar(
            @PathVariable Long id,
            @Validated(OnUpdate.class) @RequestBody SocioRequestDTO requestDTO) {

        SocioResponseDTO responseDTO = socioService.actualizarSocio(id, requestDTO);

        return new ResponseEntity<>(responseDTO, org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioResponseDTO> obtenerPorId(@PathVariable Long id) {

        SocioResponseDTO responseDTO = socioService.obtenerPorId(id);

        return new ResponseEntity<>(responseDTO, org.springframework.http.HttpStatus.OK);
    }
}