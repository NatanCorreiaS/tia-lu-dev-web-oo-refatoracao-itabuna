package modelos;

import java.util.ArrayList;
import java.util.List;
import estados.AguardandoAceiteEstado;
import estados.IPedidoEstado;
import java.time.LocalDateTime;

public class Pedido {
    private static int proximoNumero = 1;
    private int numero;
    private Cliente cliente;
    private List<PedidoItem> itens;
    private double valorTotal;
    private LocalDateTime dataHora;
    private IPedidoEstado estado;

    public Pedido(Cliente cliente) {
        this.numero = proximoNumero++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.dataHora = LocalDateTime.now();
        this.estado = new AguardandoAceiteEstado();
    }

    public void adicionarItem(ItemCardapio item, int quantidade) {
        PedidoItem pedidoItem = new PedidoItem(item, quantidade);
        itens.add(pedidoItem);
        valorTotal += pedidoItem.getSubtotal();
    }

    public void removerItem(int index) {
        if (index >= 0 && index < itens.size()) {
            valorTotal -= itens.get(index).getSubtotal();
            itens.remove(index);
        }
    }

    public void atualizarItem(int index, ItemCardapio novoItem, int novaQuantidade) {
        if (index >= 0 && index < itens.size()) {
            valorTotal -= itens.get(index).getSubtotal();
            itens.set(index, new PedidoItem(novoItem, novaQuantidade));
            valorTotal += novoItem.getPreco() * novaQuantidade;
        }
    }

    public String exibirPedido() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido Nº: ").append(numero).append("\n");
        sb.append("Data/Hora: ").append(dataHora).append("\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Itens:\n");
        for (PedidoItem pi : itens) {
            sb.append("  - ").append(pi.exibirPedidoItem()).append("\n");
        }
        sb.append("Valor Total: R$ ").append(valorTotal).append("\n");
        sb.append("Status: ").append(estado.getNome());
        return sb.toString();
    }

    // Getters e Setters
    public int getNumero() { return numero; }

    public Cliente getCliente() {
        return cliente;
    }

    public List<PedidoItem> getItens() { return itens; }

    public double getValorTotal() {
        return valorTotal;
    }

    public IPedidoEstado getEstado() {
        return estado;
    }
    public void setEstado(IPedidoEstado estado) {
        this.estado = estado;
    }
    // Métodos delegados para o estado
    public void aceitar() { estado.aceitar(this); }
    public void preparar() { estado.preparar(this); }
    public void enviarParaEntrega() { estado.enviarParaEntrega(this); }
    public void entregar() { estado.entregar(this); }
    public void rejeitar(String motivo) { estado.rejeitar(this, motivo); }
    public void cancelar() { estado.cancelar(this); }
}