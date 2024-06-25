import java.util.List;

class NotaFiscal {
    private Cliente cliente;
    private List<Peca> pecas;
    private double total;

    public NotaFiscal(Cliente cliente, List<Peca> pecas) {
        this.cliente = cliente;
        this.pecas = pecas;
        this.total = pecas.stream().mapToDouble(Peca::getPreco).sum();
    }

    @Override
    public String toString() {
        StringBuilder pecasStr = new StringBuilder();
        for (Peca peca : pecas) {
            pecasStr.append(peca).append("\n");
        }
        return "Nota Fiscal\nCliente: " + cliente.getNome() + " - CPF: " + cliente.getCpf() +
                "\nPeças:\n" + pecasStr + "Total: R$" + String.format("%.2f", total);
    }
}
