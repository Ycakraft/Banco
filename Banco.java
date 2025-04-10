import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clientes;
    private List<Conta> contas;
    private Scanner scanner;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void cadastrarCliente() {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Escolha o tipo de cliente: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        if (opcao == 1) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            clientes.add(new PessoaFisica(nome, cpf, endereco));
        } else {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            clientes.add(new PessoaJuridica(nome, cnpj, endereco));
        }
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarConta() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
            return;
        }

        System.out.println("\n=== Cadastro de Conta ===");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println("3 - Conta Rendimento");
        System.out.print("Escolha o tipo de conta: ");
        
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("\nClientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i).getNome());
        }
        System.out.print("Escolha o cliente: ");
        
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar o buffer

        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido!");
            return;
        }

        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();

        Conta conta = null;
        switch (tipoConta) {
            case 1:
                System.out.print("Limite (0 para sem limite): ");
                double limite = scanner.nextDouble();
                conta = limite > 0 ? 
                    new ContaCorrente(numero, clientes.get(clienteIndex), limite) :
                    new ContaCorrente(numero, clientes.get(clienteIndex));
                break;
            case 2:
                conta = new ContaPoupanca(numero, clientes.get(clienteIndex));
                break;
            case 3:
                conta = new ContaRendimento(numero, clientes.get(clienteIndex));
                break;
            default:
                System.out.println("Tipo de conta inválido!");
                return;
        }

        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public void realizarOperacao() {
        if (contas.isEmpty()) {
            System.out.println("Não há contas cadastradas!");
            return;
        }

        System.out.println("\n=== Operações Bancárias ===");
        System.out.println("1 - Depósito");
        System.out.println("2 - Saque");
        System.out.print("Escolha a operação: ");
        
        int operacao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("\nContas disponíveis:");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println((i + 1) + " - " + contas.get(i));
        }
        System.out.print("Escolha a conta: ");
        
        int contaIndex = scanner.nextInt() - 1;
        if (contaIndex < 0 || contaIndex >= contas.size()) {
            System.out.println("Conta inválida!");
            return;
        }

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        if (operacao == 1) {
            contas.get(contaIndex).depositar(valor);
        } else if (operacao == 2) {
            contas.get(contaIndex).sacar(valor);
        } else {
            System.out.println("Operação inválida!");
        }
    }

    public void listarClientesEContas() {
        System.out.println("\n=== Clientes e Contas ===");
        clientes.forEach(cliente -> {
            System.out.println("\nCliente: " + cliente.getNome());
            System.out.println("Identificação: " + cliente.getIdentificacao());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Contas:");
            contas.stream()
                .filter(conta -> conta.getTitular().equals(cliente))
                .forEach(conta -> System.out.println("  " + conta));
        });
    }

    public void removerCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
            return;
        }

        System.out.println("\n=== Remoção de Cliente ===");
        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i).getNome());
        }
        System.out.print("Escolha o cliente para remover: ");
        
        int clienteIndex = scanner.nextInt() - 1;
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido!");
            return;
        }

        Cliente cliente = clientes.get(clienteIndex);
        contas.removeIf(conta -> conta.getTitular().equals(cliente));
        clientes.remove(clienteIndex);
        System.out.println("Cliente e suas contas removidos com sucesso!");
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== Sistema Bancário ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Realizar Operação");
            System.out.println("4 - Listar Clientes e Contas");
            System.out.println("5 - Remover Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarConta();
                    break;
                case 3:
                    realizarOperacao();
                    break;
                case 4:
                    listarClientesEContas();
                    break;
                case 5:
                    removerCliente();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.menu();
    }
} 