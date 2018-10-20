package services.cadastros;

import domain.restaurante.CNPJ;
import domain.restaurante.persistidas.Restaurante;
import java.util.List;
import java.util.Set;

import io.ebean.enhance.common.SysoutMessageOutput;
import repositories.IRepositorioRestaurante;

public class CadastroRestaurante {

    private IRepositorioRestaurante repositorioRestaurante;

    public CadastroRestaurante(IRepositorioRestaurante repositorioRestaurante){
        this.repositorioRestaurante = repositorioRestaurante;
    }

    public void salvarRestaurante(Restaurante restaurante){
        this.repositorioRestaurante.salvarRestaurante(restaurante);
    }

    public void deletetarRestaurante(CNPJ cnpj){
        this.repositorioRestaurante.deletarRestaurante(cnpj);
    }

    public void modificarRestaurante(Restaurante restaurante){
        this.repositorioRestaurante.modificarRestaurante(restaurante);
    }

    public List<Restaurante> buscarRestaurante(CNPJ cnpj){
        return this.repositorioRestaurante.buscarRestaurante(cnpj);
    }

    public List<Restaurante> buscarRestaurantes(){

        return this.repositorioRestaurante.buscarRestaurantes();
    }

}
