public class PedidoRoupa extends Pedido implements Entregavel{
    public PedidoRoupa(int id, String nomeCliente, double valor, StatusPedido status, Categoria categoria) throws ValorInvalidoException {
        super(id, nomeCliente, valor, status, Categoria.ROUPA);
    }

    @Override
    public double calcularValorFinal(){
        if(getValor() > 200){
            return getValor() * 0.8;
        }
        return getValor();
    }

    @Override
    public double calcularFrete(){
        return 10 + (getValor() * 0.05);
    }
}
