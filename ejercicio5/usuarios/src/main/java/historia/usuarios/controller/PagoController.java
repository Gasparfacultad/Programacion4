package historia.usuarios.controller;

import historia.usuarios.dto.PagoRequestDTO;
import historia.usuarios.model.Pago;
import historia.usuarios.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/socios/{socioId}/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<Pago> registrar(
            @PathVariable Long socioId,
            @Valid @RequestBody PagoRequestDTO dto) {

        Pago pago = pagoService.registrarPago(socioId, dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pago.getId())
                .toUri();

        return ResponseEntity.created(location).body(pago);
    }
}
