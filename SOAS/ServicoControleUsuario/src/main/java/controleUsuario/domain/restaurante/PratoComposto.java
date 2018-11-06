package controleUsuario.domain.restaurante;

import controleUsuario.domain.restaurante.persistidas.Prato;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class PratoComposto extends Prato {

  public List<Prato> adicionais;

  public PratoComposto(){}

  @JsonCreator
  public PratoComposto(@JsonProperty("nome") String nome,
      @JsonProperty("descricao") String descricao,
      @JsonProperty("tempo") int tempo,
      @JsonProperty("preco") Preco preco) {
    super(nome, descricao, tempo, preco);
    this.adicionais = new ArrayList<>();
  }


  public void adicionarAdicionais(Prato prato){
    this.adicionais.add(prato);
  }

  public void removerAdicionais(Prato prato){
    this.adicionais.remove(prato);
  }

  @JsonGetter("preco")
  public Preco getPreco(){
    Preco preco = super.getPreco();
    for(Prato adicional: adicionais){
      Preco precoAdicional = adicional.getPreco();
      preco.somarPreco(precoAdicional);
    }
    return preco;
  }
  @JsonGetter("adicionais")
  public List<Prato> getAdicionais(){
    return this.adicionais;
  }

  @JsonGetter("tempo")
  @Override
  public int getTempo() {
    int tempo = super.getTempo();
    for(Prato adicional : adicionais){
      int tempoAdicioanl = adicional.getTempo();
      if(tempoAdicioanl > tempo){
        tempo = tempoAdicioanl;
      }
    }
    return tempo;
  }
}
