package controleUsuario.repositories;

import controleUsuario.domain.restaurante.CNPJ;
import controleUsuario.domain.restaurante.persistidas.Restaurante;
import java.util.List;

public interface IRepositorioRestaurante {

    public void salvarRestaurante(Restaurante restaurante);

    public void deletarRestaurante(CNPJ cnpj);

    public void modificarRestaurante(Restaurante restaurante);

    public List<Restaurante> buscarRestaurante(CNPJ cnpj);

    public List<Restaurante> buscarRestaurantes();
}
