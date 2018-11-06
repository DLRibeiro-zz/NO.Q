package controlePrato;

import controlePrato.repositories.AbstractFactoryRepositorio;
import controlePrato.repositories.FactoryProducer;
import controlePrato.repositories.IRepositorioPrato;
import controlePrato.resources.CadastrarPratoResource;
import controlePrato.resources.ListarPratoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<ServiceCadastroPratoConfiguration> {

  public static void main(final String[] args) throws Exception {
    new MainApp().run(args);
  }

  @Override
  public void run(ServiceCadastroPratoConfiguration configuration, Environment environment)
      throws Exception {
    environment.jersey().register(new CadastrarPratoResource(repositorioPrato));
    environment.jersey().register(new ListarPratoResource(repositorioPrato));

  }
}
