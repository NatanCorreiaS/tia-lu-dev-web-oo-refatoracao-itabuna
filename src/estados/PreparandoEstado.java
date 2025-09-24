package estados;
import modelos.Pedido;

public class PreparandoEstado implements IPedidoEstado {
    @Override
    public void aceitar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está em preparação.");
    }
    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está em preparação.");
    }
    @Override
    public void enviarParaEntrega(Pedido pedido) {
        pedido.setEstado(new AguardandoEntregadorEstado());
    }
    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido precisa ser enviado para entrega antes de entregar.");
    }
    @Override
    public void rejeitar(Pedido pedido, String motivo) {
        throw new IllegalStateException("Pedido em preparação não pode ser rejeitado.");
    }
    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoEstado());
    }
    @Override
    public String getNome() { return "Preparando"; }
}