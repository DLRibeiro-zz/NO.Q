package domain.restaurante.persistidas;

import domain.restaurante.Preco;
import java.util.List;

public class Pedido {

  private List<Prato> pratos;
  private Preco precoPedido;
  private int usuarioPedido;

  public Pedido(List<Prato> pratos, int usuarioPedido){
    this.pratos = pratos;
    Preco precoPedido = new Preco(0,0);
    for(Prato prato: pratos){
        precoPedido.somarPreco(prato.getPreco());
    }
    this.usuarioPedido = usuarioPedido;
  }

}
