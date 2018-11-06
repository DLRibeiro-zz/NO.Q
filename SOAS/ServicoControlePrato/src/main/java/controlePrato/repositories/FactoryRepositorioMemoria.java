package controlePrato.repositories;

public class FactoryRepositorioMemoria extends AbstractFactoryRepositorio {

  @Override
  public IRepositorioRestaurante criarRepositorioRestaurante() {
    return new RepositorioRestauranteMemoria();
  }
  //TODO IMPLEMENTAR AQUI QUANDO PRECISAR DE PRATO
  @Override
  public IRepositorioPrato criarRepositorioPrato() {
    return new RepositorioPratoMemoria();
  }
  //TODO IMPLEMENTAR AQUI QUANDO PRECISAR DE PEDIDO
  @Override
  public IRepositorioPedido criarRepositorioPedido() {
    return null;
  }

}
