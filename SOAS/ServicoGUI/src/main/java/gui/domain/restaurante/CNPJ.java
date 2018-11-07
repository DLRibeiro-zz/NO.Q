package gui.domain.restaurante;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Objects;
import org.hibernate.validator.constraints.NotEmpty;

public class CNPJ {
    @NotEmpty
    private String cnpj;

    public CNPJ(){}
    @JsonCreator
    public CNPJ(@JsonProperty("cnpj") String cnpj){
        this.cnpj = cnpj;
    }

    public boolean validar(){
        return true;
    }
    @JsonGetter("cnpj")
    public String getCnpj() {
        return cnpj;
    }
    @JsonSetter("cnpj")
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CNPJ) {
            CNPJ other = (CNPJ) obj;
            return this.cnpj.equals(other.getCnpj());
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.cnpj);
    }
}
