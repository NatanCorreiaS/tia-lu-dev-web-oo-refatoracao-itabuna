package estados;
import modelos.Pedido;

public class AguardandoAceiteEstado implements IPedidoEstado {
    @Override
    public void aceitar(Pedido pedido) {
        pedido.setEstado(new AceitoEstado());
        // Notificar cliente, etc.
    }
    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido precisa ser aceito antes de preparar.");
    }
    @Override
    public void enviarParaEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido precisa ser preparado antes de enviar para entrega.");
    }
    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido precisa ser enviado para entrega antes de entregar.");
    }
    @Override
    public void rejeitar(Pedido pedido, String motivo) {
        pedido.setEstado(new RejeitadoEstado(motivo));
        // Notificar cliente, etc.
    }
    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoEstado());
        // Notificar cliente, etc.
    }
    @Override
    public String getNome() { return "Aguardando Aceite"; }
}