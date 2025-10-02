package estados;
import modelos.Pedido;

public class EmEntregaEstado implements IPedidoEstado {
    @Override
    public void aceitar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está em entrega.");
    }
    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está em entrega.");
    }
    @Override
    public void enviarParaEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido já está em entrega.");
    }
    @Override
    public void entregar(Pedido pedido) {
        pedido.setEstado(new EntregueEstado());
    }
    @Override
    public void rejeitar(Pedido pedido, String motivo) {
        throw new IllegalStateException("Pedido em entrega não pode ser rejeitado.");
    }
    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido em entrega não pode ser cancelado.");
    }
    @Override
    public String getNome() { return "Em Entrega"; }
}