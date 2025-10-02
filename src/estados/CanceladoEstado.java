package estados;
import modelos.Pedido;

public class CanceladoEstado implements IPedidoEstado {
    @Override
    public void aceitar(Pedido pedido) { throw new IllegalStateException("Pedido cancelado não pode ser aceito."); }
    @Override
    public void preparar(Pedido pedido) { throw new IllegalStateException("Pedido cancelado não pode ser preparado."); }
    @Override
    public void enviarParaEntrega(Pedido pedido) { throw new IllegalStateException("Pedido cancelado não pode ser enviado para entrega."); }
    @Override
    public void entregar(Pedido pedido) { throw new IllegalStateException("Pedido cancelado não pode ser entregue."); }
    @Override
    public void rejeitar(Pedido pedido, String motivo) { throw new IllegalStateException("Pedido cancelado não pode ser rejeitado."); }
    @Override
    public void cancelar(Pedido pedido) { throw new IllegalStateException("Pedido já está cancelado."); }
    @Override
    public String getNome() { return "Cancelado"; }
}