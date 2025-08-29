public class Main {
    public static void main(String[] args) {
        // Criando um cliente
        Cliente cliente = new Cliente("1","Maria");

        // Criando itens do cardápio
        ItemCardapio item1 = new ItemCardapio(1, "Pizza", 35.0);
        ItemCardapio item2 = new ItemCardapio(2, "Hamburguer", 20.0);

        // Criando um pedido
        Pedido pedido = new Pedido(1, cliente);

        // Adicionando itens ao pedido
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        // Exibindo informações do pedido
        System.out.println("Pedido ID :  " + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Itens do pedido: ");
        for (ItemCardapio item : pedido.getItens()) {
            System.out.println(" - "  + item.exibirItem());
        }
    }
}