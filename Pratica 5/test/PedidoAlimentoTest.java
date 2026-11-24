import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoAlimentoTest {

    private PedidoAlimento pedido;

    @BeforeEach
    public void configurar(){
        pedido = new PedidoAlimento(1, "Daniel", 50, StatusPedido.PENDENTE, Categoria.ALIMENTO);
        System.out.println("Iniciando teste de pedido alimento");
    }

    @AfterEach
    public void finalizar(){
        System.out.println("Testes Finalizado!");
    }

    @Test
    public void naoAplicarDesconto(){
        assertEquals(50, pedido.calcularValorFinal());
    }

    @Test
    public void deveCalcularFrete(){
        assertEquals(5, pedido.calcularFrete(), 0.001);
    }

    @Test
    public void deveProcessar() throws  PedidoInvalidoException{
        pedido.processarPedido();
        assertEquals(StatusPedido.PROCESSANDO, pedido.getStatus());
    }

    @Test
    public void naoDeveProcessar() throws PedidoInvalidoException{
        PedidoAlimento pedido = new PedidoAlimento(67, "Daniel", 150, StatusPedido.CANCELADO, Categoria.ALIMENTO);

        assertThrows(PedidoInvalidoException.class, () ->{
            pedido.processarPedido();
        });
    }

    @Test
    public void valorZero() throws ValorInvalidoException{
        assertThrows(ValorInvalidoException.class, () ->{
            pedido = new PedidoAlimento(1, "D", 0.0, StatusPedido.CANCELADO, Categoria.ALIMENTO);
        });
    }

    @Test
    public void valorNegativo() throws ValorInvalidoException{
        assertThrows(ValorInvalidoException.class, () ->{
            pedido = new PedidoAlimento(1, "D", -10.0, StatusPedido.CANCELADO, Categoria.ALIMENTO);
        });
    }

    @Test
    public void deveSerProcessavel(){
        assertTrue(pedido instanceof Processavel);
    }

    @Test
    public void deveSerEntregavel(){
        assertTrue(pedido instanceof Entregavel);
    }
}
