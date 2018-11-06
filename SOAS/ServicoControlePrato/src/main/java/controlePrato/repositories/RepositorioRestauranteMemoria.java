package controlePrato.repositories;

import controlePrato.domain.restaurante.CNPJ;
import controlePrato.domain.restaurante.persistidas.Restaurante;
import java.util.ArrayList;
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
    List<Restaurante> restaurantesList = new ArrayList<>();
    restaurantesList.add(this.restaurantes.get(cnpj));
    return restaurantesList;
  }

  @Override
  public List<Restaurante> buscarRestaurantes() {
    List<Restaurante> restaurantesList = new ArrayList<>();
    for(Restaurante restaurante: this.restaurantes.values()){
      restaurantesList.add(restaurante);
    }
    return restaurantesList;
  }
}
