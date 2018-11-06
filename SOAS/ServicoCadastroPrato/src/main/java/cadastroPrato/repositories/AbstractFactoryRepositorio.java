package cadastroPrato.repositories;

public abstract class AbstractFactoryRepositorio {

  public abstract IRepositorioRestaurante criarRepositorioRestaurante();

  public abstract IRepositorioPrato criarRepositorioPrato();

  public abstract IRepositorioPedido criarRepositorioPedido();

}
