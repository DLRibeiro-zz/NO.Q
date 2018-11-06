package fachada.domain.restaurante.persistidas;

import fachada.domain.restaurante.Preco;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;

public class Pedido{

  @NotEmpty
  private List<Prato> pratos;

  @NotEmpty
  private Preco precoPedido;

  @NotEmpty
  private int usuarioPedido;

  public Pedido(){

  }
  @JsonCreator
  public Pedido(
      @JsonProperty("pratos") List<Prato> pratos, @JsonProperty("usuarioPedido") int usuarioPedido){
    this.pratos = pratos;
    Preco precoPedido = new Preco(0,0);
    for(Prato prato: pratos){
        precoPedido.somarPreco(prato.getPreco());
    }
    this.usuarioPedido = usuarioPedido;
  }

  @JsonGetter("pratos")
  public List<Prato> getPratos() {
    return pratos;
  }

  @JsonSetter("pratos")
  public void setPratos(List<Prato> pratos) {
    this.pratos = pratos;
  }

  @JsonGetter("precoPedido")
  public Preco getPrecoPedido() {
    return precoPedido;
  }

  @JsonSetter("precoPedido")
  public void setPrecoPedido(Preco precoPedido) {
    this.precoPedido = precoPedido;
  }

  @JsonGetter("usuarioPedido")
  public int getUsuarioPedido() {
    return usuarioPedido;
  }

  @JsonSetter("usuarioPedido")
  public void setUsuarioPedido(int usuarioPedido) {
    this.usuarioPedido = usuarioPedido;
  }
}
