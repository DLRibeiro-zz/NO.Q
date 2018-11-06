package controlePrato.domain.restaurante.persistidas;

import controlePrato.domain.restaurante.CNPJ;
import controlePrato.domain.restaurante.Email;
import controlePrato.domain.restaurante.Endereco;
import controlePrato.domain.restaurante.Horario;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.NotEmpty;

public class Restaurante{

    @NotEmpty
    private CNPJ cnpj;
    @NotEmpty
    private Email email;
    @NotEmpty
    private Endereco endereco;
    @NotEmpty
    private Horario horario;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String senha;

    public Restaurante(){}

    public Restaurante(
        @JsonProperty("nome") String nome,
        @JsonProperty("cnpj") CNPJ cnpj,
        @JsonProperty("email") Email email,
        @JsonProperty("horario") Horario horario,
        @JsonProperty("endereco") Endereco endereco,
        @JsonProperty("senha") String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco; //MODIFICAR O FORMATO DO ENDEREÇO E DO HORARIO
        this.horario = horario;
        this.senha = senha;
    }
    @JsonGetter("nome")
    public String getNome() {
        return nome;
    }
    @JsonSetter("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }
    @JsonGetter("cnpj")
    public CNPJ getCnpj() {
        return cnpj;
    }
    @JsonSetter("cnpj")
    public void setCnpj(CNPJ cnpj) {
        this.cnpj = cnpj;
    }
    @JsonGetter("email")
    public Email getEmail() {
        return email;
    }
    @JsonSetter("email")
    public void setEmail(Email email) {
        this.email = email;
    }
    @JsonGetter("endereco")
    public Endereco getEndereco() {
        return endereco;
    }
    @JsonSetter("endereco")
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    @JsonGetter("horario")
    public Horario getHorario() {
        return horario;
    }
    @JsonSetter("horario")
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    @JsonGetter("senha")
    public String getSenha() {
        return senha;
    }
    @JsonSetter("senha")
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
