package services.facade;

import domain.restaurante.CNPJ;
import domain.restaurante.Email;
import domain.restaurante.Endereco;
import domain.restaurante.Horario;
import services.controladores.ControladorRestaurante;
import domain.restaurante.persistidas.Restaurante;

import java.util.List;

public class Fachada {
    private ControladorRestaurante controladorRestaurante;

    public Fachada(){
        controladorRestaurante = new ControladorRestaurante();
    }

    public void CadastrarPrato(){}

    public void confirmarPagamento(){}

    public void enviarPedido(){}

    public void transmitirNotificacao(){}

    public void listarPratos(){}

    public void selecionarPedido(){}

    public void cadastrarRestaurante(CNPJ cnpj, Email email, Endereco endereco, Horario horario, String senha){
        Restaurante restaurante = new Restaurante(cnpj, email, endereco, horario, senha);
        controladorRestaurante.cadastrarRestaurante(restaurante);
    }

    public void deletarRestaurante(CNPJ cnpj){
        controladorRestaurante.deletarRestaurante(cnpj);
    }

    public void modificarRestaurante(CNPJ cnpj, Email email, Endereco endereco, Horario horario, String senha){
        Restaurante restaurante = new Restaurante(cnpj, email, endereco, horario, senha);
        controladorRestaurante.modificarRestaurante(restaurante);
    }

    public Restaurante buscarRestaurante(CNPJ cnpj){
        return controladorRestaurante.buscarRestaurante(cnpj);
    }

    public List<Restaurante> buscarRestaurantes(){
        return controladorRestaurante.buscarRestaurantes();
    }
}
