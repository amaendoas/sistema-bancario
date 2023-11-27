public class Pessoa {
    private String email;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
       return formatarTelefone(telefone);

    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public static String formatarTelefone(String telefone) {
        return String.format("(%s) %s-%s",
                telefone.substring(0, 2),
                telefone.substring(2, 7),
                telefone.substring(7, 11));
    }
}
