public class ContaPoupanca extends ContaBancaria {
    private String numeroDeConta;
    private String tipo;

    public ContaPoupanca() {
        super();
        this.numeroDeConta = getNumeroDeConta();
        this.tipo = getTipo();
    }

    private String gerarNumeroConta() {
        return String.format("%s/500", gerarNumero());
    }

    public void verConta() {
        verContaBancaria(this.tipo, this.numeroDeConta);
    }

    public String getTipo() {
        return "Conta Poupança";
    }

    public String getNumeroDeConta() {
        return gerarNumeroConta();
    }
}

