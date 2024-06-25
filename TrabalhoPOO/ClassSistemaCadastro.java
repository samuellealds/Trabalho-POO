import java.util.List;
import java.util.ArrayList;

class SistemaCadastro {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Peca> pecas = new ArrayList<>();
    private List<NotaFiscal> notasFiscais = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(String cpf) {
        clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void adicionarPeca(Peca peca) {
        pecas.add(peca);
    }

    public void removerPeca(String codigo) {
        pecas.removeIf(peca -> peca.getCodigo().equals(codigo));
    }

    public void listarPecas() {
        for (Peca peca : pecas) {
            System.out.println(peca);
        }
    }

    public void gerarNotaFiscal(String cpfCliente, String[] codigosPecas) {
        Cliente cliente = clientes.stream().filter(c -> c.getCpf().equals(cpfCliente)).findFirst().orElse(null);
        List<Peca> pecasSelecionadas = new ArrayList<>();
        for (String codigo : codigosPecas) {
            Peca peca = pecas.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
            if (peca != null) {
                pecasSelecionadas.add(peca);
            }
        }
        if (cliente != null && !pecasSelecionadas.isEmpty()) {
            NotaFiscal nota = new NotaFiscal(cliente, pecasSelecionadas);
            notasFiscais.add(nota);
            System.out.println("Nota Fiscal gerada com sucesso:");
            System.out.println(nota);
        } else {
            System.out.println("Cliente ou peças não encontrados.");
        }
    }

    public void listarNotasFiscais() {
        for (NotaFiscal nota : notasFiscais) {
            System.out.println(nota);
        }
    }
}