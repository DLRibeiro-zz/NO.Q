package controlePrato.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import controlePrato.domain.restaurante.persistidas.Prato;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

@Path("cadastrar/prato")
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarPratoResource {

  public CadastrarPratoResource(){
  }

  @POST
  public Response cadastrarPrato(Prato prato) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String pratoJson = mapper.writeValueAsString(prato);
    System.out.println(pratoJson);
    int statusCode = Jsoup.connect("http://servicecadastroprato:8080/cadastrar/prato")
        .requestBody(pratoJson)
        .header("Content-Type", "application/json")
        .method(Connection.Method.POST)
        .ignoreContentType(true)
        .execute()
        .statusCode();
    if (statusCode == 201) {
      return Response.ok().status(201).build();
    } else {
      return Response.serverError().build();
    }
  }

}
