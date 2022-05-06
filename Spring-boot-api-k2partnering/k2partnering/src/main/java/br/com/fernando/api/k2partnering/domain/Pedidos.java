package br.com.fernando.api.k2partnering.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Clientes clientes;

    private String status;

    private String sessao;

    public Pedidos() {
    }
    public Pedidos(Integer id ,LocalDate data ,String status , String sessao, Clientes clientes) {
        this.id = id;
        this.data = LocalDate.now();
        this.sessao = sessao;
        this.status = status;
        this.clientes = clientes;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return LocalDate.now();
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return id.equals(pedidos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pedidos{");
        sb.append("id=").append(id);
        sb.append(", data=").append(data);
        sb.append(", status='").append(status).append('\'');
        sb.append(", sessao='").append(sessao).append('\'');
        sb.append('}');
        return sb.toString();
    }
}