public class PessoaFisica extends Cliente {
    private String nome;
    private String cpf;


    public PessoaFisica(int id, String email, String telefone, String nome, String cpf) {
        super(id, email, telefone);
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome - " + getNome() + "\n" +
                "CPF - " + getCpf() + "\n" +
                "Email - " + getEmail() + "\n" +
                "Telefone - " + getTelefone() + "\n";
    }
}