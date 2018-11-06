package cadastroUsuario.resources;

import cadastroUsuario.domain.restaurante.CNPJ;
import cadastroUsuario.domain.restaurante.persistidas.Restaurante;
import cadastroUsuario.repositories.IRepositorioRestaurante;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("listar/restaurante")
@Produces(MediaType.APPLICATION_JSON)
public class ListarRestauranteResource {
  private IRepositorioRestaurante restauranteDB;

  public ListarRestauranteResource(IRepositorioRestaurante restauranteDB){
    this.restauranteDB = restauranteDB;
  }
  @GET
  public Response buscarRestaurantes(){
    List<Restaurante> restaurantes = this.restauranteDB.buscarRestaurantes();
    Response response = Response.ok(restaurantes).build();
    return response;
  }

  @Path("{cnpj}")
  @GET
  public Response buscarRestaurante(@QueryParam("cnpj") String cnpj){
    CNPJ cnpjO = new CNPJ(cnpj);
    List<Restaurante> restaurantes = this.restauranteDB.buscarRestaurante(cnpjO);
    Response response = Response.ok(restaurantes).build();
    return response;
  }
}
