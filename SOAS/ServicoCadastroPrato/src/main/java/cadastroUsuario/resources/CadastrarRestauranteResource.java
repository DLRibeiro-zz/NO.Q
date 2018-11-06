package cadastroUsuario.resources;

import cadastroUsuario.domain.restaurante.persistidas.Restaurante;
import cadastroUsuario.repositories.IRepositorioRestaurante;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cadastrar/restaurante")
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarRestauranteResource {

  private IRepositorioRestaurante restauranteDB;

  public CadastrarRestauranteResource(IRepositorioRestaurante restauranteDB){
    this.restauranteDB = restauranteDB;
  }

  @POST
  public Response cadastrarRestaurante(Restaurante restaurante){
    this.restauranteDB.salvarRestaurante(restaurante);
    return Response.ok().status(201).build();
  }

}
