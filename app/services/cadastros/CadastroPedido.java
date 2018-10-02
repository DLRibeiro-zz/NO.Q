package services.cadastros;

import domain.restaurante.persistidas.Pedido;
import java.util.List;
import repositories.IRepositorioPedido;

public class CadastroPedido {

  IRepositorioPedido repositorioPedido;

  public CadastroPedido(IRepositorioPedido repositorioPedido){
    this.repositorioPedido = repositorioPedido;
  }

  public List<Pedido> buscarPedidos() {
    return this.repositorioPedido.buscarPedidos();
  }

  public Pedido buscarPedido(int idPedido) {
    return this.repositorioPedido.buscarPedido(idPedido);
  }

  public void realizarPedido(Pedido pedido) {
    this.repositorioPedido.realizarPedido(pedido);
  }
}
