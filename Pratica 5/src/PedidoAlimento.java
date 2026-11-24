public class PedidoAlimento extends Pedido{
    public PedidoAlimento(int id, String nomeCliente, double valor, StatusPedido status, Categoria categoria) throws ValorInvalidoException {
        super(id, nomeCliente, valor, status, Categoria.ALIMENTO);
    }

    @Override
    public double calcularValorFinal(){
        return super.getValor();
    }

    public double calcularFrete(){
        return 5;
    }
}
