public class IngressoEstudante extends Ingresso{
    private String instituitoEnsino;

    @Override
    public double calcularValorFinal(){
        super.setValorBase(super.getValorBase()*0.5);
        return super.getValorBase();
    }

    @Override
    public String obterBeneficios(){
        return "Tens direito á meia-entrada";
    }

    public IngressoEstudante(int codigo, String nomeEvento, String setor, double valorBase, String instituitoEnsino) {
        super(codigo, nomeEvento, setor, valorBase);
        this.instituitoEnsino = instituitoEnsino;
    }

    public String getInstituitoEnsino() {
        return instituitoEnsino;
    }

    public void setInstituitoEnsino(String instituitoEnsino) {
        this.instituitoEnsino = instituitoEnsino;
    }

    public IngressoEstudante(String instituitoEnsino, int codigo, String nomeEvento, String setor, double valorBase) {
        super(codigo, nomeEvento, setor, valorBase);
        this.instituitoEnsino = instituitoEnsino;
    }
}
