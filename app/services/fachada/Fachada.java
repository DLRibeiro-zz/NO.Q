package services.fachada;

import domain.restaurante.CNPJ;
import domain.restaurante.Email;
import domain.restaurante.Endereco;
import domain.restaurante.Horario;
import domain.restaurante.persistidas.Pedido;
import domain.restaurante.persistidas.Restaurante;
import java.io.IOException;
import java.util.List;
import repositories.AbstractFactoryRepositorio;
import repositories.FactoryProducer;
import repositories.IRepositorioPedido;
import repositories.IRepositorioRestaurante;
import services.Subsistemas.SubsistemaEmail.FactorySubsistemaEmail;
import services.Subsistemas.SubsistemaEmail.ISubsistemaEmail;
import services.cadastros.CadastroPedido;
import services.cadastros.CadastroRestaurante;
import services.controladores.ControladorPedido;
import services.controladores.ControladorRestaurante;
import services.controladores.ControladorServicoEmail;
import services.controladores.ControladorUsuario;

public class Fachada {

    private static Fachada instancia;
    private ControladorRestaurante controladorRestaurante;
    private ControladorPedido controladorPedido;
    private ControladorUsuario controladorUsuario;
    private ControladorServicoEmail controladorServicoEmail;

    public static void main(String []args){
        Fachada.getInstance();
    }

    private Fachada(){
        try {
            /*TODO FAZER ISSO PARA TODAS AS ENTIDADES, NESSA ORDEM -> CRIAR REPOSITORIO COM A FABRICA
              TODO CRIAR O CADASTRO, E DEPOIS CRIAR O CONTROLADOR.
            */
            AbstractFactoryRepositorio factoryRepositorio = FactoryProducer.produzirFabrica();//CRIOU FABRICA
            IRepositorioRestaurante repositorioRestaurante = factoryRepositorio.criarRepositorioRestaurante();//CRIOU REPOSITORIO
            CadastroRestaurante cadastroRestaurante = new CadastroRestaurante(repositorioRestaurante);//CRIOU CADASTRO COM O REPOSITORIO
            this.controladorRestaurante = new ControladorRestaurante(cadastroRestaurante);//CRIOU O CONTROLADOR COM O CADASTRO

            IRepositorioPedido repositorioPedido = factoryRepositorio.criarRepositorioPedido();
            CadastroPedido cadastroPedido = new CadastroPedido(repositorioPedido);
            this.controladorPedido = new ControladorPedido(cadastroPedido);

            this.controladorUsuario = new ControladorUsuario();

            ISubsistemaEmail subsistemaEmail = FactorySubsistemaEmail.produzirSubsistema();

            this.controladorServicoEmail = new ControladorServicoEmail(subsistemaEmail);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Fachada getInstance(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }

    public void CadastrarPrato(){}

    public void confirmarPagamento(){}

    public void enviarPedido(){}

    public void transmitirNotificacao(int idPedido){
        Pedido pedido = this.controladorPedido.buscarPedido(idPedido);
        this.controladorUsuario.receberNotificacao(pedido);
    }

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
