package fachada.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import fachada.domain.restaurante.persistidas.Restaurante;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

@Path("cadastrar/restaurante")
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarRestauranteResource {

  public CadastrarRestauranteResource(){
  }

  @POST
  public Response cadastrarPrato(Restaurante restaurante) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String restauranteJson = mapper.writeValueAsString(restaurante);
    System.out.println(restauranteJson);
    int statusCode = Jsoup.connect("http://servicecontrolerestaurante:8080/cadastrar/restaurante")
        .requestBody(restauranteJson)
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
