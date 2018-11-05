package cadastroUsuario;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceCadastroUsuarioConfiguration> {

  public static void main(String[]args) throws Exception {
      new MainApp().run(args);
  }

  @Override
  public void run(ServiceCadastroUsuarioConfiguration configuration, Environment environment)
      throws Exception {

  }
}
