package com.club.socios.repository;

import com.club.socios.controller.SocioController;
import com.club.socios.model.Socio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SocioRepository {

    private List<SocioController> socios = new ArrayList<>();

    private Long contadorId = 1L;
    public SocioController guardar(SocioController socio) {
        socio.setId(contadorId++);
        socios.add(socio);
        return socio;
    }

    public List<SocioController> obtenerTodos() {
        return socios;
    }

    public Optional<SocioController> buscarPorId(Long id) {
        return socios.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public boolean existsByDni(String dni) {
        return socios.stream()
                .anyMatch(s -> s.getDni().equals(dni));
    }

    public SocioController actualizar(SocioController socio) {
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getId().equals(socio.getId())) {
                socios.set(i, socio);
                return socio;
            }
        }
        return socio;
    }
}