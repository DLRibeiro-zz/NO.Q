package services.controladores;
import play.mvc.*;
import views.html.TelaCadastroRestaurante;

public class ControladorTelaCadastroRestaurante extends Controller {

    public Result telaCadastroRestaurante(String name) {
        return ok(TelaCadastroRestaurante.render(name));
    }

}
