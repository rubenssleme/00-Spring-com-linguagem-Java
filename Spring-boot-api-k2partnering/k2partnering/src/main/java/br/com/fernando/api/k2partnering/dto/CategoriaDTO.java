package br.com.fernando.api.k2partnering.dto;


import br.com.fernando.api.k2partnering.domain.Categorias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String categoria;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categorias obj) {

        id = obj.getId();
        categoria = obj.getCategoria();
    }

    public Integer getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}