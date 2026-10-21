public abstract class Pedido implements Processavel{
    private int id;
    private String nomeCliente;
    private double valor;
    private StatusPedido status;
    private Categoria categoria;


    public void  processarPedido() throws PedidoInvalidoException{
        if(status == StatusPedido.CANCELADO){
            throw new PedidoInvalidoException(
               "Não é possível processar um pedido cancelado"
            );
        }
        if(status == StatusPedido.ENTREGUE){
            throw new PedidoInvalidoException("Um pedido entregue não pode mudar o status");
        }

        this.status = StatusPedido.PROCESSANDO;
    }

    public Pedido(int id, String nomeCliente, double valor, StatusPedido status, Categoria categoria) throws ValorInvalidoException {

        if(valor <= 0){
            throw new ValorInvalidoException(
                    "O valor do pedido deve ser maior que zero"
            );
        }

        this.id = id;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.status = status;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
