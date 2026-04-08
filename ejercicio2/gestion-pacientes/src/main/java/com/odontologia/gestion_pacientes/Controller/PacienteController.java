package com.odontologia.gestion_pacientes.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.odontologia.gestion_pacientes.Model.Paciente;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/gestion_pacientes")
public class PacienteController {
    // PUNTO 1
    private List<Paciente> pacientes =  new ArrayList<>();
    private Long nextId = 1L;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        validarPaciente(paciente);

        if (buscarPacientePorDni(paciente.getDni()) != null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Ya existe un paciente con el Dni " + paciente.getDni()
            );
        }

        paciente.setId(nextId);
        nextId++;

        pacientes.add(paciente);
        return paciente;
    }
    
    //PUNTO 2
    @GetMapping()
    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }

    //PUNTO 3
    @GetMapping("/menores")
    public List<Paciente> obtenerMenores() {
        List<Paciente> menores = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            if (esMenorDeEdad(paciente)) {
                menores.add(paciente);
            }
        }
        return menores;
    }
    
    // FUNCIONALIDADES
    private boolean esMenorDeEdad(Paciente paciente) {
        int edad = Period.between(paciente.getFechaNacimiento(), LocalDate.now()).getYears();
        return edad < 18;
    }

    private Paciente buscarPacientePorDni(Integer dni) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                return paciente;
            }
        }
        return null;
    }

    private void validarPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe enviar los datos del cliente");
        }
        if (paciente.getDni() == null || paciente.getDni() <= 0) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El DNI es obligatorio y debe ser mayor a 0");
        }
        if (paciente.getNombre() == null || paciente.getNombre().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre es obligatorio");
        }
        if (paciente.getApellido() == null || paciente.getApellido().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El apellido es obligatorio");
        }
        if (paciente.getFechaNacimiento() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de nacimiento es obligatoria");
        }
        if (paciente.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de nacimiento no puede ser futura");
        }
    }
}