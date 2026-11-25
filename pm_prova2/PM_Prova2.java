/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author glbra
 */
public class PM_Prova2 {

    /**
     * @param args the command line arguments
     */

    static Scanner entrada = new Scanner(System.in);

    static ArrayList<Atividade> atividades = new ArrayList<>();
    static ArrayList<Plano> planos = new ArrayList<>();

    public static void main(String[] args) {
        cadastrarDadosIniciais();

        int opcao;

        do {
            System.out.println("\n===== MENU ACADEMIA =====");
            System.out.println("1 - Associar atividade a um plano");
            System.out.println("2 - Exibir atividades");
            System.out.println("3 - Exibir planos");
            System.out.println("4 - Exibir planos ativos");
            System.out.println("5 - Emitir certificado");
            System.out.println("6 - Registrar presença");
            System.out.println("7 - Remover atividades inativas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1 -> associarAtividade();
                case 2 -> exibirAtividades();
                case 3 -> exibirPlanos();
                case 4 -> exibirPlanosAtivos();
                case 5 -> emitirCertificado();
                case 6 -> registrarPresenca();
                case 7 -> removerAtividadesInativas();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }

        }while (opcao != 0) ;
    
    }

    public static void associarAtividade(){
        System.out.println("Digite seu plano: ");
        for(int i = 0; i < planos.size(); i++){
            System.out.println(i + " - " + planos.get(i).getNome());
        }

        int opcaoPlano = entrada.nextInt();

        System.out.println("Digite a atividade que deseja associar");
        for(int i = 0; i < atividades.size(); i++){
            System.out.println(i + " - " + atividades.get(i).getNome());
        }

        int opcaoAtividade = entrada.nextInt();

        planos.get(opcaoPlano).adicionarAtividade(atividades.get(opcaoAtividade));
        }
    }

    public static void exibirPlanos(){
        for(Plano plano : planos){
            plano.exibirDetalhes();
            System.out.println("----------------");
        }
    }

    public static void cadastrarDadosIniciais() {

        atividades.add(new Musculacao("Musculacao", 2, 20, 100, StatusAtividade.INATIVA, 15));
        atividades.add(new Natacao("Natação", 3, 10, 100, StatusAtividade.ATIVA, 2.5));
        atividades.add(new Spinning("Spinning", 1, 5, 25, StatusAtividade.LOTADA, 5));

        planos.add(new PlanoBasico("Básico", 25, 1, StatusPlano.ATIVO));
        planos.add(new PlanoPremium("Premium", 100, 0, StatusPlano.CANCELADO));
    }
    
    public static void exibirPlanosAtivos(){
        for(Plano plano : planos){
            if(plano.getStatus() == StatusPlano.ATIVO){
                plano.exibirDetalhes();
                System.out.println("----------------");
            }
        }
    }

    public static void emitirCertificado(){
        System.out.println("Nome do participante: ");
        String nome = entrada.nextLine();

        for(Atividade atividade: atividades){
            if(atividade instanceof  Certificavel){
                ((Certificavel) atividade).emitirCertificado(nome);
            }
        }
    }

    public static void exibirAtividades(){
        for(Atividade atividade : atividades){
            atividade.exibirDetalhes();
            System.out.println("----------------");
        }
    }

    public static void removerAtividadesInativas(){
        for(Atividade atividade : atividades){
            if(atividade.getStatus() == StatusAtividade.INATIVA){
                atividades.remove(atividade);
            }
        }
        System.out.println("Atividades inativas removidas!");
    }

    public static void registrarPresenca(){
        System.out.println("Nome do participante: ");
        String nome = entrada.nextLine();

        for(Atividade atividade: atividades){
            if(atividade instanceof ControladorPresenca){
                ((ControladorPresenca) atividade).registrarPresenca(nome);
            }
        }
    }
}
