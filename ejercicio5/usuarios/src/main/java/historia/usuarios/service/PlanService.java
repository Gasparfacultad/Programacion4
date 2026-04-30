package historia.usuarios.service;

import historia.usuarios.dto.PlanCreateDTO;
import historia.usuarios.model.Plan;
import historia.usuarios.repository.PlanRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan crearPlan(Long socioId, PlanCreateDTO dto) {

        Plan plan = new Plan();
        plan.setSocioId(socioId);
        plan.setObjetivo(dto.getObjetivo());
        plan.setFrecuenciaSemanal(dto.getFrecuenciaSemanal());
        plan.setPesoInicial(dto.getPesoInicial());
        plan.setAltura(dto.getAltura());
        plan.setEjercicios(dto.getEjercicios());

        return planRepository.guardar(plan);
    }
}
