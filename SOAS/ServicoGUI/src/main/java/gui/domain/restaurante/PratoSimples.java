package gui.domain.restaurante;

import gui.domain.restaurante.persistidas.Prato;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PratoSimples extends Prato {

  public PratoSimples(){}
  @JsonCreator
  public PratoSimples(@JsonProperty("nome") String nome,
      @JsonProperty("descricao") String descricao,
      @JsonProperty("tempo") int tempo,
      @JsonProperty("preco") Preco preco){
    super(nome, descricao, tempo, preco);
  }
  @JsonGetter("preco")
  @Override
  public Preco getPreco() {
    return super.getPreco();
  }

  @JsonGetter("tempo")
  @Override
  public int getTempo() {
    return super.getTempo();
  }
}
