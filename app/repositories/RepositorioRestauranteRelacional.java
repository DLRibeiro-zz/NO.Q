package repositories;

import domain.restaurante.CNPJ;
import domain.restaurante.persistidas.Restaurante;

import java.util.List;

public class RepositorioRestauranteRelacional implements IRepositorioRestaurante {

    @Override
    public void salvarRestaurante(Restaurante restaurante) {

    }

    @Override
    public void deletarRestaurante(CNPJ cnpj) {

    }

    @Override
    public void modificarRestaurante(Restaurante restaurante) {

    }

    @Override
    public Restaurante buscarRestaurante(CNPJ cnpj) {
        return null;
    }

    @Override
    public List<Restaurante> buscarRestaurantes() {
        return null;
    }
}
