public class ContaCorrente extends ContaBancaria {
    private String numeroDeConta;
    private String tipo;
    public ContaCorrente(String cliente) {
        super(cliente);
        this.numeroDeConta = gerarNumero();
        this.tipo = getTipo();
    }

    public void verConta() {
        verContaBancaria(this.tipo, this.numeroDeConta);
    }

    public String getTipo() {
        return "Conta Corrente";
    }
}
