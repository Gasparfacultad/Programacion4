package historia.usuarios.dto;

import org.hibernate.validator.constraints.URL;
import historia.usuarios.validation.OnCreate;
import historia.usuarios.validation.OnUpdate;
import jakarta.validation.constraints.*;

public class SocioUpdateDTO {

    @Null(groups = OnCreate.class, message = "{socio.id.obligatorio}")
    @NotNull(groups = OnUpdate.class, message = "{socio.id.obligatorio}")
    private Long id;

    @URL(message = "{socio.fotoPerfil.url}")
    private String fotoPerfil;

    @Size(min = 3, max = 15, message = "{socio.alias.longitud}")
    @Pattern(regexp = "\\S+", message = "{socio.alias.longitud}")
    private String alias;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
}
