public class PedidoEletronico extends Pedido implements Entregavel{
    public PedidoEletronico(int id, String nomeCliente, double valor, StatusPedido status, Categoria categoria) throws ValorInvalidoException {
        super(id, nomeCliente, valor, status, Categoria.ELETRONICO);
    }

    @Override
    public double calcularValorFinal(){
        if(getValor() > 100){
            return getValor() * 0.9;
        }
        return getValor();
    }

    @Override
    public double calcularFrete(){
        return 20 + (getValor() * 0.1);
    }
}
