package br.com.fernando.api.k2partnering.dto;

import br.com.fernando.api.k2partnering.domain.Categorias;
import br.com.fernando.api.k2partnering.domain.Produtos;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String foto;
    private Categorias categorias;
    private String descricao;
    private Integer quantidade;
    private Double preco;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produtos obj) {
        id = obj.getId();
        categorias = obj.getCategorias();
        foto = obj.getFoto();
        descricao = obj.getDescricao();
        quantidade = obj.getQuantidade();
        nome = obj.getProduto();
        preco = obj.getPreco();
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
