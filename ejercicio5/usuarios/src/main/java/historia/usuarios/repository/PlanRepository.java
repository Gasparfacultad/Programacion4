package historia.usuarios.repository;

import historia.usuarios.model.Plan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlanRepository {

    private List<Plan> planes = new ArrayList<>();

    private Long contadorId = 1L;

    public Plan guardar(Plan plan) {
        plan.setId(contadorId++);
        planes.add(plan);
        return plan;
    }

    public List<Plan> obtenerTodos() {
        return planes;
    }
}