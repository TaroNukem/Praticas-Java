public class ContatoEmergencia extends Contato{
    private int grauPrioridade;
    private String observacao;

    public ContatoEmergencia(String nome, String email, String telefone, int grauPrioridade, String observacao){
        super(nome, email, telefone);
        this.grauPrioridade = grauPrioridade;
        this.observacao = observacao;
    }

    public int getGrauPrioridade() {
        return grauPrioridade;
    }

    public void setGrauPrioridade(int grauPrioridade) {
        if(grauPrioridade >= 1 && grauPrioridade <= 5) {
            this.grauPrioridade = grauPrioridade;
        }
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
