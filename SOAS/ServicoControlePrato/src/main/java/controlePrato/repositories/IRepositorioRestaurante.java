package controlePrato.repositories;

import controlePrato.domain.restaurante.CNPJ;
import controlePrato.domain.restaurante.persistidas.Restaurante;
import java.util.List;

public interface IRepositorioRestaurante {

    public void salvarRestaurante(Restaurante restaurante);

    public void deletarRestaurante(CNPJ cnpj);

    public void modificarRestaurante(Restaurante restaurante);

    public List<Restaurante> buscarRestaurante(CNPJ cnpj);

    public List<Restaurante> buscarRestaurantes();
}
