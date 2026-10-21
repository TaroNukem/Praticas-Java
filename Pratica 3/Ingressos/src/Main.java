
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();

        String opcao;

        do {
            System.out.println("\n===== SISTEMA DE BILHETERIA =====");
            System.out.println("(a) Cadastrar ingresso");
            System.out.println("(b) Remover ingresso");
            System.out.println("(c) Buscar ingresso por codigo");
            System.out.println("(d) Listar todos os ingressos");
            System.out.println("(e) Calcular arrecadacao total");
            System.out.println("(f) Listar beneficios dos ingressos");
            System.out.println("(g) Finalizar");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextLine().trim().toLowerCase();

            switch (opcao) {

                case "a": {
                    System.out.println("\n--- Cadastrar ingresso ---");
                    System.out.println("1 - Ingresso comum");
                    System.out.println("2 - Ingresso estudante");
                    System.out.println("3 - Ingresso VIP");
                    System.out.print("Escolha o tipo: ");

                    String tipo = scanner.nextLine().trim();

                    System.out.print("Codigo: ");
                    int codigo = Integer.parseInt(scanner.nextLine());

                    // Verifica se o codigo ja esta cadastrado.
                    if (bilheteria.buscarIngresso(codigo) != null) {
                        System.out.println("Ja existe um ingresso com esse codigo.");
                        break;
                    }

                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();

                    System.out.print("Setor: ");
                    String setor = scanner.nextLine();

                    System.out.print("Valor base: R$ ");
                    double valorBase = Double.parseDouble(
                            scanner.nextLine().replace(",", ".")
                    );

                    if (valorBase < 0) {
                        System.out.println("O valor base nao pode ser negativo.");
                        break;
                    }

                    switch (tipo) {

                        case "1": {
                            IngressoComum ingresso =
                                    new IngressoComum(codigo, nomeEvento, setor, valorBase);

                            bilheteria.adicionarIngresso(ingresso);
                            System.out.println("Ingresso comum cadastrado!");
                            break;
                        }

                        case "2": {
                            System.out.print("Instituicao de ensino: ");
                            String instituicao = scanner.nextLine();

                            IngressoEstudante ingresso =
                                    new IngressoEstudante(
                                            codigo, nomeEvento, setor,
                                            valorBase, instituicao
                                    );

                            bilheteria.adicionarIngresso(ingresso);
                            System.out.println("Ingresso de estudante cadastrado!");
                            break;
                        }

                        case "3": {
                            System.out.print("Possui acesso ao backstage? (s/n): ");
                            String resposta = scanner.nextLine().trim();

                            boolean acessoBackstage =
                                    resposta.equalsIgnoreCase("s");

                            System.out.print("Numero do lounge: ");
                            int numeroLounge = Integer.parseInt(scanner.nextLine());

                            IngressoVIP ingresso =
                                    new IngressoVIP(
                                            codigo, nomeEvento, setor, valorBase,
                                            acessoBackstage, numeroLounge
                                    );

                            bilheteria.adicionarIngresso(ingresso);
                            System.out.println("Ingresso VIP cadastrado!");
                            break;
                        }

                        default:
                            System.out.println("Tipo de ingresso invalido.");
                    }

                    break;
                }

                case "b": {
                    System.out.println("\n--- Remover ingresso ---");
                    System.out.print("Digite o codigo do ingresso: ");
                    int codigo = Integer.parseInt(scanner.nextLine());

                    if (bilheteria.buscarIngresso(codigo) != null) {
                        bilheteria.removerIngresso(codigo);
                        System.out.println("Ingresso removido com sucesso!");
                    } else {
                        System.out.println("Ingresso nao encontrado.");
                    }

                    break;
                }

                case "c": {
                    System.out.println("\n--- Buscar ingresso ---");
                    System.out.print("Digite o codigo do ingresso: ");
                    int codigo = Integer.parseInt(scanner.nextLine());

                    Ingresso ingresso = bilheteria.buscarIngresso(codigo);

                    if (ingresso != null) {
                        ingresso.exibirInformacoes();
                        System.out.println(
                                "Valor final: R$ " + ingresso.calcularValorFinal()
                        );
                        System.out.println(
                                "Beneficios: " + ingresso.obterBeneficios()
                        );
                    } else {
                        System.out.println("Ingresso nao encontrado.");
                    }

                    break;
                }

                case "d": {
                    System.out.println("\n--- Todos os ingressos ---");
                    bilheteria.listarIngressos();
                    break;
                }

                case "e": {
                    System.out.println("\n--- Arrecadacao total ---");
                    double total = bilheteria.calcularTotal();
                    System.out.printf("Arrecadacao total: R$ %.2f%n", total);
                    break;
                }

                case "f": {
                    System.out.println("\n--- Beneficios dos ingressos ---");
                    bilheteria.listarBeneficios();
                    break;
                }

                case "g": {
                    System.out.println("Encerrando o sistema...");
                    break;
                }

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (!opcao.equals("g"));

        scanner.close();
    }
}
