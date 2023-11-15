public class ContaBancaria {
    private String agencia;
    private Cliente cliente;
    private double saldo;

    public ContaBancaria(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = "0404-1";
        this.saldo = 0;
    }

    public String gerarNumero() {
        String numeroConta = String.format("%.0f", Math.random()*99999);
        String digito = String.format("%.0f", Math.random()*9);
        String numeroDaConta = String.format("%s-%s", numeroConta, digito);
        return numeroDaConta;
    }

    public void verContaBancaria(String tipo, String numeroDaConta){
        System.out.printf("Olá, %s, aqui estão as informações da sua conta:\n", this.cliente);
        System.out.printf("Tipo: %s\n", tipo);
        System.out.printf("Número: %s\n", numeroDaConta);
        System.out.printf("Agência: %s\n", this.agencia);
        System.out.printf("Saldo: R$%.2f\n", this.saldo);
    }
    public void sacar(){}
    public void depositar(){}
    public void verSaldo(){}
    public void transferir(){}
    public void encerrarConta(){}

    public String getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    //mudar o tipo do cliente quando tiver a classe Cliente
}
