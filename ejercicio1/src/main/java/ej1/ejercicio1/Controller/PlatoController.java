package ej1.ejercicio1.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ej1.ejercicio1.Model.Plato;

@RestController
@RequestMapping("/ejercicio1")
public class PlatoController {
    private List<Plato> platos = new ArrayList<>();  

    // Punto 1
    @PostMapping                                     
    public Plato crearPlato(@RequestBody Plato plato) { 
        platos.add(plato);                           
        return plato;                                
    }

    // Punto 2
    @GetMapping                                      
    public List<Plato> listarPlatos() {              
        return platos;                               
    }

    // Punto 3
    @GetMapping("/{numeroPlato}")                         
    public ResponseEntity<Plato> buscarPlato(@PathVariable Integer numeroPlato) { 
        for (Plato plato : platos) {                      
            if (plato.getNumeroPlato().equals(numeroPlato)) { 
                return new ResponseEntity<>(plato, HttpStatus.OK);          
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);        
    }
}