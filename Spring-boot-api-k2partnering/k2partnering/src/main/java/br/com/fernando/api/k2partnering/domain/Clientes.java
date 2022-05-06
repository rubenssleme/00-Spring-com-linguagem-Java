package br.com.fernando.api.k2partnering.domain;

import br.com.fernando.api.k2partnering.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String senha;

    private String rua;
    private String cidade;
    private String bairro;
    private String cep;
    private String estado;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Clientes(Integer id, String nome , String email ) {
        this.id = id;
        this.nome =nome;
        this.email = email;
        addPerfil(Perfil.CLIENTE);
    }
    public Clientes(Integer id, String nome, String email, String senha,
                    String rua, String cidade, String bairro, String cep, String estado) {
        super();
        this.id = id;
        this.nome =nome;
        this.email = email;
        this.senha = senha;
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        addPerfil(Perfil.CLIENTE);
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(Perfil::toEnum).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }
}