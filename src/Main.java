
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<ContaBancaria> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<ContaBancaria>();
        operacoes();

    }

    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listarContas();
                break;

            case 6:
                System.out.println("Flw é nóis!");
                System.exit(0); // para o sistema

            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("Você deseja abrir uma conta para Pessoa Física (1) ou Pessoa Jurídica (2)?");
        int tipoCliente = input.nextInt();

        System.out.println("Deseja abrir uma conta Corrente (1) ou Poupança (2)?");
        int tipoConta = input.nextInt();

        if (tipoCliente == 1) {
            criarContaPessoaFisica(tipoConta);
        } else if (tipoCliente == 2) {
            criarContaPessoaJuridica(tipoConta);
        } else {
            System.out.println("Opção inválida!");
            operacoes();
        }
    }

    public static void criarContaPessoaFisica(int tipoConta) {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("Email: ");
        String email = input.next();

        Cliente cliente = new PessoaFisica(nome, cpf, email);

        if (tipoConta == 1) {
            ContaCorrente conta = new ContaCorrente(cliente);
            contasBancarias.add(conta);
            System.out.println("--- Sua conta corrente foi criada com sucesso! ---");
        } else if (tipoConta == 2) {
            ContaPoupanca conta = new ContaPoupanca(cliente);
            contasBancarias.add(conta);
            System.out.println("--- Sua conta poupança foi criada com sucesso! ---");
        } else {
            System.out.println("Opção inválida!");
        }

        operacoes();
    }

    public static void criarContaPessoaJuridica(int tipoConta) {
        System.out.println("\nNome da empresa: ");
        String nomeEmpresa = input.next();

        System.out.println("\nCNPJ: ");
        String cnpj = input.next();

        System.out.println("Email da empresa: ");
        String emailEmpresa = input.next();

        Cliente cliente = new PessoaJuridica(nomeEmpresa, cnpj, emailEmpresa);

        if (tipoConta == 1) {
            ContaCorrente conta = new ContaCorrente(cliente);
            contasBancarias.add(conta);
            System.out.println("--- Sua conta corrente foi criada com sucesso! ---");
        } else if (tipoConta == 2) {
            ContaPoupanca conta = new ContaPoupanca(cliente);
            contasBancarias.add(conta);
            System.out.println("--- Sua conta poupança foi criada com sucesso! ---");
        } else {
            System.out.println("Opção inválida!");
        }

        operacoes();
    }

    public static void depositar() {
        // Implementação do método depositar
    }

    public static void sacar() {
        // Implementação do método sacar
    }

    public static void transferir() {
        // Implementação do método transferir
    }

    public static void listarContas() {
        // Implementação do método listarContas
    }
}