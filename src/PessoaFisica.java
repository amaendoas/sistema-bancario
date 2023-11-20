import java.text.DecimalFormat;
public class PessoaFisica extends Cliente {
    private String nome;
    private String cpf;


    public PessoaFisica(int id, String email, String telefone, String nome, String cpf) {
        super(email, telefone);
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
        DecimalFormat df2 = new DecimalFormat("###.###.###-##");
        return df2.format(Long.parseLong(cpf));
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