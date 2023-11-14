public class PessoaJuridica extends Cliente {
    private String razaoSocial;
    private String cnpj;

    public PessoaJuridica(int id, String email, String telefone, String razaoSocial, String cnpj) {
        super(id, email, telefone);
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
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}