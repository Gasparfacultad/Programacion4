package historia.usuarios.dto;

import historia.usuarios.validation.MayorDeEdad;
import historia.usuarios.validation.OnCreate;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class SocioCreateDTO {

    @NotBlank(message = "{socio.nombre.obligatorio}")
    private String nombre;

    @NotBlank(message = "{socio.apellido.obligatorio}")
    private String apellido;

    @NotBlank(message = "{socio.email.formato}")
    @Email(message = "{socio.email.formato}")
    private String email;

    @NotBlank(message = "{socio.dni.patron}")
    @Pattern(regexp = "\\d{8}", message = "{socio.dni.patron}")
    private String dni;

    @NotNull(message = "{socio.fechaNacimiento.pasado}")
    @Past(message = "{socio.fechaNacimiento.pasado}")
    @MayorDeEdad
    private LocalDate fechaNacimiento;

    @Pattern(regexp = "\\+\\d+", message = "{socio.telefono.patron}")
    private String telefono;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}