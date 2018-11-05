package cadastroUsuario.domain.restaurante;

import cadastroUsuario.domain.restaurante.persistidas.Prato;

public class PratoSimples extends Prato {

  public PratoSimples(String nome, String descricao, int tempo, int reais, int centavos){
    super(nome, descricao, tempo, reais, centavos);
  }
  @Override
  public Preco getPreco() {
    return super.getPreco();
  }

  @Override
  public int getTempo() {
    return super.getTempo();
  }
}
