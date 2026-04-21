package com.club.socios.dto;

import jakarta.validation.constraints.*;

public class DireccionDTO {

    @NotBlank(message = "{socio.direccion.calle.obligatorio}")
    @Size(min = 5, max = 150, message = "{socio.direccion.calle.longitud}")
    private String calle;

    @NotBlank(message = "{socio.direccion.ciudad.obligatorio}")
    @Size(min = 3, max = 80, message = "{socio.direccion.ciudad.longitud}")
    private String ciudad;

    @NotBlank(message = "{socio.direccion.provincia.obligatorio}")
    private String provincia;

    @Pattern(regexp = "\\d{4}", message = "{socio.direccion.codigoPostal.patron}")
    private String codigoPostal;

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
}
