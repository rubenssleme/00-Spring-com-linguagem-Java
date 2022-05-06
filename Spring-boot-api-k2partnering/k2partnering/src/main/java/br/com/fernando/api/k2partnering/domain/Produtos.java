package br.com.fernando.api.k2partnering.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categorias categorias;

    private String produto;

    private Double preco;

    private Integer quantidade;

    private String descricao;

    private String foto;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return Objects.equals(id, produtos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Produtos{");
        sb.append("id=").append(id);
        sb.append(", categorias=").append(categorias);
        sb.append(", produto='").append(produto).append('\'');
        sb.append(", preco=").append(preco);
        sb.append(", quantidade=").append(quantidade);
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", foto='").append(foto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}