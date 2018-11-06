package controleUsuario;

import controleUsuario.resources.CadastrarRestauranteResource;
import controleUsuario.resources.ListarRestauranteResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceControleUsuarioConfiguration> {

  public static void main(final String[] args) throws Exception {
    new MainApp().run(args);
  }

  @Override
  public void run(ServiceControleUsuarioConfiguration configuration, Environment environment)
      throws Exception {
    environment.jersey().register(new CadastrarRestauranteResource());
    environment.jersey().register(new ListarRestauranteResource());

  }
}
