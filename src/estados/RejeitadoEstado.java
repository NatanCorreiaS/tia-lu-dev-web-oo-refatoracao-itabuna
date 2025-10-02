package estados;
import modelos.Pedido;

public class RejeitadoEstado implements IPedidoEstado {
    private String motivo;
    public RejeitadoEstado(String motivo) { this.motivo = motivo; }
    @Override
    public void aceitar(Pedido pedido) { throw new IllegalStateException("Pedido rejeitado não pode ser aceito."); }
    @Override
    public void preparar(Pedido pedido) { throw new IllegalStateException("Pedido rejeitado não pode ser preparado."); }
    @Override
    public void enviarParaEntrega(Pedido pedido) { throw new IllegalStateException("Pedido rejeitado não pode ser enviado para entrega."); }
    @Override
    public void entregar(Pedido pedido) { throw new IllegalStateException("Pedido rejeitado não pode ser entregue."); }
    @Override
    public void rejeitar(Pedido pedido, String motivo) { throw new IllegalStateException("Pedido já está rejeitado."); }
    @Override
    public void cancelar(Pedido pedido) { throw new IllegalStateException("Pedido rejeitado não pode ser cancelado."); }
    @Override
    public String getNome() { return "Rejeitado: " + motivo; }
}