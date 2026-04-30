package historia.usuarios.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PagoRequestDTO {

    @NotNull(message = "{pago.monto.minimo}")
    @DecimalMin(value = "1000.00", message = "{pago.monto.minimo}")
    private BigDecimal monto;

    @NotBlank(message = "{pago.codigoTransaccion.patron}")
    @Pattern(regexp = "PAY-[A-Z0-9]{4}-[A-Z0-9]{4}", message = "{pago.codigoTransaccion.patron}")
    private String codigoTransaccion;

    @NotNull(message = "{pago.fechaVencimiento.futura}")
    @Future(message = "{pago.fechaVencimiento.futura}")
    private LocalDate fechaVencimiento;

    @NotBlank(message = "{pago.tipoPago.invalido}")
    @Pattern(
        regexp = "EFECTIVO|DEBITO|CREDITO|TRANSFERENCIA",
        message = "{pago.tipoPago.invalido}"
    )
    private String tipoPago;

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public String getCodigoTransaccion() { return codigoTransaccion; }
    public void setCodigoTransaccion(String codigoTransaccion) { this.codigoTransaccion = codigoTransaccion; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }
}