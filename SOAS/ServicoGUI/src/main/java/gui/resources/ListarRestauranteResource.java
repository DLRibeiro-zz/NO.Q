package gui.resources;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

@Path("listar/restaurante")
@Produces(MediaType.APPLICATION_JSON)
public class ListarRestauranteResource {

  public ListarRestauranteResource(){

  }
  @GET
  public Response buscarRestaurantes() throws IOException {
    String url = "http://servicefachada:8080/listar/restaurante";
    String json = Jsoup.connect(url)
        .method(Connection.Method.GET)
        .ignoreContentType(true)
        .execute()
        .body();
    return Response.ok(json).build();
  }

  @Path("/cnpj/{cnpj}")
  @GET
  public Response buscarPratos(@PathParam("cnpj") String cnpj) throws IOException {
    String url = "http://servicefachada:8080/listar/restaurante/cnpj/" + cnpj;
    String json = Jsoup.connect(url)
        .method(Connection.Method.GET)
        .ignoreContentType(true)
        .execute()
        .body();
    return Response.ok(json).build();
  }
}
