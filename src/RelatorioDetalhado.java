public class RelatorioDetalhado implements Relatorio {
    @Override
    public void gerarRelatorio() {
        CentralDeDados dados = CentralDeDados.getInstancia();
        System.out.println("Pedidos do Dia:");
        for (Pedido p : dados.getPedidos()) {
            System.out.println(p.exibirPedido());
            System.out.println("----------------------");
        }
    }
}
