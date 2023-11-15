public class ContaBancaria {
    private String agencia;
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;

    private double saldo;

    public ContaBancaria(Cliente cliente) {
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
        if(pessoaJuridica != null) {
            System.out.printf("Olá, %s, aqui estão as informações da sua conta:\n", pessoaJuridica.getRazaoSocial());
        }

        if(pessoaFisica != null) {
            System.out.printf("Olá, %s, aqui estão as informações da sua conta:\n", pessoaFisica.getNome());
        }
        System.out.printf("Tipo - %s\n", tipo);
        System.out.printf("Número - %s\n", numeroDaConta);
        System.out.printf("Agência - %s\n", this.agencia);
        System.out.printf("Saldo - R$%.2f\n", this.saldo);
    }

    public void abrirContaPF(String nome, String cpf, String email, String telefone) {
        pessoaFisica = new PessoaFisica(1,email, telefone, nome, cpf);
    }

    public void abrirContaPJ(String razaoSocial, String cnpj, String email, String telefone) {
        pessoaJuridica = new PessoaJuridica(1,email, telefone, razaoSocial, cnpj);
    }

    public void sacar(){}
    public void depositar(){}
    public void verSaldo(){}
    public void transferir(){}
    public void encerrarConta(){}

    public String getAgencia() {
        return agencia;
    }

    public String getClientePF() {
        return pessoaFisica.toString();
    }

    public String getClientePJ() {
        return pessoaJuridica.toString();
    }

    public double getSaldo() {
        return saldo;
    }

    //mudar o tipo do cliente quando tiver a classe Cliente
}
