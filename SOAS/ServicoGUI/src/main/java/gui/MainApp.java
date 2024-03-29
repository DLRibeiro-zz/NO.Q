package gui;

import gui.resources.CadastrarPratoResource;
import gui.resources.CadastrarRestauranteResource;
import gui.resources.HomeResource;
import gui.resources.ListarPratoResource;
import gui.resources.ListarRestauranteResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceGuiConfiguration> {

  public static void main(final String[] args) throws Exception {
    new MainApp().run(args);
  }

  @Override
  public void run(ServiceGuiConfiguration configuration, Environment environment)
      throws Exception {

    environment.jersey().register(new ListarPratoResource());
    environment.jersey().register(new CadastrarRestauranteResource());
    environment.jersey().register(new ListarRestauranteResource());
    environment.jersey().register(new CadastrarPratoResource());
    environment.jersey().register(new HomeResource());
  }
}
