import java.util.Scanner;

import modelos.CentralDeDados;
import modelos.Cliente;
import modelos.ItemCardapio;
import modelos.Pedido;
import relatorios.RelatorioDetalhadoStrategy;
import relatorios.RelatorioSimplificadoStrategy;
import relatorios.RelatorioStrategy;


public class MenuPrincipal {
    private CentralDeDados dados = CentralDeDados.getInstancia();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Cadastrar Item do Cardápio");
            System.out.println("4. Listar Itens do Cardápio");
            System.out.println("5. Registrar Pedido");
            System.out.println("6. Avançar Status de Pedido");
            System.out.println("7. Consultar Pedidos por Status");
            System.out.println("8. Aprovar Pedido");
            System.out.println("9. Cancelar Pedido");
            System.out.println("10. Relatório Simplificado");
            System.out.println("11. Relatório Detalhado");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: cadastrarItem(); break;
                case 4: listarItens(); break;
                case 5: registrarPedido(); break;
                case 6: avancarStatusPedido(); break;
                case 7: consultarPedidosPorStatus(); break;
                case 8: aprovarPedido(); break;
                case 9: cancelarPedido(); break;
                case 10: {
                    RelatorioStrategy relatorio = new RelatorioSimplificadoStrategy();
                    relatorio.gerarRelatorio();
                    break;
                }
                case 11: {
                    RelatorioStrategy relatorio = new RelatorioDetalhadoStrategy();
                    relatorio.gerarRelatorio();
                    break;
                }
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        dados.getClientes().add(new Cliente(nome, telefone));
        System.out.println("Cliente cadastrado!");
    }

    private void listarClientes() {
        System.out.println("Clientes cadastrados:");
        for (Cliente c : dados.getClientes()) {
            System.out.println(c.exibirCliente());
        }
    }

    private void cadastrarItem() {
        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        dados.getItensCardapio().add(new ItemCardapio(nome, preco));
        System.out.println("Item cadastrado!");
    }

    private void listarItens() {
        System.out.println("Itens do cardápio:");
        for (ItemCardapio i : dados.getItensCardapio()) {
            System.out.println(i.exibirItem());
        }
    }

    private void registrarPedido() {
        if (dados.getClientes().isEmpty() || dados.getItensCardapio().isEmpty()) {
            System.out.println("Cadastre clientes e itens antes!");
            return;
        }
        System.out.println("Selecione o cliente pelo código:");
        listarClientes();
        int codCliente = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : dados.getClientes()) {
            if (c.getCodigo() == codCliente) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        Pedido pedido = new Pedido(cliente);
        String addMais;
        do {
            listarItens();
            System.out.print("Código do item: ");
            int codItem = scanner.nextInt();
            System.out.print("Quantidade: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();
            ItemCardapio item = null;
            for (ItemCardapio i : dados.getItensCardapio()) {
                if (i.getCodigo() == codItem) {
                    item = i;
                    break;
                }
            }
            if (item != null) {
                pedido.adicionarItem(item, qtd);
            } else {
                System.out.println("Item não encontrado!");
            }
            System.out.print("Adicionar mais itens? (s/n): ");
            addMais = scanner.nextLine();
        } while (addMais.equalsIgnoreCase("s"));
        dados.getPedidos().add(pedido);
        System.out.println("Pedido registrado!");
    }

    private void avancarStatusPedido() {
        System.out.print("Número do pedido: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        Pedido pedido = null;
        for (Pedido p : dados.getPedidos()) {
            if (p.getNumero() == num) {
                pedido = p;
                break;
            }
        }
        if (pedido != null) {
            // Exemplo: avançar para próximo estado (aceitar, preparar, enviar, entregar)
            // Aqui você pode decidir qual ação executar, por exemplo aceitar, preparar, etc.
            // Para fins de exemplo, vamos chamar preparar:
            try {
                pedido.preparar();
                System.out.println("Status atualizado: " + pedido.getEstado().getNome());
            } catch (Exception e) {
                System.out.println("Erro ao avançar status: " + e.getMessage());
            }
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    private void consultarPedidosPorStatus() {
        System.out.print("Nome do estado (ex: Aceito, Preparando, etc): ");
        String estadoStr = scanner.nextLine();
        for (Pedido p : dados.getPedidos()) {
            if (p.getEstado().getNome().equalsIgnoreCase(estadoStr)) {
                System.out.println(p.exibirPedido());
            }
        }
    }
    
    private void aprovarPedido() {
        System.out.print("Número do pedido para aprovar: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        Pedido pedido = null;
        for (Pedido p : dados.getPedidos()) {
            if (p.getNumero() == num) {
                pedido = p;
                break;
            }
        }
        if (pedido != null) {
            try {
                pedido.aceitar();
                System.out.println("Pedido aprovado! Status: " + pedido.getEstado().getNome());
            } catch (Exception e) {
                System.out.println("Erro ao aprovar pedido: " + e.getMessage());
            }
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    private void cancelarPedido() {
        System.out.print("Número do pedido para cancelar: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        Pedido pedido = null;
        for (Pedido p : dados.getPedidos()) {
            if (p.getNumero() == num) {
                pedido = p;
                break;
            }
        }
        if (pedido != null) {
            try {
                pedido.cancelar();
                System.out.println("Pedido cancelado! Status: " + pedido.getEstado().getNome());
            } catch (Exception e) {
                System.out.println("Erro ao cancelar pedido: " + e.getMessage());
            }
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    public static void main(String[] args) {
        new MenuPrincipal().iniciar();
    }
}
