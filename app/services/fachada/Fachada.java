package services.fachada;

import domain.restaurante.CNPJ;
import domain.restaurante.Email;
import domain.restaurante.Endereco;
import domain.restaurante.Horario;
import java.io.IOException;
import repositories.AbstractFactoryRepositorio;
import repositories.FactoryProducer;
import repositories.IRepositorioRestaurante;
import repositories.RepositorioRestauranteRelacional;
import services.cadastros.CadastroRestaurante;
import services.controladores.ControladorRestaurante;
import domain.restaurante.persistidas.Restaurante;

import java.util.List;

public class Fachada {
    private ControladorRestaurante controladorRestaurante;

    public Fachada(){
        try {
            /*TODO FAZER ISSO PARA TODAS AS ENTIDADES, NESSA ORDEM -> CRIAR REPOSITORIO COM A FABRICA
              TODO CRIAR O CADASTRO, E DEPOIS CRIAR O CONTROLADOR.
            */
            AbstractFactoryRepositorio factoryRepositorio = FactoryProducer.produzirFabrica();//CRIOU FABRICA
            IRepositorioRestaurante repositorioRestaurante = factoryRepositorio.criarRepositorioRestaurante();//CRIOU REPOSITORIO
            CadastroRestaurante cadastroRestaurante = new CadastroRestaurante(repositorioRestaurante);//CRIOU CADASTRO COM O REPOSITORIO
            this.controladorRestaurante = new ControladorRestaurante(cadastroRestaurante);//CRIOU O CONTROLADOR COM O CADASTRO
        } catch (IOException e) {
            e.printStackTrace();
        }
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
