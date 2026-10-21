import java.util.ArrayList;

public class Bilheteria {
    private ArrayList<Ingresso> ingressos;

    public void adicionarIngresso(Ingresso ingresso){
        if(ingresso != null){
            ingressos.add(ingresso);
        }
    }

    public void removerIngresso(int codigo){
        for(int i = 0; i < ingressos.size(); i++){
            if(ingressos.get(i).getCodigo() == codigo){
                ingressos.remove(i);
            }
        }
    }

    public Ingresso buscarIngresso(int codigo){
        for(Ingresso ingresso : ingressos){
            if(ingresso.getCodigo() == codigo){
                return ingresso;
            }
        }
        return null;
    }

    public void listarIngressos(){
        if(ingressos.isEmpty()){
            System.out.println("Nenhum ingresso cadastradado");
            return;
        }
        for(Ingresso ingresso : ingressos){
            ingresso.exibirInformacoes();

            System.out.println("Valor final: R$" + ingresso.calcularValorFinal());
            System.out.println("Beneficios: " + ingresso.obterBeneficios());
            System.out.println("---------");
        }
    }

    public double calcularTotal(){
        double total = 0;
        for(Ingresso ingresso : ingressos){
            total += ingresso.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios(){
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }

        for(Ingresso ingresso : ingressos){
            System.out.println("Ingresso: " + ingresso.getCodigo());
            System.out.println("Evento: " + ingresso.getNomeEvento());
            System.out.println("Beneficios: " + ingresso.obterBeneficios());
        }
    }
}
