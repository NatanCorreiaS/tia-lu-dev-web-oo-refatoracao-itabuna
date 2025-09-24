package estados;
import modelos.Pedido;
public interface IPedidoEstado {
    void aceitar(Pedido pedido);
    void preparar(Pedido pedido);
    void enviarParaEntrega(Pedido pedido);
    void entregar(Pedido pedido);
    void rejeitar(Pedido pedido, String motivo);
    void cancelar(Pedido pedido);
    String getNome();
}