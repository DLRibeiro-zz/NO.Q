package cadastroUsuario.domain.restaurante;

import cadastroUsuario.domain.restaurante.persistidas.Prato;
import java.util.ArrayList;
import java.util.List;

public class PratoComposto extends Prato {

  public List<Prato> adicionais;

  public PratoComposto(String nome, String descricao, int tempo, int reais, int centavos) {
    super(nome, descricao, tempo, reais, centavos);
    this.adicionais = new ArrayList<>();
  }

  public void adicionarAdicionais(Prato prato){
    this.adicionais.add(prato);
  }

  public void removerAdicionais(Prato prato){
    this.adicionais.remove(prato);
  }

  public Preco getPreco(){
    Preco preco = super.getPreco();
    for(Prato adicional: adicionais){
      Preco precoAdicional = adicional.getPreco();
      preco.somarPreco(precoAdicional);
    }
    return preco;
  }

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
