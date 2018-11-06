package cadastroUsuario.repositories;

import cadastroUsuario.domain.restaurante.CNPJ;
import cadastroUsuario.domain.restaurante.persistidas.Prato;
import java.util.List;

public interface IRepositorioPrato {

  public void salvarPrato(Prato prato);

  public void deletarPrato(Prato prato);

  public void modificarPrato(Prato prato);

  public Prato buscarPrato(int id);

  public List<Prato> buscarPratos();

  public List<Prato> buscarPratos(CNPJ cnpj);

}
