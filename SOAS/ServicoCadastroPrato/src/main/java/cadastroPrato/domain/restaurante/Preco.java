package cadastroPrato.domain.restaurante;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.NotEmpty;

public class Preco {
  @NotEmpty
  private int reais;
  @NotEmpty
  private int centavos;

  public Preco(){}
  @JsonCreator
  public Preco(@JsonProperty("reais") int reais, @JsonProperty("centavos") int centavos){
    this.reais = reais;
    this.centavos = centavos;
  }
  @JsonGetter("reais")
  public int getReais() {
    return reais;
  }
  @JsonSetter("reais")
  public void setReais(int reais) {
    this.reais = reais;
  }
  @JsonGetter("centavos")
  public int getCentavos() {
    return centavos;
  }
  @JsonSetter("centavos")
  public void setCentavos(int centavos) {
    this.centavos = centavos;
  }

  public void ajustar(){
    int extras = this.getCentavos()/100;
    this.centavos = this.centavos%100;
    this.reais = this.reais + extras;
  }

  public void somarPreco(Preco preco){
    this.reais += preco.getReais();
    this.centavos += preco.getCentavos();
    this.ajustar();
  }
}
