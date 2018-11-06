package fachada;

import fachada.resources.CadastrarPratoResource;
import fachada.resources.CadastrarRestauranteResource;
import fachada.resources.ListarPratoResource;
import fachada.resources.ListarRestauranteResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceFachadaConfiguration> {

  public static void main(final String[] args) throws Exception {
    new MainApp().run(args);
  }

  @Override
  public void run(ServiceFachadaConfiguration configuration, Environment environment)
      throws Exception {

    environment.jersey().register(new ListarPratoResource());
    environment.jersey().register(new CadastrarRestauranteResource());
    environment.jersey().register(new ListarRestauranteResource());
    environment.jersey().register(new CadastrarPratoResource());
  }
}
