package controlePrato.repositories;

import controlePrato.domain.restaurante.persistidas.Pedido;
import java.util.List;

public class RepositorioPedidoRelacional implements IRepositorioPedido {

  @Override
  public List<Pedido> buscarPedidos() {
    return null;
  }

  @Override
  public Pedido buscarPedido(int idPedido) {
    return null;
  }

  @Override
  public void realizarPedido(Pedido pedido) {

  }
}
