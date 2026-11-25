public class Musculacao extends Atividade {

    private int quantidadeAparelhos;

    public Musculacao(String nome, int duracaoAula, int quantidadeMaximaParticipantes, double valorMensal,
            StatusAtividade status, int quantidadeAparelhos) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.quantidadeAparelhos = quantidadeAparelhos;
    }

    @Override
    public void exibirDetalhes() {

        System.out.println("Atividade: Musculação");
        System.out.println("Nome: " + getNome());
        System.out.println("Duração: " + getDuracaoAula());
        System.out.println("Máximo de participantes: " +
                getQuantidadeMaximaParticipantes());
        System.out.println("Quantidade de aparelhos: " +
                getQuantidadeAparelhos());
    }

    public int getQuantidadeAparelhos() {
        return quantidadeAparelhos;
    }

    public void setQuantidadeAparelhos(int quantidadeAparelhos) {
        this.quantidadeAparelhos = quantidadeAparelhos;
    }

    @Override
    public boolean atividadeColetiva(){
        System.out.println("Não é atividade coletiva");
        return false;
    }

}