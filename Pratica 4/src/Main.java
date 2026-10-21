import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        ArrayList<Pedido> pedidos = new ArrayList<>();


        do {
            System.out.println("1.Cadastrar pedido");
            System.out.println("2. Alterar o status de um pedido");
            System.out.println("3. Processar pedido");
            System.out.println("4. Remover cancelados");
            System.out.println("5. Exibir lista de pedidos");
            System.out.println("6. Exibir pedidos entregáveis");
            System.out.println("7. Encerrar");
            String opcao;
            opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Qual tipo de pedido você deseja fazer?");
                    System.out.println("1. Pedido Eletronico");
                    System.out.println("2. Pedido de Roupa");
                    System.out.println("3. Pedido Alimentar");
                    String tipo = scanner.nextLine();

                    System.out.println("Digite o ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.println("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.println("Digite o valor: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    try {
                        Pedido pedido;
                        switch (tipo) {
                            case "1":
                                pedido = new PedidoEletronico(id, nomeCliente, valor, StatusPedido.PENDENTE, Categoria.ELETRONICO);
                                break;

                            case "2":
                                pedido = new PedidoRoupa(id, nomeCliente, valor, StatusPedido.PENDENTE, Categoria.ROUPA);
                                break;

                            case "3":
                                pedido = new PedidoAlimento(id, nomeCliente, valor, StatusPedido.PENDENTE, Categoria.ALIMENTO);
                                break;

                            default:
                                System.out.println("erro");
                                pedido = null;
                                break;
                        }
                        if (pedido != null) {
                            pedidos.add(pedido);
                        }
                    } catch (ValorInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Digite o id do pedido: ");
                    int idBusca = Integer.parseInt(scanner.nextLine());
                    boolean encontrado = false;

                    for (Pedido p : pedidos) {
                        if (p.getId() == idBusca) {
                            encontrado = true;

                            System.out.println("Escolha o novo status:");
                            System.out.println("1. PENDENTE");
                            System.out.println("2. PROCESSANDO");
                            System.out.println("3. ENVIADO");
                            System.out.println("4. ENTREGUE");
                            System.out.println("5. CANCELADO");

                            String novoStatus = scanner.nextLine();

                            switch (novoStatus) {
                                case "1":
                                    p.setStatus(StatusPedido.PENDENTE);
                                    break;

                                case "2":
                                    p.setStatus(StatusPedido.PROCESSANDO);
                                    break;

                                case "3":
                                    p.setStatus(StatusPedido.ENVIADO);
                                    break;

                                case "4":
                                    p.setStatus(StatusPedido.ENTREGUE);
                                    break;

                                case "5":
                                    p.setStatus(StatusPedido.CANCELADO);
                                    break;

                                default:
                                    System.out.println("erro");
                                    break;
                            }
                            System.out.println("Status atualizado");
                            break;
                        }
                    }
                    if(!encontrado){
                        System.out.println("Pedido não encontrado");
                    }

                    break;
                case "3":
                    Iterator<Pedido> it = pedidos.iterator();

                    while(it.hasNext()){
                        Pedido p = it.next();
                        try{
                            p.processarPedido();
                            System.out.println("Pedido " + p.getId() + "processado!");
                        } catch(PedidoInvalidoException e ){
                        System.out.println("Erro no pedido " + p.getId() + ": " + e.getMessage());}
                    }
                    break;
                case "4":
                    Iterator<Pedido> itRemo = pedidos.iterator();
                    while(itRemo.hasNext()){
                        Pedido p = itRemo.next();

                        if(p.getStatus() == StatusPedido.CANCELADO){
                            itRemo.remove();
                            System.out.println("Pedido removido");
                        }
                    }
                    break;
                case "5":
                    for(Pedido p : pedidos){
                        if(p.getStatus() != StatusPedido.CANCELADO){
                            System.out.println("ID: " + p.getId());
                            System.out.println("Cliente: " + p.getNomeCliente());
                            System.out.println("Valor: R$ " + p.getValor());
                            System.out.println("Status: " + p.getStatus());
                            System.out.println("----------------------");
                        }
                    }
                    break;
                case "6":
                    for(Pedido p : pedidos){
                        if(p instanceof Entregavel){
                            System.out.println("ID: " + p.getId());
                            System.out.println("Cliente: " + p.getNomeCliente());
                            System.out.println("Valor final: R$ " + p.calcularValorFinal());
                            System.out.println("Frete: R$ " + ((Entregavel) p).calcularFrete());
                            System.out.println("----------------------");
                        }
                    }
                    break;
                case "7":
                    System.out.println("Fim");
                    rodando = false;
                    break;
                default:
                    System.out.println("Erro");
            }
        } while (rodando);
        scanner.close();
    }
}
