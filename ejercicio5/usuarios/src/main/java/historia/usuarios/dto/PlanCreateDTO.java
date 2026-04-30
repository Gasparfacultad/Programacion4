package historia.usuarios.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class PlanCreateDTO {

    @NotBlank(message = "{plan.objetivo.longitud}")
    @Size(min = 10, max = 200, message = "{plan.objetivo.longitud}")
    private String objetivo;

    @NotNull(message = "{plan.frecuencia.rango}")
    @Min(value = 1, message = "{plan.frecuencia.rango}")
    @Max(value = 7, message = "{plan.frecuencia.rango}")
    private Integer frecuenciaSemanal;

    @NotNull(message = "{plan.peso.rango}")
    @DecimalMin(value = "30.0", message = "{plan.peso.rango}")
    @DecimalMax(value = "250.0", message = "{plan.peso.rango}")
    private Double pesoInicial;

    @NotNull(message = "{plan.altura.rango}")
    @DecimalMin(value = "1.0", message = "{plan.altura.rango}")
    @DecimalMax(value = "2.5", message = "{plan.altura.rango}")
    private Double altura;

    @NotNull(message = "{plan.ejercicios.minimo}")
    @Size(min = 3, message = "{plan.ejercicios.minimo}")
    private List<String> ejercicios;

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public Integer getFrecuenciaSemanal() { return frecuenciaSemanal; }
    public void setFrecuenciaSemanal(Integer frecuenciaSemanal) { this.frecuenciaSemanal = frecuenciaSemanal; }

    public Double getPesoInicial() { return pesoInicial; }
    public void setPesoInicial(Double pesoInicial) { this.pesoInicial = pesoInicial; }

    public Double getAltura() { return altura; }
    public void setAltura(Double altura) { this.altura = altura; }

    public List<String> getEjercicios() { return ejercicios; }
    public void setEjercicios(List<String> ejercicios) { this.ejercicios = ejercicios; }
}