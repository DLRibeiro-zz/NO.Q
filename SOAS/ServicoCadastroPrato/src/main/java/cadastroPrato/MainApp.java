package cadastroPrato;

import cadastroPrato.repositories.AbstractFactoryRepositorio;
import cadastroPrato.repositories.FactoryProducer;
import cadastroPrato.repositories.IRepositorioPrato;
import cadastroPrato.resources.CadastrarPratoResource;
import cadastroPrato.resources.ListarPratoResource;
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
