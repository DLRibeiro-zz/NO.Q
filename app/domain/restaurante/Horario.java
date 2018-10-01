package domain.restaurante;

public class Horario {
    private int[] horasComeco, horasFinal;

    public Horario(int[] horasComeco, int[] horasFinal) {
        this.horasComeco = horasComeco;
        this.horasFinal = horasFinal;
    }

    public int[] getHorasComeco() {
        return horasComeco;
    }

    public void setHorasComeco(int[] horasComeco) {
        this.horasComeco = horasComeco;
    }

    public int[] getHorasFinal() {
        return horasFinal;
    }

    public void setHorasFinal(int[] horasFinal) {
        this.horasFinal = horasFinal;
    }
}
