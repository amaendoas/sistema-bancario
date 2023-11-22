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
        System.out.println("|   Opção 5 - Ver Saldo     |");
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
                verSaldo();
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

    public static ContaBancaria encontrarConta(int numeroConta) {
        for (ContaBancaria conta : contasBancarias) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null; // Retorna null se a conta não for encontrada
    }


    public static void criarConta() {
        System.out.println("Bem-vindo! Para criar sua conta, precisamos de algumas informações.");

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
            System.out.println("--- Sua conta corrente foi criada com sucesso! ---");
        } else if (tipoConta == 2) {
            ContaPoupanca conta = new ContaPoupanca(cliente);
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
            System.out.println("--- Sua conta corrente foi criada com sucesso! ---");
        } else if (tipoConta == 2) {
            ContaPoupanca conta = new ContaPoupanca(cliente);
            System.out.println("--- Sua conta poupança foi criada com sucesso! ---");
        } else {
            System.out.println("Opção inválida!");
        }

        operacoes();
    }

    public static void depositar() {
        System.out.println("Digite o número da conta: ");
        int numeroConta = input.nextInt();
        ContaBancaria conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Digite o valor a ser depositado: ");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("--- Depósito realizado com sucesso! ---");
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();
    }

    public static void sacar() {
        System.out.println("Digite o número da conta: ");
        int numeroConta = input.nextInt();
        ContaBancaria conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Digite o valor a ser sacado: ");
            double valorSaque = input.nextDouble();

            if (conta.sacar(valorSaque)) {
                System.out.println("--- Saque realizado com sucesso! ---");
            } else {
                System.out.println("--- Saldo insuficiente ---");
            }
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();
    }

    public static void transferir() {
        System.out.println("Digite o número da conta remetente: ");
        String numeroContaRemetente = input.next();
        ContaBancaria contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Digite o número da conta destinatária: ");
            String numeroContaDestinatario = input.next();
            ContaBancaria contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Digite o valor a ser transferido: ");
                double valorTransferencia = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valorTransferencia);
            } else {
                System.out.println("--- Conta destinatária não encontrada ---");
            }
        } else {
            System.out.println("--- Conta remetente não encontrada ---");
        }

        operacoes();
    }

    public static void verSaldo() {
        System.out.println("Digite o número da conta: ");
        String numeroConta = input.next();
        ContaBancaria conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Saldo da conta " + conta.getNumeroConta() + ": R$ " + conta.getSaldo());
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();
    }

}