package cadastroPrato.resources;

import cadastroPrato.domain.restaurante.CNPJ;
import cadastroPrato.domain.restaurante.persistidas.Prato;
import cadastroPrato.repositories.IRepositorioPrato;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("listar/restaurante")
@Produces(MediaType.APPLICATION_JSON)
public class ListarPratoResource {
  private IRepositorioPrato pratoDB;

  public ListarPratoResource(IRepositorioPrato pratoDB){
    this.pratoDB = pratoDB;
  }
  @GET
  public Response buscarPratos(){
    List<Prato> pratos = this.pratoDB.buscarPratos();
    Response response = Response.ok(pratos).build();
    return response;
  }

  @GET
  @Path("/{id}")
  public Response buscarPrato(@PathParam("id") Integer id){
    Prato prato = this.pratoDB.buscarPrato(id.intValue());
    return Response.ok(prato).build();
  }

  @Path("/{cnpj}")
  @GET
  public Response buscarPratos(@QueryParam("cnpj") String cnpj){
    CNPJ cnpjO = new CNPJ(cnpj);
    List<Prato> pratos = this.pratoDB.buscarPratos(cnpjO);
    Response response = Response.ok(pratos).build();
    return response;
  }
}
