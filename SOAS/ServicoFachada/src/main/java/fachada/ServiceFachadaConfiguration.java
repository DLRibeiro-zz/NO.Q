package fachada;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ServiceFachadaConfiguration extends Configuration {
  @NotEmpty
  private String appName;

  @JsonProperty
  public String getAppName(){
    return appName;
  }

  @JsonProperty
  public void setAppName(String appName){
    this.appName = appName;
  }

}
