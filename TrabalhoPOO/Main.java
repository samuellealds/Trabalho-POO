import java.util.Scanner;

public class Main {
    private static SistemaCadastro sistema = new SistemaCadastro();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Adicionar Peça");
            System.out.println("5. Remover Peça");
            System.out.println("6. Listar Peças");
            System.out.println("7. Gerar Nota Fiscal");
            System.out.println("8. Listar Notas Fiscais");
            System.out.println("9. Sair");

            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    adicionarCliente();
                    break;
                case "2":
                    removerCliente();
                    break;
                case "3":
                    listarClientes();
                    break;
                case "4":
                    adicionarPeca();
                    break;
                case "5":
                    removerPeca();
                    break;
                case "6":
                    listarPecas();
                    break;
                case "7":
                    gerarNotaFiscal();
                    break;
                case "8":
                    listarNotasFiscais();
                    break;
                case "9":
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone do cliente: ");
        String telefone = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, telefone);
        sistema.adicionarCliente(cliente);
    }

    private static void removerCliente() {
        System.out.print("CPF do cliente a ser removido: ");
        String cpf = scanner.nextLine();
        sistema.removerCliente(cpf);
    }

    private static void listarClientes() {
        sistema.listarClientes();
    }

    private static void adicionarPeca() {
        System.out.print("Nome da peça: ");
        String nome = scanner.nextLine();
        System.out.print("Código da peça: ");
        String codigo = scanner.nextLine();
        System.out.print("Preço da peça: ");
        double preco = Double.parseDouble(scanner.nextLine());
        Peca peca = new Peca(nome, codigo, preco);
        sistema.adicionarPeca(peca);
    }

    private static void removerPeca() {
        System.out.print("Código da peça a ser removida: ");
        String codigo = scanner.nextLine();
        sistema.removerPeca(codigo);
    }

    private static void listarPecas() {
        sistema.listarPecas();
    }

    private static void gerarNotaFiscal() {
        System.out.print("CPF do cliente: ");
        String cpfCliente = scanner.nextLine();
        System.out.print("Códigos das peças (separados por vírgula): ");
        String[] codigosPecas = scanner.nextLine().split(",");
        sistema.gerarNotaFiscal(cpfCliente, codigosPecas);
    }

    private static void listarNotasFiscais() {
        sistema.listarNotasFiscais();
    }
}