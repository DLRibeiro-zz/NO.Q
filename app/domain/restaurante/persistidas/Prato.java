package domain.restaurante.persistidas;

import domain.restaurante.Preco;
import io.ebean.Model;

public abstract class Prato extends Model{

  private String descricao;
  private String nome;
  private int tempo;
  private Preco preco;

  public Prato(String nome, String descricao, int tempo, int reais, int centavos){
    this.nome = nome;
    this.descricao = descricao;
    this.tempo = tempo;
    this.preco = new Preco(reais, centavos);
  }

  public Preco getPreco(){
    return this.preco;
  }

  public int getTempo(){
    return this.tempo;
  }
}
