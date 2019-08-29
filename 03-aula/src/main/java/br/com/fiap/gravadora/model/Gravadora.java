package br.com.fiap.gravadora.model;

import javax.persistence.*;

//CRIAR A API COM CRUD

@Entity
@SequenceGenerator(name="grav",sequenceName = "sq_gravadora", allocationSize = 1)
public class Gravadora {

    @Id
    @GeneratedValue(generator = "grav", strategy = GenerationType.SEQUENCE)
    private int codigo;

    private String nome;

    private boolean internacional;

    private double faturamento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isInternacional() {
        return internacional;
    }

    public void setInternacional(boolean internacional) {
        this.internacional = internacional;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }
}
