import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cliente = "Amanda";

        System.out.println("Que tipo de conta você deseja abrir? (Digite o número):");
        System.out.println("1. Poupança");
        System.out.println("2. Corrente");

        String tipoDeConta = scan.nextLine();

        if(tipoDeConta.equalsIgnoreCase("1")) {
            ContaPoupanca conta = new ContaPoupanca(cliente);
            System.out.println("Conta criada com sucesso!");
            conta.verConta();
        } else if(tipoDeConta.equalsIgnoreCase("2")) {
            ContaCorrente conta = new ContaCorrente(cliente);
            System.out.println("Conta criada com sucesso!");
            conta.verConta();
        } else {
            System.out.println("Não foi possível criar sua conta!");
        }
    }
}