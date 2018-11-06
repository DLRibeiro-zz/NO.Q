package cadastroUsuario.repositories;

import cadastroUsuario.domain.restaurante.CNPJ;
import cadastroUsuario.domain.restaurante.persistidas.Restaurante;
import java.util.HashMap;
import java.util.List;

public class RepositorioRestauranteMemoria implements IRepositorioRestaurante {
  public HashMap<CNPJ, Restaurante> restaurantes;

  public RepositorioRestauranteMemoria(){
    this.restaurantes = new HashMap<>();
  }
  @Override
  public void salvarRestaurante(Restaurante restaurante) {
    this.restaurantes.put(restaurante.getCnpj(), restaurante);
  }

  @Override
  public void deletarRestaurante(CNPJ cnpj) {
      this.restaurantes.remove(cnpj);
  }

  @Override
  public void modificarRestaurante(Restaurante restaurante) {
      this.restaurantes.replace(restaurante.getCnpj(), restaurante);
  }

  @Override
  public List<Restaurante> buscarRestaurante(CNPJ cnpj) {
    return (List<Restaurante>) this.restaurantes.get(cnpj);
  }

  @Override
  public List<Restaurante> buscarRestaurantes() {
    return (List<Restaurante>) this.restaurantes.values();
  }
}
