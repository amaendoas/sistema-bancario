import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ContaCorrente contaCorrente;
    static ContaPoupanca contaPoupanca;

    public static void main(String[] args) {
        bemvindo();
    }

    public static void sair() {
        System.out.println("Flw é nóis!");
        System.exit(0);
    }

    public static void bemvindo() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("Deseja criar uma conta? (sim ou nao): ");
        System.out.print("> ");

        String resposta = input.nextLine();

        if(resposta.equalsIgnoreCase("sim")){
            criarConta();
        } else if(resposta.equalsIgnoreCase("nao")) {
            sair();
        } else {
            System.out.println("Digite uma opção válida (sim ou nao)");
            bemvindo();
        }

    }

    public static void operacoes() {
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------Bem vindo a área do cliente---------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("|                     1 - Depositar                   |");
        System.out.println("|                     2 - Sacar                       |");
        System.out.println("|                     3 - Transferir                  |");
        System.out.println("|                     4 - Ver Saldo                   |");
        System.out.println("|                     5 - Sair                        |");
        System.out.println("-------------------------------------------------------");
        System.out.println("Digite o número da uma operação que deseja realizar: ");
        System.out.print("> ");

        String operacao = input.nextLine();

        switch (operacao) {
            case "1":
                depositar();
                break;

            case "2":
                sacar();
                break;

            case "3":
                transferir();
                break;

            case "4":
                verSaldo();
                break;

            case "5":
                sair();
                break;

            default:
                System.out.println("Opção inválida!");
                System.out.println("--------------------------------------------------");
                operacoes();
                break;
        }
    }

    public static void voltar (){
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("|                   1 - Voltar ao menu               |");
        System.out.println("|                   2 - Sair                         |");
        System.out.println("------------------------------------------------------");

        System.out.println("O que deseja fazer agora? (Escolha uma opção): ");
        System.out.print("> ");
        int resposta = input.nextInt();
        input.nextLine();

        if(resposta == 1) {
            operacoes();
        } else {
            sair();
        }

    }

    public static void entrar(){
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("|             1 - Entrar na área do cliente          |");
        System.out.println("|             2 - Sair                               |");
        System.out.println("------------------------------------------------------");
        System.out.println("O que deseja fazer agora? (Escolha uma opção): ");
        System.out.print("> ");


        String resposta = input.nextLine();

        if(resposta.equals("1")) {
            operacoes();
        } else if(resposta.equals("2")) {
            sair();
        } else {
            System.out.println("Opção inválida!");
            entrar();
        }
    }


    public static void criarConta() {
        System.out.println("Você deseja abrir uma conta para Pessoa Física (1) ou Pessoa Jurídica (2)?");
        System.out.print("> ");
        String tipoCliente = input.nextLine();
        System.out.println("--------------------------------------------------");

        System.out.println("Deseja abrir uma conta Corrente (1) ou Poupança (2)?");
        System.out.print("> ");

        String tipoConta = input.nextLine();

        System.out.println("--------------------------------------------------");
        System.out.println("Para criar sua conta, precisamos de algumas informações.");

        if (tipoCliente.equals("1")) {
            criarContaPessoaFisica(tipoConta);
        } else if (tipoCliente.equals("2")) {
            criarContaPessoaJuridica(tipoConta);
        } else {
            System.out.println("Opção inválida!");
            criarConta();
        }
    }

    public static void criarContaPessoaFisica(String tipoConta) {
        System.out.println("\nNome: ");
        System.out.print("> ");
        String nome = input.nextLine();

        System.out.println("\nCPF (apenas números): ");
        System.out.print("> ");
        String cpf = input.nextLine();

        System.out.println("\nEmail: ");
        System.out.print("> ");
        String email = input.nextLine();

        System.out.println("\nTelefone (apenas números): ");
        System.out.print("> ");
        String telefone = input.nextLine();


        if (tipoConta.equals("1")) {
            contaCorrente = new ContaCorrente();
            contaCorrente.abrirContaPF(nome, cpf, email, telefone);
            System.out.println("--- Sua conta corrente foi criada com sucesso! ---");
            System.out.println("--------------------------------------------------");
            contaCorrente.verConta();
        } else if (tipoConta.equals("2")) {
            contaPoupanca = new ContaPoupanca();
            contaPoupanca.abrirContaPF(nome, cpf, email, telefone);
            System.out.println("--- Sua conta poupança foi criada com sucesso! ---");
            System.out.println("--------------------------------------------------");
            contaPoupanca.verConta();
        } else {
            System.out.println("Opção inválida!");
            System.out.println("--------------------------------------------------");
        }

        entrar();
    }

    public static void criarContaPessoaJuridica(String tipoConta) {
        System.out.println("\nNome da empresa: ");
        System.out.print("> ");
        String nomeEmpresa = input.nextLine();

        System.out.println("\nCNPJ (apenas números): ");
        System.out.print("> ");
        String cnpj = input.nextLine();

        System.out.println("\nEmail da empresa: ");
        System.out.print("> ");
        String emailEmpresa = input.nextLine();

        System.out.println("\nTelefone (apenas números): ");
        System.out.print("> ");
        String telefone = input.nextLine();


        if (tipoConta.equals("1")) {
            contaCorrente = new ContaCorrente();
            contaCorrente.abrirContaPJ(nomeEmpresa, cnpj, emailEmpresa, telefone);
            System.out.println("--- Sua conta corrente foi criada com sucesso! ---");
            System.out.println("--------------------------------------------------");
            contaCorrente.verConta();
        } else if (tipoConta.equals("2")) {
            contaPoupanca = new ContaPoupanca();
            contaPoupanca.abrirContaPJ(nomeEmpresa, cnpj, emailEmpresa, telefone );
            System.out.println("--- Sua conta poupança foi criada com sucesso! ---");
            System.out.println("--------------------------------------------------");
            contaPoupanca.verConta();
        } else {
            System.out.println("Opção inválida!");
            System.out.println("--------------------------------------------------");
        }

        entrar();
    }

    public static void depositar() {
        System.out.println("\nDigite o valor a ser depositado: ");
        System.out.print("> ");
        double valorDeposito = input.nextDouble();

        if (contaPoupanca != null) {
            contaPoupanca.depositar(valorDeposito);
        }else if (contaCorrente != null) {
            contaCorrente.depositar(valorDeposito);
        }

        voltar();
    }

    public static void sacar() {
        System.out.println("\nDigite o valor a ser sacado: ");
        System.out.print("> ");
        double valorSaque = input.nextDouble();

        if (contaPoupanca != null) {
            contaPoupanca.sacar(valorSaque);
        }else if (contaCorrente != null) {
            contaCorrente.sacar(valorSaque);
        }

        voltar();
    }

    public static void transferir() {
        System.out.println("\nDigite o número da conta destinatária: ");
        System.out.print("> ");
        String numeroContaDestinatario = input.nextLine();

        System.out.println("\nDigite o valor a ser transferido: ");
        System.out.print("> ");
        double valorTransferencia = input.nextDouble();

        if (contaPoupanca != null) {
            contaPoupanca.transferir(numeroContaDestinatario, valorTransferencia);
        }else if (contaCorrente != null) {
            contaCorrente.transferir(numeroContaDestinatario, valorTransferencia);
        }

        voltar();
    }

    public static void verSaldo() {

        if (contaPoupanca != null) {
            contaPoupanca.verSaldo();
        }else if (contaCorrente != null) {
            contaCorrente.verSaldo();
        }

        voltar();
    }

}