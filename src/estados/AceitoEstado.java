package estados;
import modelos.Pedido;

public class AceitoEstado implements IPedidoEstado {
    @Override
    public void aceitar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está aceito.");
    }
    @Override
    public void preparar(Pedido pedido) {
        pedido.setEstado(new PreparandoEstado());
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
        throw new IllegalStateException("Pedido aceito não pode ser rejeitado.");
    }
    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoEstado());
    }
    @Override
    public String getNome() { return "Aceito"; }
}