package cadastroUsuario;

import cadastroUsuario.repositories.AbstractFactoryRepositorio;
import cadastroUsuario.repositories.FactoryProducer;
import cadastroUsuario.repositories.IRepositorioPrato;
import cadastroUsuario.repositories.IRepositorioRestaurante;
import cadastroUsuario.resources.CadastrarPratoResource;
import cadastroUsuario.resources.ListarPratoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceCadastroPratoConfiguration> {

  public static void main(final String[] args) throws Exception {
    new MainApp().run(args);
  }

  @Override
  public void run(ServiceCadastroPratoConfiguration configuration, Environment environment)
      throws Exception {
    AbstractFactoryRepositorio factoryRepositorio = FactoryProducer.produzirFabrica();
    IRepositorioPrato repositorioPrato = factoryRepositorio
        .criarRepositorioPrato();
    System.out.println("Criou repositorio");
    environment.jersey().register(new CadastrarPratoResource(repositorioPrato));
    environment.jersey().register(new ListarPratoResource(repositorioPrato));

  }
}
