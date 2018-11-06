package controlePrato.repositories;

import controlePrato.domain.restaurante.CNPJ;
import controlePrato.domain.restaurante.persistidas.Prato;
import java.util.ArrayList;
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
  public List<Prato> buscarPratos(CNPJ cnpj) {
    List<Prato> pratosList = new ArrayList<>();
    for(Prato prato : this.pratos.values()){
      if(prato.getCnpjRestaurante().equals(cnpj)){
        pratosList.add(prato);
      }
    }
    return pratosList;
  }

  @Override
  public List<Prato> buscarPratos() {
    List<Prato> listPrato = new ArrayList<>();
    for(Prato prato: this.pratos.values()){
      listPrato.add(prato);
    }
    return listPrato;
  }
}
