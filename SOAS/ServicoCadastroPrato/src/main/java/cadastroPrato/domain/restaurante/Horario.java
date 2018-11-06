package cadastroPrato.domain.restaurante;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.NotEmpty;

public class Horario {
    @NotEmpty
    private int[] horasComeco;
    @NotEmpty
    private int[] horasFinal;

    public Horario(){

    }
    @JsonCreator
    public Horario(@JsonProperty("horasComeco") int[] horasComeco,
        @JsonProperty("horasFinal") int[] horasFinal) {
        this.horasComeco = horasComeco;
        this.horasFinal = horasFinal;
    }
    @JsonGetter("horasComeco")
    public int[] getHorasComeco() {
        return horasComeco;
    }
    @JsonSetter("horasComeco")
    public void setHorasComeco(int[] horasComeco) {
        this.horasComeco = horasComeco;
    }
    @JsonGetter("horasFinal")
    public int[] getHorasFinal() {
        return horasFinal;
    }
    @JsonSetter("horasFinal")
    public void setHorasFinal(int[] horasFinal) {
        this.horasFinal = horasFinal;
    }
}
