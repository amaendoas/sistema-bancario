public class PessoaJuridica extends Cliente {
    private String razaoSocial;
    private String cnpj;

    public PessoaJuridica(String email, String telefone, String razaoSocial) {
        super(email, telefone);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
//                                                      01 234 567 891011 1213
       return formatarCNPJ(cnpj);
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public static String formatarCNPJ(String CNPJnumeros) {

        return String.format("%s.%s.%s/%s-%s",
                CNPJnumeros.substring(0, 2),
                CNPJnumeros.substring(2, 5),
                CNPJnumeros.substring(5, 8),
                CNPJnumeros.substring(8, 12),
                CNPJnumeros.substring(12, 14));

    }

    @Override
    public String toString() {
        return "Razão Social - " + getRazaoSocial() + "\n" +
                "CNPJ - " + getCnpj() + "\n" +
                "Email - " + getEmail() + "\n" +
                "Telefone - " + getTelefone() + "\n";
    }
}