public class ContaCorrente extends ContaBancaria {
    private String numeroDeConta;
    private String tipo;
    public ContaCorrente() {
        super();
        this.numeroDeConta = getNumeroDeConta();
        this.tipo = getTipo();
    }

    public void verConta() {
        verContaBancaria(this.tipo, this.numeroDeConta);
    }

    public String getTipo() {
        return "Conta Corrente";
    }

    public String getNumeroDeConta() {
        return gerarNumero();
    }
}
