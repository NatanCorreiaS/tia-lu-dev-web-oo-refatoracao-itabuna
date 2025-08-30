public class ItemCardapio {
    private static int proximoCodigo = 1;
    private int codigo;
    private String nome;
    private double preco;

    public ItemCardapio(String nome, double preco) {
        this.codigo = proximoCodigo++;
        this.nome = nome;
        this.preco = preco;
    }

        //get e set
    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String exibirItem() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: R$ " + preco;
    }
}


