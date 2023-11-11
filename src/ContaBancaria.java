public class ContaBancaria {
    private String agencia;
    private String cliente;

    //mudar o tipo para Cliente quando a classe tiver pronta

    public ContaBancaria(String cliente) {
        this.cliente = cliente;
        this.agencia = "0404-1";
    }

    public String gerarNumero() {
        String numeroConta = String.format("%.0f", Math.random()*99999);
        String digito = String.format("%.0f", Math.random()*9);
        String numeroDaConta = String.format("%s-%s", numeroConta, digito);
        return numeroDaConta;
    }

    public void verContaBancaria(String tipo, String numeroDaConta){
        System.out.printf("Olá, %s, aqui estão as informações da sua nova conta:\n", this.cliente);
        System.out.printf("Número: %s\n", numeroDaConta);
        System.out.printf("Agência: %s\n", this.agencia);
        System.out.printf("Tipo: %s\n", tipo);
    }
    public void sacar(){}
    public void depositar(){}
    public void verSaldo(){}
    public void transferir(){}
    public void encerrarConta(){}

    public String getAgencia() {
        return agencia;
    }

    public String getCliente() {
        return cliente;
    }

    //mudar o tipo do cliente quando tiver a classe Cliente
}
