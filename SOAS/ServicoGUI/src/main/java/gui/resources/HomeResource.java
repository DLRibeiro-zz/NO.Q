package gui.resources;

import gui.html.HomeHTML;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
@Path("home")
public class HomeResource {

  @GET
  public Response pageHome() {
    HomeHTML homeHTML = new HomeHTML();
    return Response.ok(homeHTML.getHtml()).build();
  }

}
