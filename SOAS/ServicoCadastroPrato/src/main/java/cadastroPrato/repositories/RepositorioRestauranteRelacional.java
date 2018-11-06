package cadastroPrato.repositories;

import cadastroPrato.domain.restaurante.CNPJ;
import cadastroPrato.domain.restaurante.persistidas.Restaurante;
import java.util.ArrayList;
import java.util.List;

public class RepositorioRestauranteRelacional implements IRepositorioRestaurante {
    private  List<Restaurante> restaurants = new ArrayList<>(); //implementacao sem BD

    @Override
    public void salvarRestaurante(Restaurante restaurant) {

    }

    @Override
    public void deletarRestaurante(CNPJ cnpj) {

    }

    @Override
    public void modificarRestaurante(Restaurante restaurant) {

    }


    @Override
    public List<Restaurante> buscarRestaurante(CNPJ cnpj) {
        return null;
    }

    @Override
    public List<Restaurante> buscarRestaurantes() {

        return restaurants;
    }
}
