public class IngressoVIP extends Ingresso{
    private boolean acessoBackstage;
    private int numeroLouge;

    public IngressoVIP(int codigo, String nomeEvento, String setor, double valorBase, boolean acessoBackstage, int numeroLouge) {
        super(codigo, nomeEvento, setor, valorBase);
        this.acessoBackstage = acessoBackstage;
        this.numeroLouge = numeroLouge;
    }

    @Override
    public double calcularValorFinal(){
        super.setValorBase(getValorBase()* 1.8);
        return super.getValorBase();
    }

    @Override
    public String obterBeneficios(){
        String beneficios = "Aceso ao louge número " + numeroLouge;
        if(acessoBackstage){
            beneficios += " e acesso ao backstage";
        }
        return beneficios;
    }

    public boolean isAcessoBackstage() {
        return acessoBackstage;
    }

    public void setAcessoBackstage(boolean acessoBackstage) {
        this.acessoBackstage = acessoBackstage;
    }

    public int getNumeroLouge() {
        return numeroLouge;
    }

    public void setNumeroLouge(int numeroLouge) {
        this.numeroLouge = numeroLouge;
    }
}
