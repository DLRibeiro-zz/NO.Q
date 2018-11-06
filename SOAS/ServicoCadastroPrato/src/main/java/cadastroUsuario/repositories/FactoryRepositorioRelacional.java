package cadastroUsuario.repositories;

public class FactoryRepositorioRelacional extends AbstractFactoryRepositorio {

  @Override
  public IRepositorioRestaurante criarRepositorioRestaurante() {
    return new RepositorioRestauranteRelacional();
  }
  //TODO IMPLEMENTAR AQUI QUANDO PRECISAR DE PRATO
  @Override
  public IRepositorioPrato criarRepositorioPrato() {
    return null;
  }
  //TODO IMPLEMENTAR AQUI QUANDO PRECISAR DE PEDIDO
  @Override
  public IRepositorioPedido criarRepositorioPedido() {
    return null;
  }
}
