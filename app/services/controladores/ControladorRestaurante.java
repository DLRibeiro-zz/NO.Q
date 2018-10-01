package services.controladores;

import domain.restaurante.CNPJ;
import domain.restaurante.Email;
import domain.restaurante.Endereco;
import domain.restaurante.Horario;
import domain.restaurante.persistidas.Restaurante;

import java.util.ArrayList;
import java.util.List;
import services.cadastros.CadastroRestaurante;

public class ControladorRestaurante {
    private List<Restaurante> restaurantes;
    private CadastroRestaurante cadastroRestaurante;

    public ControladorRestaurante(CadastroRestaurante cadastroRestaurante) {
        this.restaurantes = new ArrayList<Restaurante>();
        this.cadastroRestaurante = cadastroRestaurante;
    }

    public boolean cadastrarRestaurante(Restaurante restaurante){
        try {
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    public boolean deletarRestaurante(CNPJ cnpj){
        try {
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    public boolean modificarRestaurante(Restaurante restaurante){
        try {
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    public Restaurante buscarRestaurante(CNPJ cnpj){
        return null;
    }

    public List<Restaurante> buscarRestaurantes(){
       return null;
    }
}
