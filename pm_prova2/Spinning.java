
public class Spinning extends Atividade implements ControladorPresenca {

    private int quantidadeBicicletas;

    

    public Spinning(String nome, int duracaoAula, int quantidadeMaximaParticipantes, double valorMensal,
            StatusAtividade status, int quantidadeBicicletas) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.quantidadeBicicletas = quantidadeBicicletas;
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        System.out.println("Presença registrada para: " + nomeParticipante);
        System.out.println("Atividade: " + getNome());
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Atividade: Spinning");
        System.out.println("Nome: " + getNome());
        System.out.println("Duração: " + getDuracaoAula());
        System.out.println("Máximo de participantes: " +
                getQuantidadeMaximaParticipantes());
        System.out.println("Quantidade de bicicletas: " +
                getQuantidadeBicicletas());
    }

    public int getQuantidadeBicicletas() {
        return quantidadeBicicletas;
    }

    public void setQuantidadeBicicletas(int quantidadeBicicletas) {
        this.quantidadeBicicletas = quantidadeBicicletas;
    }

    @Override
    public boolean atividadeColetiva(){
        System.out.println("Não é atividade coletiva");
        return true;
    }
}
