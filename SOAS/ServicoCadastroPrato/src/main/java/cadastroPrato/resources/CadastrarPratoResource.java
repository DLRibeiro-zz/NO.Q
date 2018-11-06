package cadastroPrato.resources;

import cadastroPrato.domain.restaurante.persistidas.Prato;
import cadastroPrato.repositories.IRepositorioPrato;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cadastrar/prato")
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarPratoResource {

  private IRepositorioPrato pratoDB;

  public CadastrarPratoResource(IRepositorioPrato pratoDB){
    this.pratoDB = pratoDB;
  }

  @POST
  public Response cadastrarPrato(Prato prato){
    this.pratoDB.salvarPrato(prato);
    return Response.ok().status(201).build();
  }

}
