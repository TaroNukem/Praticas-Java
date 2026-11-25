import java.util.ArrayList;

public class PlanoBasico extends Plano implements ControladorPresenca   {
    private ArrayList<String> acessosRegistrados;
    private ArrayList<Atividade> atividades;

    

    public PlanoBasico(String nome, double valorMensal, int quantidadeMaximaAtividades, StatusPlano status) {
        super(nome, valorMensal, quantidadeMaximaAtividades, status);
        
    }


    @Override
    public boolean permiteAtividadeColetiva(Atividade atividade){
        if(!atividade.atividadeColetiva() && getQuantidadeMaximaAtividades() < 1){
            System.out.println("Permitido!");
            setQuantidadeMaximaAtividades(1);
            return true;
        } else{
            System.out.println("Restrição do plano básico");
            return false;
        }
    }
    

    public ArrayList<String> getAcessosRegistrados() {
        return acessosRegistrados;
    }

    public void setAcessosRegistrados(ArrayList<String> acessosRegistrados) {
        this.acessosRegistrados = acessosRegistrados;
    }

    public void registrarPresenca(String nomeParticipante){
        if(!acessosRegistrados.contains(nomeParticipante)){
            acessosRegistrados.add(nomeParticipante);
            System.out.println("Acesso liberado para " + nomeParticipante);
        } else{
            System.out.println("Acesso já utilizado hoje!");
        }
    }



    @Override
    public void exibirDetalhes() {

        System.out.println("Plano: " + getNome());
        System.out.println("Ativo: " + getStatus());
        System.out.println("Tipo: Básico");
        System.out.println("Limite: 1 acesso por dia");
}


    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }


    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }


}
