public class RelatorioSimplificado implements Relatorio {
    @Override
    public void gerarRelatorio() {
        CentralDeDados dados = CentralDeDados.getInstancia();
        int totalPedidos = dados.getPedidos().size();
        double totalValor = 0.0;
        for (Pedido p : dados.getPedidos()) {
            totalValor += p.getValorTotal();
        }
        System.out.println("Resumo do Dia:");
        System.out.println("Total de pedidos: " + totalPedidos);
        System.out.println("Valor total arrecadado: R$ " + totalValor);
    }
}
