package cadastroUsuario.domain.restaurante;

public class CNPJ {
    private String cnpj;

    public CNPJ(String cnpj){
        this.cnpj = cnpj;
    }

    public boolean validar(){
        return true;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
