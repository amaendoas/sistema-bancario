import java.text.DecimalFormat;
public class PessoaFisica extends Cliente {
    private String nome;
    private String cpf;


    public PessoaFisica(String email, String telefone, String nome, String cpf) {
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
//        DecimalFormat df2 = new DecimalFormat("###.###.###-##");
//        return df2.format(Long.parseLong(cpf));
        return formatarCPF(cpf);
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public static String formatarCPF(String cpfNumeros) {

        return String.format("%s.%s.%s-%s",
                cpfNumeros.substring(0, 3),
                cpfNumeros.substring(3, 6),
                cpfNumeros.substring(6, 9),
                cpfNumeros.substring(9));

    }
    @Override
    public String toString() {
        return "Nome - " + getNome() + "\n" +
                "CPF - " + getCpf() + "\n" +
                "Email - " + getEmail() + "\n" +
                "Telefone - " + getTelefone() + "\n";
    }
}