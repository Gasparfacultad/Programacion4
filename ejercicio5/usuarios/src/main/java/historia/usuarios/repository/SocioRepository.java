package historia.usuarios.repository;

import historia.usuarios.model.Socio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SocioRepository {

    private List<Socio> socios = new ArrayList<>();

    private Long contadorId = 1L;

    public Socio guardar(Socio socio) {
        socio.setId(contadorId++);
        socios.add(socio);
        return socio;
    }

    public Optional<Socio> buscarPorId(Long id) {
        return socios.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public List<Socio> obtenerTodos() {
        return socios;
    }

    public Socio actualizar(Socio socio) {
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getId().equals(socio.getId())) {
                socios.set(i, socio);
                return socio;
            }
        }
        return socio;
    }
}