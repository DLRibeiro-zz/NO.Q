package gui.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import gui.domain.restaurante.PratoSimples;
import gui.domain.restaurante.Preco;
import gui.domain.restaurante.persistidas.Prato;
import gui.html.CadastrarPratoHTML;
import gui.html.ListarPratoHTML;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

@Path("cadastrar/prato")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class CadastrarPratoResource {

  public CadastrarPratoResource(){
  }

  @GET
  public Response pageCadastrarPrato(){
    CadastrarPratoHTML cadastrarPratoHTML = new CadastrarPratoHTML();
    return Response.ok(cadastrarPratoHTML.getHtml()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Response pageCadastrarPrato(@FormParam("inputNome") String nome,
      @FormParam("inputDescricao") String descricao,
      @FormParam("inputTempo") int tempo, @FormParam("inputReais") String reais) throws IOException {
    System.out.println("Usuario = " + nome);
    System.out.println("Data = " + descricao);

    ObjectMapper mapper = new ObjectMapper();
    int precoReais = Integer.valueOf(reais.split(",")[0]);
    int precoCentavos = Integer.valueOf(reais.split(",")[1]);
    Prato prato = new PratoSimples(nome,descricao,tempo,new Preco(precoReais, precoCentavos));
    String pratoJson = mapper.writeValueAsString(prato);
    System.out.println(prato);
    //.data("atividade", atividadeJson)
    int statusCode = Jsoup.connect("http://servicefachada:8080/cadastrar/prato")
        .requestBody(pratoJson)
        .header("Content-Type", "application/json")
        .method(Connection.Method.POST)
        .ignoreContentType(true)
        .execute()
        .statusCode();
    if (statusCode == 201) {
      return Response.ok().build();
    } else {
      return Response.serverError().build();
    }
  }

}
