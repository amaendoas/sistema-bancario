public class ContaBancaria {
    private String numeroConta;
    private String agencia;
    private String cliente;
    //mudar o tipo para Cliente quando a classe tiver pronta

    public ContaBancaria() {
    }

    public void abrirConta(){}
    public void sacar(){}
    public void depositar(){}
    public void verSaldo(){}
    public void transferir(){}
    public void encerrarConta(){}


    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    //mudar o tipo do cliente quando tiver a classe Cliente
}
