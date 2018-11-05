package repositories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FactoryProducer {

  public static AbstractFactoryRepositorio produzirFabrica() throws IOException {
    String propFileName = "application.properties";
    Properties properties = new Properties();
    InputStream inputStream;
    inputStream = FactoryProducer.class.getClassLoader().getResourceAsStream(propFileName);
    AbstractFactoryRepositorio factoryRepositorio;
    if (inputStream != null) {
      properties.load(inputStream);
    } else {
      throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
    }

    String dbType = properties.getProperty("db");

    //TODO QUANDO IMPLEMENTANDO OUTROS, ALTERAR AQUI TBM
    switch(dbType){
      case "relacional" :
        factoryRepositorio =  new FactoryRepositorioRelacional();
      default: factoryRepositorio = new FactoryRepositorioRelacional();
    }
    return factoryRepositorio;
  }
}
