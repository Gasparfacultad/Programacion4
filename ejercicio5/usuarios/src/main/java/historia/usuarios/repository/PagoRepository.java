package historia.usuarios.repository;

import historia.usuarios.model.Pago;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PagoRepository {

    private List<Pago> pagos = new ArrayList<>();

    private Long contadorId = 1L;

    public Pago guardar(Pago pago) {
        pago.setId(contadorId++);
        pagos.add(pago);
        return pago;
    }

    public List<Pago> obtenerTodos() {
        return pagos;
    }
}