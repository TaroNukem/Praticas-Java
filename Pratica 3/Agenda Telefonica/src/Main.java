import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;
        Agenda agenda = new Agenda();
        boolean rodando = true;
        do {
            System.out.println("--Sistema de Agenda/Contatos--");
            System.out.println("(1) - Adicionar Contato");
            System.out.println("(2) - Remover Contato");
            System.out.println("(3) - Buscar Contato por Nome");
            System.out.println("(4) - Buscar Contato por Email");
            System.out.println("(5) - Buscar Contato por Telefone");
            System.out.println("(6) - Consultar Tamanho da Agenda");
            System.out.println("(7) - Finalizar programa");


            opcao = scanner.nextLine().trim().toLowerCase();

            switch (opcao) {
                case "1":
                    System.out.println("Qual tipo de contato?");
                    System.out.println("(1) - Pessoal");
                    System.out.println("(2) - Profissional");
                    System.out.println("(3) - Emergencia");
                    System.out.println("Escolha: ");

                    String tipo = scanner.nextLine().trim();

                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o email: ");
                    String email = scanner.nextLine();

                    System.out.println("Digite o telefone: ");
                    String telefone = scanner.nextLine();

                    Contato contato = null;
                    switch (tipo) {
                        case "1":
                            System.out.println("Digite a data de aniversário: ");
                            String dataAniversario = scanner.nextLine();

                            System.out.println("Digite o parentesco: ");
                            String parentesco = scanner.nextLine();

                            contato = new ContatoPessoal(nome, email, telefone, dataAniversario, parentesco);
                            break;

                        case "2":
                            System.out.println("Digite a empresa: ");
                            String empresa = scanner.nextLine();

                            System.out.println("Digite o cargo: ");
                            String cargo = scanner.nextLine();

                            contato = new ContatoProfissional(nome, email, telefone, empresa, cargo);
                            break;

                        case "3":
                            System.out.println("Digite o grau de prioriedade: ");
                            int grauPrioridade = Integer.parseInt(scanner.nextLine());

                            System.out.println("Digite a observacao: ");
                            String observacao = scanner.nextLine();

                            contato = new ContatoEmergencia(nome, email, telefone, grauPrioridade, observacao);
                            break;

                        default:
                            System.out.println("Tipo de contato invalido!");
                    }
                    if (contato != null) {
                        agenda.adicionarContato(contato);
                        System.out.println("Contato adicionado com sucesso!");
                    }
                    break;

                case "2":
                    System.out.println("Digite o nome que deseja remover: ");
                    String nomeRemover = scanner.nextLine();
                    if (agenda.removerContato(nomeRemover)) {
                        System.out.println("Removido com sucesso");
                    } else {
                        System.out.println("Não foi possível remover");
                    }
                    break;

                case "3":
                    System.out.println("Digite o nome: ");
                    String nomeBusca = scanner.nextLine();

                    Contato buscaNome = agenda.buscarNome(nomeBusca);

                    if (buscaNome != null) {
                        buscaNome.exibirDados();
                    } else {
                        System.out.println("Contato não encontrado");
                    }
                    break;

                case "4":
                    System.out.println("Digite o email: ");
                    String emailBusca = scanner.nextLine();

                    Contato buscaEmail = agenda.buscarEmail(emailBusca);

                    if (buscaEmail != null) {
                        buscaEmail.exibirDados();
                    } else {
                        System.out.println("Contato não encontrado");
                    }
                    break;

                case "5":
                    System.out.println("Digite o telefone: ");
                    String telefoneBusca = scanner.nextLine();

                    Contato buscaTelefone = agenda.buscarTelefone(telefoneBusca);

                    if (buscaTelefone != null) {
                        buscaTelefone.exibirDados();
                    } else {
                        System.out.println("Contato não encontrado");
                    }
                    break;

                case "6":
                    System.out.println("Tamanho da lista de contatos: ");
                    System.out.println(agenda.getQuantidadeContatos());
                    break;

                case "7":
                    System.out.println("Obrigado");
                    rodando = false;
                    break;

                default:
                    System.out.println("Opcao invalida! Escolha de 1 a 7.");
                    break;
            }
        }
        while (rodando);
    }
}