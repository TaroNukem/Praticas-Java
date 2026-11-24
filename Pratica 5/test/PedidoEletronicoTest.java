import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoEletronicoTest {
    private PedidoEletronico pedido;

    @BeforeEach
    public void configurar(){
        pedido = new PedidoEletronico(1, "Daniel", 150.0, StatusPedido.PENDENTE, Categoria.ELETRONICO);
        System.out.println("Iniciando teste de pedido eletrônico");
    }

    @AfterEach
    public void finalizar(){
        System.out.println("Teste de pedido eletrônico finalizado!");
    }

    @Test
    public void deveAplicarDescontoDe10PorCento(){
        assertEquals(135.0, pedido.calcularValorFinal(), 0.001);
    }

    @Test
    public void naoDeveAplicarDescontoAte100Reais() throws ValorInvalidoException{
        PedidoEletronico pedidoSemDesconto = new PedidoEletronico(
                2, "Daniel", 100, StatusPedido.PENDENTE, Categoria.ELETRONICO
        );

        assertEquals(100, pedidoSemDesconto.calcularValorFinal(), 0.001);
    }

    @Test
    public void deveCalcularFreteCorretamente(){
        assertEquals(35.0, pedido.calcularFrete(), 0.001);
    }

    @Test
    public void deveProcessarPedido() throws PedidoInvalidoException{
        pedido.processarPedido();
        assertEquals(StatusPedido.PROCESSANDO, pedido.getStatus());
    }

    @Test
    public void NaodeveProcessarPedido() throws PedidoInvalidoException{
        PedidoEletronico pedidoCancelado = new PedidoEletronico(2, "Daniel", 100, StatusPedido.ENTREGUE, Categoria.ELETRONICO);

        assertThrows(PedidoInvalidoException.class, () ->{
            pedidoCancelado.processarPedido();
        });
        assertEquals(StatusPedido.ENTREGUE, pedidoCancelado.getStatus());
    }

    @Test
    public void deveLancaExecessaoZero() throws ValorInvalidoException{
        assertThrows(ValorInvalidoException.class, () ->{
            new PedidoEletronico(3, "Daniel", 0.0, StatusPedido.PENDENTE, Categoria.ELETRONICO);
        });
    }

    @Test
    public void deveLancaNegativo() throws ValorInvalidoException{
        assertThrows(ValorInvalidoException.class, () ->{
            new PedidoEletronico(4, "Daniel", -10.0, StatusPedido.PENDENTE, Categoria.ELETRONICO);
        });
    }

    @Test
    public void deveSerEletronico(){
        PedidoEletronico pedido = new PedidoEletronico(1, "Daniel", 150, StatusPedido.PENDENTE, Categoria.ELETRONICO);

        assertEquals(Categoria.ELETRONICO, pedido.getCategoria());
    }

    @Test
    public void deveImplementarInterfaceProcessavel(){
        PedidoEletronico pedido = new PedidoEletronico(1, "Daniel", 150, StatusPedido.PENDENTE, Categoria.ELETRONICO);

        assertTrue(pedido instanceof Processavel);
    }

    @Test
    public void deveImplementarInterfaceEntregavel(){
        PedidoEletronico pedido = new PedidoEletronico(1, "Daniel", 150, StatusPedido.PENDENTE, Categoria.ELETRONICO);

        assertTrue(pedido instanceof Entregavel);
    }
}
