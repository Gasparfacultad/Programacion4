package historia.usuarios.model;

import java.util.List;

public class Plan {

    private Long id;
    private Long socioId;               
    private String objetivo;            
    private Integer frecuenciaSemanal;  
    private Double pesoInicial;         
    private Double altura;              
    private List<String> ejercicios;    

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSocioId() { return socioId; }
    public void setSocioId(Long socioId) { this.socioId = socioId; }

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