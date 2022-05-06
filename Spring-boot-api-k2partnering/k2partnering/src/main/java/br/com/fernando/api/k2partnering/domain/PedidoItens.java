package br.com.fernando.api.k2partnering.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class PedidoItens implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double subTotal;
    private Integer quantidade;
    private Double valor;

    public PedidoItens() {
    }

    public PedidoItens(Pedidos pedido, Produtos produto, Double subTotal, Integer
            quantidade, Double valor) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.subTotal = subTotal;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValor() {
        return subTotal * quantidade;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PedidoItens other = (PedidoItens) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        StringBuilder builder = new StringBuilder();
        builder.append(getId().getProduto().getProduto());
        builder.append(", Qte: ");
        builder.append(getQuantidade());
        builder.append(", Preço unitário: ");
        builder.append(nf.format(getSubTotal()));
        builder.append(", Subtotal: ");
        builder.append(nf.format(getValor()));
        builder.append("\n");
        return builder.toString();
    }
}
