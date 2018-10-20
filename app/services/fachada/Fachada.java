package services.fachada;

import controllers.ControladorTelaCadastroRestaurante;
import domain.restaurante.CNPJ;
import domain.restaurante.Email;
import domain.restaurante.persistidas.Pedido;
import domain.restaurante.persistidas.Restaurante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import play.data.Form;
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

public class Fachada{

    private static Fachada instancia;
    private static ControladorRestaurante controladorRestaurante;
    private ControladorPedido controladorPedido;
    private ControladorUsuario controladorUsuario;
    private ControladorServicoEmail controladorServicoEmail;
    private ControladorTelaCadastroRestaurante controladorTelaCadastroRestaurante;
    public static void main(String []args){
        Fachada.getInstance();
    }


    private static List<Restaurante> restaurants = new ArrayList<>(); //implementacao sem BD
    private static List<Restaurante> auxRestaurant = new ArrayList<>(); //implementacao sem BD

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

    public static void cadastrarRestaurante(Restaurante restaurante){
        restaurants.add(restaurante); //implementacao sem BD
       // controladorRestaurante.cadastrarRestaurante(restaurante);
    }

    public static void deletarRestaurante(CNPJ cnpj){
        //implementacao sem BD
        for(int i = 0; i < restaurants.size(); i++){
            if(restaurants.get(i).getCnpj().getCnpj().equals(cnpj.getCnpj())){
                restaurants.remove(i);
            }
        }
        //controladorRestaurante.deletarRestaurante(cnpj);
    }

    public static void modificarRestaurante(Restaurante novoRestaurante){
        //implementacao sem BD
        for(int i = 0; i < restaurants.size(); i++){
            if(restaurants.get(i).getCnpj().getCnpj().equals(novoRestaurante.getCnpj().getCnpj())){
                restaurants.set(i, novoRestaurante);
            }
        }

       // controladorRestaurante.modificarRestaurante(restaurante);
    }

    public static Restaurante buscarRestaurante(CNPJ cnpj){

        Restaurante auxRestaurante = null;
        //implementacao sem BD

        for(Restaurante restaurant : restaurants){
            if(cnpj.getCnpj().equals(restaurant.getCnpj().getCnpj())){
                auxRestaurante = restaurant;
            }
        }
        return auxRestaurante;
        //return controladorRestaurante.buscarRestaurante(cnpj);
    }

    public static List<Restaurante> buscarRestaurantes(){
        //implementacao sem BD
       if(restaurants.size() == 0) {
           restaurants.add(new Restaurante("VilaNova", new CNPJ("1"), new Email("acab2@cin.ufpe.br"), "12345"));
           restaurants.add(new Restaurante("VilaVelha", new CNPJ("2"), new Email("acab2@cin.ufpe.br"), "12345"));
       }
        return restaurants;
        //return controladorRestaurante.buscarRestaurantes();
    }
}
