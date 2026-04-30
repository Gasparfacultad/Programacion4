package historia.usuarios.service;

import historia.usuarios.dto.SocioCreateDTO;
import historia.usuarios.dto.SocioResponseDTO;
import historia.usuarios.dto.SocioUpdateDTO;
import historia.usuarios.model.Socio;
import historia.usuarios.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public SocioResponseDTO crearSocio(SocioCreateDTO dto) {

        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setEmail(dto.getEmail());
        socio.setDni(dto.getDni());
        socio.setFechaNacimiento(dto.getFechaNacimiento());
        socio.setTelefono(dto.getTelefono());
        socio.setFechaRegistro(LocalDateTime.now());

        Socio guardado = socioRepository.guardar(socio);

        return mapearAResponseDTO(guardado);
    }

    public SocioResponseDTO actualizarPerfil(SocioUpdateDTO dto) {

        Socio socio = socioRepository.buscarPorId(dto.getId())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado con id: " + dto.getId()));

        if (dto.getFotoPerfil() != null) socio.setFotoPerfil(dto.getFotoPerfil());
        if (dto.getAlias() != null) socio.setAlias(dto.getAlias());

        Socio actualizado = socioRepository.actualizar(socio);

        return mapearAResponseDTO(actualizado);
    }

    private SocioResponseDTO mapearAResponseDTO(Socio socio) {

        SocioResponseDTO response = new SocioResponseDTO();
        response.setId(socio.getId());
        response.setNombre(socio.getNombre());
        response.setApellido(socio.getApellido());
        response.setEmail(socio.getEmail());
        response.setTelefono(socio.getTelefono());
        response.setFotoPerfil(socio.getFotoPerfil());
        response.setAlias(socio.getAlias());
        response.setFechaRegistro(socio.getFechaRegistro());
        return response;
    }
}
