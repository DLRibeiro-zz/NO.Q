package services.Subsistemas.SubsistemaEmail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import repositories.AbstractFactoryRepositorio;
import repositories.FactoryProducer;

public class FactorySubsistemaEmail {

  public static ISubsistemaEmail produzirSubsistema() throws IOException {
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

    String subsistema = properties.getProperty("email");
    ISubsistemaEmail subsistemaEmail = null;
    switch (subsistema){
      case "simple" : subsistemaEmail = new SubsistemaEmailSimple();
    }
    return subsistemaEmail;
  }
}
