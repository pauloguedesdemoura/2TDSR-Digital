package br.com.fiap.loja.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="pedido",sequenceName = "SQ_T_PEDIDO",allocationSize = 1)
public class Pedido {

    @Id
    @GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Future
    private LocalDate data;

    @Size(max = 100, min = 3)
    @NotBlank
    private String produto;

    @DecimalMin("0")
    private double valor;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
