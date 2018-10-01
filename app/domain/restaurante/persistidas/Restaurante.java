package domain.restaurante.persistidas;

import domain.restaurante.CNPJ;
import domain.restaurante.Email;
import domain.restaurante.Endereco;
import domain.restaurante.Horario;

public class Restaurante {
    private CNPJ cnpj;
    private Email email;
    private Endereco endereco;
    private Horario horario;
    private String senha;

    public Restaurante(CNPJ cnpj, Email email, Endereco endereco, Horario horario, String senha) {
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.horario = horario;
        this.senha = senha;
    }

    public CNPJ getCnpj() {
        return cnpj;
    }

    public void setCnpj(CNPJ cnpj) {
        this.cnpj = cnpj;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
