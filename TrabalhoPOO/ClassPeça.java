class Peca {
    private String nome;
    private String codigo;
    private double preco;

    public Peca(String nome, String codigo, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Peça: " + nome + ", Código: " + codigo + ", Preço: R$" + String.format("%.2f", preco);
    }
}