package controlePrato;

import controlePrato.resources.CadastrarPratoResource;
import controlePrato.resources.ListarPratoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceControlePratoConfiguration> {

  public static void main(final String[] args) throws Exception {
    new MainApp().run(args);
  }

  @Override
  public void run(ServiceControlePratoConfiguration configuration, Environment environment)
      throws Exception {
    environment.jersey().register(new CadastrarPratoResource());
    environment.jersey().register(new ListarPratoResource());

  }
}
