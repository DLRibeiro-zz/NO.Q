package controllers;
import domain.restaurante.CNPJ;
import domain.restaurante.persistidas.Restaurante;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import services.fachada.Fachada;
import views.html.restaurant.*;

import javax.inject.Inject;
import java.util.Set;

public class ControladorTelaCadastroRestaurante extends Controller {

    @Inject
    FormFactory formFactory;

    public Result index(){

        return TODO;
    }

    public Result create(){
        Form<Restaurante> restaurantForm = formFactory.form(Restaurante.class);

        return ok(create.render(restaurantForm));
    }

    public Result save(){
        Form<Restaurante> restaurantForm = formFactory.form(Restaurante.class).bindFromRequest();
        Restaurante restaurante = restaurantForm.get();
        Fachada.cadastrarRestaurante(restaurante);
        return redirect(routes.ControladorTelaCadastroRestaurante.showAll());
    }

    public Result edit(){
        Form<Restaurante> restaurantForm = formFactory.form(Restaurante.class).bindFromRequest();
        Restaurante restaurante = restaurantForm.get();
        Restaurante auxRestaurante = Fachada.buscarRestaurante(restaurante.getCnpj());
        if(restaurante == null){
            return notFound("Restaurante não encontrado");
        }
        return ok(modify.render(restaurantForm));//redirect(routes.ControladorTelaCadastroRestaurante.showAll());
    }

    public Result update(){
        Form<Restaurante> restaurantForm = formFactory.form(Restaurante.class).bindFromRequest();
        Restaurante restaurante = restaurantForm.get();

        //ERRO ESTA AQUI NESSA FUNÇÃO
        Fachada.modificarRestaurante(restaurante);
        return redirect(routes.ControladorTelaCadastroRestaurante.showAll());
    }

    public Result destroy(){
        Form<Restaurante> restaurantForm = formFactory.form(Restaurante.class).bindFromRequest();
        Restaurante restaurante = restaurantForm.get();

        //ERRO ESTA AQUI NESSA FUNÇÃO
        Fachada.deletarRestaurante(restaurante.getCnpj());
        return redirect(routes.ControladorTelaCadastroRestaurante.showAll());
    }
    public Result delete(){
        Form<Restaurante> restaurantForm = formFactory.form(Restaurante.class);
        return ok(delete.render(restaurantForm));
    }

    public Result find(){

        Form<Restaurante> restaurantForm = formFactory.form(Restaurante.class);
        return ok(search.render(restaurantForm));
    }

    public Result show(){
        Form<Restaurante> restaurantForm = formFactory.form(Restaurante.class).bindFromRequest();
        Restaurante restaurante = restaurantForm.get();


        return TODO;//  ok(modify.render(Fachada.buscarRestaurante(restaurante.getCnpj())));
    }

    public Result showAll() {
        return ok(restaurant.render(Fachada.buscarRestaurantes()));
    }
}
