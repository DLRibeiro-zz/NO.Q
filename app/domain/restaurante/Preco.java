package domain.restaurante;

public class Preco {
  private int reais;
  private int centavos;

  public Preco(int reais, int centavos){
    this.reais = reais;
    this.centavos = centavos;
  }

  public int getReais() {
    return reais;
  }

  public void setReais(int reais) {
    this.reais = reais;
  }

  public int getCentavos() {
    return centavos;
  }

  public void setCentavos(int centavos) {
    this.centavos = centavos;
  }

  public void ajustar(){
    int extras = this.getCentavos()/100;
    this.centavos = this.centavos%100;
    this.reais = this.reais + extras;
  }

  public void somarPreco(Preco preco){
    this.reais += preco.getReais();
    this.centavos += preco.getCentavos();
    this.ajustar();
  }
}
