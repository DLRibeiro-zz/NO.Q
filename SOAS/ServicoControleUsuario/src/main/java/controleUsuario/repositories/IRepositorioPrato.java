package controleUsuario.repositories;

import controleUsuario.domain.restaurante.CNPJ;
import controleUsuario.domain.restaurante.persistidas.Prato;
import java.util.List;

public interface IRepositorioPrato {

  public void salvarPrato(Prato prato);

  public void deletarPrato(Prato prato);

  public void modificarPrato(Prato prato);

  public Prato buscarPrato(int id);

  public List<Prato> buscarPratos();

  public List<Prato> buscarPratos(CNPJ cnpj);

}
