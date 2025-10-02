package estados;
import modelos.Pedido;

public class EntregueEstado implements IPedidoEstado {
    @Override
    public void aceitar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está entregue.");
    }
    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está entregue.");
    }
    @Override
    public void enviarParaEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido já está entregue.");
    }
    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está entregue.");
    }
    @Override
    public void rejeitar(Pedido pedido, String motivo) {
        throw new IllegalStateException("Pedido entregue não pode ser rejeitado.");
    }
    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido entregue não pode ser cancelado.");
    }
    @Override
    public String getNome() { return "Entregue"; }
}