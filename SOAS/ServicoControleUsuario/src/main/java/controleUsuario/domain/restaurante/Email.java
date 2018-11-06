package controleUsuario.domain.restaurante;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.NotEmpty;

public class Email {
    @NotEmpty
    private String email;

    public Email(){}

    @JsonCreator
    public Email(@JsonProperty("email") String email){
        this.email = email;
    }

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }
    @JsonSetter("email")
    public void setEmail(String email) {
        this.email = email;
    }
}
