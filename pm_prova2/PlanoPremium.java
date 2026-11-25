public class PlanoPremium extends Plano{

    public PlanoPremium(String nome, double valorMensal, int quantidadeMaximaAtividades, StatusPlano status) {
        super(nome, valorMensal, quantidadeMaximaAtividades, status);
    }

    @Override
    public boolean permiteAtividadeColetiva(Atividade atividade){
        return true;
    }

    @Override
    public void exibirDetalhes() {

        System.out.println("Plano: " + getNome());
        System.out.println("Ativo: " + getStatus());
        System.out.println("Tipo: Premium");
        System.out.println("Acesso ilimitado");
    }
}
