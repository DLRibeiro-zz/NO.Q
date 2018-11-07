package gui.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import gui.domain.restaurante.persistidas.Prato;
import gui.html.CadastrarPratoHTML;
import gui.html.ListarPratoHTML;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

@Path("listar/prato")
@Produces(MediaType.TEXT_HTML)
public class ListarPratoResource {

  public ListarPratoResource() {

  }

  @GET
  public Response buscarPratos() throws IOException {
    ListarPratoHTML listarPratoHTML  = new ListarPratoHTML();
    String pratosURL = "http://servicefachada:8080/listar/prato/";
    String jsonPratos = Jsoup.connect(pratosURL).method(Connection.Method.GET)
        .ignoreContentType(true).execute().body();
    ObjectMapper mapper = new ObjectMapper();
    List<Prato> pratos =  mapper.readValue(jsonPratos, mapper.getTypeFactory().constructCollectionType(List.class, Prato.class));
    return Response.ok(listarPratoHTML.formatHtml(pratos)).build();
  }

//  @GET
//  @Path("/id/{id}")
//  public Response buscarPrato(@PathParam("id") Integer id) throws IOException {
//    String url = "http://servicefachada:8080/listar/prato/id/" + id;
//    String json = Jsoup.connect(url)
//        .method(Connection.Method.GET)
//        .ignoreContentType(true)
//        .execute()
//        .body();
//    return Response.ok(json).build();
//  }
//
//  @Path("/cnpj/{cnpj}")
//  @GET
//  public Response buscarPratos(@PathParam("cnpj") String cnpj) throws IOException {
//    String url = "http://servicefachada:8080/listar/prato/cnpj/" + cnpj;
//    String json = Jsoup.connect(url)
//        .method(Connection.Method.GET)
//        .ignoreContentType(true)
//        .execute()
//        .body();
//    return Response.ok(json).build();
//  }
}
