import java.text.DecimalFormat;
public class Cliente {
    private String email;
    private String telefone;

    public Cliente(String email, String telefone) {
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
        DecimalFormat df = new DecimalFormat("(##) #####-###");
        return df.format(Long.parseLong(telefone));

    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
