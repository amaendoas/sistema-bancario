import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ContaCorrente contaCorrente = new ContaCorrente();
    static ContaPoupanca contaPoupanca = new ContaPoupanca();

    public static void main(String[] args) {
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
//
//            case 2:
//                depositar();
//                break;
//
//            case 3:
//                sacar();
//                break;
//
//            case 4:
//                transferir();
//                break;
//
//            case 5:
//                verSaldo();
//                break;

            case 6:
                System.out.println("Flw é nóis!");
                System.exit(0); // para o sistema

            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void voltar (){
        System.out.println("***** O que deseja fazer agora? *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Voltar ao menu  |");
        System.out.println("|   Opção 2 - Sair          |");

        int resposta = input.nextInt();

        if(resposta == 1) {
            operacoes();
        } else if(resposta == 2) {
            System.out.println("Flw é nóis!");
            System.exit(0); // para o sistema
        } else {
            System.out.println("Opção inválida!");
            voltar();
        }

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

        System.out.println("\nEmail: ");
        String email = input.next();

        System.out.println("\nTelefone: ");
        String telefone = input.next();

        if (tipoConta == 1) {
            contaCorrente.abrirContaPF(nome, cpf, email, telefone);
            System.out.println("--- Sua conta corrente foi criada com sucesso! ---");
            contaCorrente.verConta();
        } else if (tipoConta == 2) {
            contaPoupanca.abrirContaPF(nome, cpf, email, telefone);
            System.out.println("--- Sua conta poupança foi criada com sucesso! ---");
            contaPoupanca.verConta();
        } else {
            System.out.println("Opção inválida!");
        }

        voltar();
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


        if (contaRemetente != null) {
            System.out.println("Digite o número da conta destinatária: ");
            String numeroContaDestinatario = input.next();

            if (contaDestinatario != null) {
                System.out.println("Digite o valor a ser transferido: ");
                double valorTransferencia = input.nextDouble();

                contaRemetente.transferir(String.valueOf(contaDestinatario), valorTransferencia);
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

        if (conta != null) {
            System.out.println("Saldo da conta " + conta.getNumeroConta() + ": R$ " + conta.getSaldo());
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();
    }

}