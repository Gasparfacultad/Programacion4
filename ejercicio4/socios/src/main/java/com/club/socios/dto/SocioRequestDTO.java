package com.club.socios.dto;

import com.club.socios.validation.DniValido;
import com.club.socios.validation.OnCreate;
import com.club.socios.validation.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class SocioRequestDTO {

    @NotBlank(message = "{socio.nombre.obligatorio}", groups = {OnCreate.class, OnUpdate.class})
    private String nombre;

    @NotBlank(message = "{socio.apellido.obligatorio}", groups = {OnCreate.class, OnUpdate.class})
    private String apellido;

    @NotBlank(message = "{socio.dni.obligatorio}", groups = OnCreate.class)
    @DniValido(groups = OnCreate.class)
    private String dni;

    @NotBlank(message = "{socio.email.obligatorio}", groups = OnCreate.class)
    // Obligatorio al crear, opcional al actualizar
    @Email(message = "{socio.email.formato}", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @NotBlank(message = "{socio.password.obligatorio}", groups = OnCreate.class)
    @Size(min = 8, message = "{socio.password.longitud}", groups = OnCreate.class)
    private String password;

    @NotNull(message = "{socio.fechaNacimiento.obligatorio}", groups = OnCreate.class)
    @Past(message = "{socio.fechaNacimiento.pasado}", groups = {OnCreate.class, OnUpdate.class})
    private LocalDate fechaNacimiento;

    @NotNull(message = "{socio.direccion.obligatorio}", groups = OnCreate.class)
    @Valid
    private DireccionDTO direccion;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public DireccionDTO getDireccion() { return direccion; }
    public void setDireccion(DireccionDTO direccion) { this.direccion = direccion; }
}