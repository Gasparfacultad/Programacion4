package historia.usuarios.controller;

import historia.usuarios.dto.PlanCreateDTO;
import historia.usuarios.model.Plan;
import historia.usuarios.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/socios/{socioId}/planes")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<Plan> crear(
            @PathVariable Long socioId,
            @Valid @RequestBody PlanCreateDTO dto) {

        Plan plan = planService.crearPlan(socioId, dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(plan.getId())
                .toUri();

        return ResponseEntity.created(location).body(plan);
    }
}
