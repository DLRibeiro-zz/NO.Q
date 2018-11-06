package controlePrato.domain.restaurante;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.NotEmpty;

public class Endereco {
    @NotEmpty
    private String numero;
    @NotEmpty
    private String rua;
    @NotEmpty
    private String bairro;
    @NotEmpty
    private String cidade;
    @NotEmpty
    private String estado;

    public Endereco(){}
    @JsonCreator
    public Endereco(@JsonProperty("numero") String numero,
        @JsonProperty("rua") String rua,
        @JsonProperty("bairro") String bairro,
        @JsonProperty("cidade") String cidade,
        @JsonProperty("estado") String estado){
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    @JsonGetter("numero")
    public String getNumero() {
        return numero;
    }
    @JsonSetter("numero")
    public void setNumero(String numero) {
        this.numero = numero;
    }
    @JsonGetter("rua")
    public String getRua() {
        return rua;
    }
    @JsonSetter("rua")
    public void setRua(String rua) {
        this.rua = rua;
    }
    @JsonGetter("bairro")
    public String getBairro() {
        return bairro;
    }
    @JsonSetter("bairro")
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    @JsonGetter("cidade")
    public String getCidade() {
        return cidade;
    }
    @JsonSetter("cidade")
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    @JsonGetter("estado")
    public String getEstado() {
        return estado;
    }
    @JsonSetter("estado")
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
