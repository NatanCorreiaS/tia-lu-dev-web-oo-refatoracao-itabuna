import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemCardapio> itens;
    private double valorTotal;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    // CRUD - Adicionar item ao pedido
    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
        valorTotal += item.getPreco();
    }

    // CRUD - Remover item do pedido
    public void removerItem(ItemCardapio item) {
        if (itens.remove(item)) {
            valorTotal -= item.getPreco();
        }
    }

    // CRUD - Atualizar item (substituir um item por outro)
    public void atualizarItem(int index, ItemCardapio novoItem) {
        if (index >= 0 && index < itens.size()) {
            valorTotal -= itens.get(index).getPreco();
            itens.set(index, novoItem);
            valorTotal += novoItem.getPreco();
        }
    }

    // CRUD - Ler/Exibir pedido
    public String exibirPedido() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(id).append("\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Itens:\n");
        for (ItemCardapio item : itens) {
            sb.append("  - ").append(item.exibirItem()).append("\n");
        }
        sb.append("Valor Total: R$ ").append(valorTotal);
        return sb.toString();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}