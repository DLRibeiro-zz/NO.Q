package cadastroUsuario;

import cadastroUsuario.repositories.AbstractFactoryRepositorio;
import cadastroUsuario.repositories.FactoryProducer;
import cadastroUsuario.repositories.IRepositorioRestaurante;
import cadastroUsuario.resources.CadastrarRestauranteResource;
import cadastroUsuario.resources.ListarRestauranteResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceCadastroUsuarioConfiguration> {

  public static void main(final String[] args) throws Exception {
    new MainApp().run(args);
  }

  @Override
  public void run(ServiceCadastroUsuarioConfiguration configuration, Environment environment)
      throws Exception {
    AbstractFactoryRepositorio factoryRepositorio = FactoryProducer.produzirFabrica();
    IRepositorioRestaurante repositorioRestaurante = factoryRepositorio
        .criarRepositorioRestaurante();
    System.out.println("Criou repositorio");
    environment.jersey().register(new CadastrarRestauranteResource(repositorioRestaurante));
    environment.jersey().register(new ListarRestauranteResource(repositorioRestaurante));

  }
}
