package services.controladores;

import domain.restaurante.CNPJ;
import domain.restaurante.Email;
import domain.restaurante.Endereco;
import domain.restaurante.Horario;
import domain.restaurante.persistidas.Restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import services.cadastros.CadastroRestaurante;

public class ControladorRestaurante {
    private CadastroRestaurante cadastroRestaurante;

    public ControladorRestaurante(CadastroRestaurante cadastroRestaurante) {
        this.cadastroRestaurante = cadastroRestaurante;
    }

    public boolean cadastrarRestaurante(Restaurante restaurante){
        try {
            this.cadastroRestaurante.salvarRestaurante(restaurante);
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    public boolean deletarRestaurante(CNPJ cnpj){
        try {
            this.cadastroRestaurante.deletetarRestaurante(cnpj);
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    public boolean modificarRestaurante(Restaurante restaurante){
        try {
            this.cadastroRestaurante.modificarRestaurante(restaurante);
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    public List<Restaurante> buscarRestaurante(CNPJ cnpj){
        return this.cadastroRestaurante.buscarRestaurante(cnpj);
    }

    public List<Restaurante> buscarRestaurantes(){
        return this.cadastroRestaurante.buscarRestaurantes();
    }
}
