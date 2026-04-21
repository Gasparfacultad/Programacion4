package com.club.socios.service;

import com.club.socios.dto.DireccionDTO;
import com.club.socios.dto.SocioRequestDTO;
import com.club.socios.dto.SocioResponseDTO;
import com.club.socios.model.Socio;
import com.club.socios.exception.DniDuplicadoException;
import com.club.socios.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SocioService {

    private final SocioRepository socioRepository;
    

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
        
    }

    public SocioResponseDTO crearSocio(SocioRequestDTO dto) {

        
        if (socioRepository.existsByDni(dto.getDni())) {
            throw new DniDuplicadoException("El DNI ingresado ya se encuentra registrado en el sistema.");
            
        }

        // --- Mapeo RequestDTO → Entidad ---
        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setDni(dto.getDni());
        socio.setEmail(dto.getEmail());
        socio.setPassword(dto.getPassword());       
        socio.setFechaNacimiento(dto.getFechaNacimiento());
        socio.setFechaRegistro(LocalDateTime.now()); 

        if (dto.getDireccion() != null) {
            socio.setCalle(dto.getDireccion().getCalle());
            socio.setCiudad(dto.getDireccion().getCiudad());
            socio.setProvincia(dto.getDireccion().getProvincia());
            socio.setCodigoPostal(dto.getDireccion().getCodigoPostal());
        }

        socio.setFechaVencimientoMembresia(null);

        Socio guardado = socioRepository.guardar(socio);

        return mapearAResponseDTO(guardado);
    }

    public SocioResponseDTO actualizarSocio(Long id, SocioRequestDTO dto) {

        Socio socio = socioRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado con id: " + id));

        if (dto.getNombre() != null) socio.setNombre(dto.getNombre());
        if (dto.getApellido() != null) socio.setApellido(dto.getApellido());
        if (dto.getEmail() != null) socio.setEmail(dto.getEmail());
        if (dto.getFechaNacimiento() != null) socio.setFechaNacimiento(dto.getFechaNacimiento());

        if (dto.getDireccion() != null) {
            socio.setCalle(dto.getDireccion().getCalle());
            socio.setCiudad(dto.getDireccion().getCiudad());
            socio.setProvincia(dto.getDireccion().getProvincia());
            socio.setCodigoPostal(dto.getDireccion().getCodigoPostal());
        }

        Socio actualizado = socioRepository.actualizar(socio);

        return mapearAResponseDTO(actualizado);
    }

    public SocioResponseDTO obtenerPorId(Long id) {
        Socio socio = socioRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado con id: " + id));
        return mapearAResponseDTO(socio);
    }

    private SocioResponseDTO mapearAResponseDTO(Socio socio) {

        SocioResponseDTO response = new SocioResponseDTO();
        response.setId(socio.getId());
        response.setNombre(socio.getNombre());
        response.setApellido(socio.getApellido());
        response.setEmail(socio.getEmail());
        response.setFechaRegistro(socio.getFechaRegistro());
        response.setEstadoMembresia(calcularEstadoMembresia(socio.getFechaVencimientoMembresia()));

        DireccionDTO direccionDTO = new DireccionDTO();
        direccionDTO.setCalle(socio.getCalle());
        direccionDTO.setCiudad(socio.getCiudad());
        direccionDTO.setProvincia(socio.getProvincia());
        direccionDTO.setCodigoPostal(socio.getCodigoPostal());
        response.setDireccion(direccionDTO);

        return response;
    }

    private String calcularEstadoMembresia(LocalDate fechaVencimiento) {

        if (fechaVencimiento == null) {
            return "SIN MEMBRESIA";

        } else if (fechaVencimiento.isAfter(LocalDate.now())) {
            return "ACTIVO";
            
        } else {
            return "VENCIDO";
        }
    }
}