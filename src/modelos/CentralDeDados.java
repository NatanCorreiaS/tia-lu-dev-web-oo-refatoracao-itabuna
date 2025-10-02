package modelos;
import java.util.ArrayList;
import java.util.List;


public class CentralDeDados {
    private static CentralDeDados instancia;
    private List<Cliente> clientes;
    private List<ItemCardapio> itensCardapio;
    private List<Pedido> pedidos;

    private CentralDeDados() {
        clientes = new ArrayList<>();
        itensCardapio = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public static CentralDeDados getInstancia() {
        if (instancia == null) {
            instancia = new CentralDeDados();
        }
        return instancia;
    }

    public List<Cliente> getClientes() { return clientes; }
    public List<ItemCardapio> getItensCardapio() { return itensCardapio; }
    public List<Pedido> getPedidos() { return pedidos; }
}
