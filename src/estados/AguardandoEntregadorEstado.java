package estados;
import modelos.Pedido;

public class AguardandoEntregadorEstado implements IPedidoEstado {
    @Override
    public void aceitar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está aguardando entregador.");
    }
    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está aguardando entregador.");
    }
    @Override
    public void enviarParaEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido já está aguardando entregador.");
    }
    @Override
    public void entregar(Pedido pedido) {
        pedido.setEstado(new EmEntregaEstado());
    }
    @Override
    public void rejeitar(Pedido pedido, String motivo) {
        throw new IllegalStateException("Pedido aguardando entregador não pode ser rejeitado.");
    }
    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoEstado());
    }
    @Override
    public String getNome() { return "Aguardando Entregador"; }
}