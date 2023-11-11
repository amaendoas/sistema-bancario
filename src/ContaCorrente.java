public class ContaCorrente extends ContaBancaria {
    private String numeroDeConta;
    private String tipo;
    public ContaCorrente(String cliente) {
        super(cliente);
        this.numeroDeConta = gerarNumeroConta();
        this.tipo = getTipo();
    }

    private String gerarNumeroConta() {
        return String.format("%s/500", gerarNumero());
    }

    public void verConta() {
        verContaBancaria(this.tipo, this.numeroDeConta);
    }

    public String getTipo() {
        return "Conta Corrente";
    }
}
