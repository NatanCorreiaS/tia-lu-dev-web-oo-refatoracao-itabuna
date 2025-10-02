package modelos;

public class PedidoItem {
    private ItemCardapio item;
    private int quantidade;

    public PedidoItem(ItemCardapio item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public ItemCardapio getItem() { return item; }
    public int getQuantidade() { return quantidade; }
    public double getSubtotal() { return item.getPreco() * quantidade; }
    public String exibirPedidoItem() {
        return quantidade + "x " + item.getNome() + " (R$ " + item.getPreco() + ")";
    }
}