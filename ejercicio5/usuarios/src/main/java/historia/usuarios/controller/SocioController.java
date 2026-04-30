package historia.usuarios.controller;

import historia.usuarios.dto.SocioCreateDTO;
import historia.usuarios.dto.SocioResponseDTO;
import historia.usuarios.dto.SocioUpdateDTO;
import historia.usuarios.service.SocioService;
import historia.usuarios.validation.OnCreate;
import historia.usuarios.validation.OnUpdate;
import jakarta.validation.Valid;
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
            @Valid @RequestBody SocioCreateDTO dto) {

        SocioResponseDTO response = socioService.crearSocio(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/perfil")
    public ResponseEntity<SocioResponseDTO> actualizarPerfil(
            @Validated(OnUpdate.class) @RequestBody SocioUpdateDTO dto) {

        SocioResponseDTO response = socioService.actualizarPerfil(dto);

        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.OK);
    }
}