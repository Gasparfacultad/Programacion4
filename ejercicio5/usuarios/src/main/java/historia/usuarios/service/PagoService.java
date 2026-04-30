package historia.usuarios.service;

import historia.usuarios.dto.PagoRequestDTO;
import historia.usuarios.model.Pago;
import historia.usuarios.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public Pago registrarPago(Long socioId, PagoRequestDTO dto) {

        Pago pago = new Pago();
        pago.setSocioId(socioId);
        pago.setMonto(dto.getMonto());
        pago.setCodigoTransaccion(dto.getCodigoTransaccion());
        pago.setFechaVencimiento(dto.getFechaVencimiento());
        pago.setTipoPago(dto.getTipoPago());
        pago.setFechaRegistro(LocalDateTime.now());

        return pagoRepository.guardar(pago);
    }
}