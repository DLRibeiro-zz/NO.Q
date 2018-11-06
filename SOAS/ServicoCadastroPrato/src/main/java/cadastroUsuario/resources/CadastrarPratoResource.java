package cadastroUsuario.resources;

import cadastroUsuario.domain.restaurante.persistidas.Prato;
import cadastroUsuario.domain.restaurante.persistidas.Restaurante;
import cadastroUsuario.repositories.IRepositorioPrato;
import cadastroUsuario.repositories.IRepositorioRestaurante;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cadastrar/restaurante")
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarPratoResource {

  private IRepositorioPrato pratoDB;

  public CadastrarPratoResource(IRepositorioPrato pratoDB){
    this.pratoDB = pratoDB;
  }

  @POST
  public Response cadastrarRestaurante(Prato prato){
    this.pratoDB.salvarPrato(prato);
    return Response.ok().status(201).build();
  }

}
