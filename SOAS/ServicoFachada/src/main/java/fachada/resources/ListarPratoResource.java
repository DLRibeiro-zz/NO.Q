package fachada.resources;

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
public class ListarPratoResource {

  public ListarPratoResource(){

  }
  @GET
  public Response buscarPratos() throws IOException {
    String url = "http://servicecontroleprato:8080/listar/prato";
    String json = Jsoup.connect(url)
        .method(Connection.Method.GET)
        .ignoreContentType(true)
        .execute()
        .body();
    return Response.ok(json).build();
  }

  @GET
  @Path("/id/{id}")
  public Response buscarPrato(@PathParam("id") Integer id) throws IOException {
    String url = "http://servicecontroleprato:8080/listar/prato/id/" + id;
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
    String url = "http://servicecontroleprato:8080/listar/prato/cnpj/" + cnpj;
    String json = Jsoup.connect(url)
        .method(Connection.Method.GET)
        .ignoreContentType(true)
        .execute()
        .body();
    return Response.ok(json).build();
  }
}
