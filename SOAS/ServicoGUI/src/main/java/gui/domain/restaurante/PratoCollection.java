package gui.domain.restaurante;

import gui.domain.restaurante.persistidas.Prato;
import java.util.List;

public class PratoCollection {
    private List<Prato> pratos;

    public PratoCollection(){};

  public List<Prato> getPratos() {
    return pratos;
  }

  public void setPratos(List<Prato> pratos) {
    this.pratos = pratos;
  }
}
