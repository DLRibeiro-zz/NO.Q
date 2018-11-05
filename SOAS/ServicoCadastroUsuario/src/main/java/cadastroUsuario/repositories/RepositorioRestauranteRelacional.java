package repositories;

import domain.restaurante.CNPJ;
import domain.restaurante.Email;
import domain.restaurante.Endereco;
import domain.restaurante.persistidas.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RepositorioRestauranteRelacional implements IRepositorioRestaurante {
    private  List<Restaurante> restaurants = new ArrayList<>(); //implementacao sem BD

    @Override
    public void salvarRestaurante(Restaurante restaurant) {
        restaurants.add(new Restaurante("VilaNova", new CNPJ("1"), new Email("acab2@cin.ufpe.br"), "12345"));
        restaurants.add(new Restaurante("VilaVelha", new CNPJ("2"), new Email("acab2@cin.ufpe.br"), "12345"));

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
