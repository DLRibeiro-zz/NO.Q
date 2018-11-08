package gui.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import gui.domain.restaurante.PratoCollection;
import gui.domain.restaurante.PratoSimples;
import gui.domain.restaurante.persistidas.Prato;
import gui.html.CadastrarPratoHTML;
import gui.html.ListarPratoHTML;
import java.io.IOException;
import java.util.ArrayList;
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
    System.out.println(jsonPratos);
    String[] jsons = jsonPratos.replace("[","").replace("]","").split("\\{");
    int index = -1;
    List<String> resultingJson = new ArrayList<>();
    for(String object: jsons){
      if(index==-1) {
        index++;
        continue;
      }
      if(index%3 ==0){
        resultingJson.add("{\"type\":\"simple\"," + object);
      }else{
        resultingJson.add("{" + object);
      }
      index++;
    }
    jsonPratos = String.join("",resultingJson);
//    jsonPratos = "[" + jsonPratos + "]";
    System.out.println(jsonPratos);
    ObjectMapper mapper = new ObjectMapper();
    Prato pratos = mapper.readValue(jsonPratos, Prato.class);
    System.out.println(pratos);
    List<Prato> pratoList = new ArrayList<>();
    pratoList.add(pratos);
    return Response.ok(listarPratoHTML.formatHtml(pratoList)).build();
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
