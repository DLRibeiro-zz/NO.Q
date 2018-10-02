package services.controladores;

import domain.restaurante.persistidas.Pedido;
import java.util.List;
import services.cadastros.CadastroPedido;

public class ControladorPedido {

  private CadastroPedido cadastroPedido;

  public ControladorPedido(CadastroPedido cadastroPedido){
    this.cadastroPedido = cadastroPedido;
  }

  public List<Pedido> buscarPedidos(){
      return this.cadastroPedido.buscarPedidos();
  }

  public Pedido buscarPedido(int idPedido){
    return this.cadastroPedido.buscarPedido(idPedido);
  }

  public void realizarPedido(Pedido pedido){
    this.cadastroPedido.realizarPedido(pedido);
  }

}
