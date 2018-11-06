package cadastroUsuario.repositories;

import cadastroUsuario.domain.restaurante.persistidas.Prato;
import java.util.HashMap;
import java.util.List;

public class RepositorioPratoMemoria implements IRepositorioPrato {
  public HashMap<Integer, Prato> pratos;

  public RepositorioPratoMemoria(){
    this.pratos = new HashMap<>();
  }

  @Override
  public void salvarPrato(Prato prato) {
      if(prato.getId()<0){
        prato.setId(this.pratos.size());
        this.pratos.put(prato.getId(), prato);
      }
  }

  @Override
  public void deletarPrato(Prato prato) {
      this.pratos.remove(prato.getId());
  }

  @Override
  public void modificarPrato(Prato prato) {
     this.pratos.replace(prato.getId(), prato);
  }

  @Override
  public Prato buscarPrato(int id) {
    return this.pratos.get(id);
  }

  @Override
  public List<Prato> buscarPratos() {
    return (List<Prato>) this.pratos.values();
  }
}
