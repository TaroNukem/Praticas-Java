public class IngressoComum extends Ingresso{

    public IngressoComum(int codigo, String nomeEvento, String setor, double valorBase) {
        super(codigo, nomeEvento, setor, valorBase);
    }

    @Override
    public double calcularValorFinal(){
        return super.getValorBase();
    }

    @Override
    public String obterBeneficios(){
        return "Não possui nenhum benefício";
    }
}
