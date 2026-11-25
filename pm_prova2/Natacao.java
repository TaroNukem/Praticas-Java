
public class Natacao extends Atividade implements Certificavel, ControladorPresenca {

    private double profundidade;


    public Natacao(String nome, int duracaoAula, int quantidadeMaximaParticipantes, double valorMensal,
            StatusAtividade status, double profundidade) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.profundidade = profundidade;
    }

    @Override
    public void emitirCertificado(String nomeParticipante) {
        System.out.println("Certificado emitido para: " + nomeParticipante);
        System.out.println("Atividade: " + getNome());
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        System.out.println("Presença registrada para: " + nomeParticipante);
        System.out.println("Atividade: " + getNome());
    }

    @Override
    public void exibirDetalhes() {

        System.out.println("Atividade: Musculação");
        System.out.println("Nome: " + getNome());
        System.out.println("Duração: " + getDuracaoAula());
        System.out.println("Máximo de participantes: " +
                getQuantidadeMaximaParticipantes());
        System.out.println("Quantidade de profundidade: " +
                getProfundidade());
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    @Override
    public boolean atividadeColetiva(){
        System.out.println("Não é atividade coletiva");
        return true;
    }
}
