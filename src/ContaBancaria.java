public class ContaBancaria {
    private String agencia;
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;
    private double saldo;

    public ContaBancaria() {
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
        System.out.println("--------------------------------------------------");
        if(pessoaJuridica != null) {
            System.out.printf("Olá, %s, aqui estão as informações da sua conta:\n", pessoaJuridica.getRazaoSocial());
        }

        if(pessoaFisica != null) {
            System.out.printf("Olá, %s, aqui estão as informações da sua conta:\n", pessoaFisica.getNome());
        }
        System.out.printf("Tipo - %s\n", tipo);
        System.out.printf("Número - %s\n", numeroDaConta);
        System.out.printf("Agência - %s\n", getAgencia());
        System.out.printf("Saldo - R$%.2f\n", getSaldo());
    }

    public void abrirContaPF(String nome, String cpf, String email, String telefone) {
        pessoaFisica = new PessoaFisica(email, telefone, nome, cpf);
    }

    public void abrirContaPJ(String razaoSocial, String cnpj, String email, String telefone) {
        pessoaJuridica = new PessoaJuridica(email, telefone, razaoSocial, cnpj);
    }

    public void verDadosCliente() {
        if(pessoaJuridica != null) {
            System.out.println(pessoaJuridica.toString());
        } else if(pessoaFisica != null) {
            System.out.println(pessoaFisica.toString());
        } else {
            System.out.println("Erro! Dados não encontrados");
        }
    }

    public void sacar(double valor){
        if(this.saldo < valor) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= valor;
            System.out.printf("\nSucesso! Seu saldo: R$%.2f\n", getSaldo());
        }
    }
    public void depositar(double valor){
        this.saldo += valor;
        System.out.printf("\nSucesso! Seu saldo: R$%.2f\n", getSaldo());
    }
    public void transferir(String conta, double valor){
        if(this.saldo < valor) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= valor;
            System.out.printf("\nSucesso! Seu saldo: R$%.2f\n", getSaldo());
        }
    }
    public void verSaldo(){
        System.out.printf("\nSeu saldo: R$%.2f\n", getSaldo());
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

}
