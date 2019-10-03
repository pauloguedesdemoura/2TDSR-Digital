package br.com.fiap.loja.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="cliente",sequenceName = "SQ_T_CLIENTE", allocationSize = 1)
public class Cliente {

    @Id
    @GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Size(max = 80)
    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @Email(message = "E-mail inválido")
    private String email;

    @Past
    private LocalDate dataNascimento;

    @CPF(message = "CPF inválido")
    private String cpf;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
