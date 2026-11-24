import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    private PedidoEletronico pedido;

    @BeforeEach
    public void configurar() {
        pedido = new PedidoEletronico(
                1,
                "Daniel",
                150.0,
                StatusPedido.PENDENTE,
                Categoria.ELETRONICO
        );

        System.out.println("Iniciando teste...");
    }

    @AfterEach
    public void finalizar() {
        System.out.println("Teste finalizado!");
    }

    @Test
    public void deveCriarPedidoComValorValido() {
        assertEquals(150.0, pedido.getValor(), 0.001);
        assertEquals("Daniel", pedido.getNomeCliente());
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    public void deveLancarExcecaoQuandoValorForZero() {
        assertThrows(ValorInvalidoException.class, () -> {
            new PedidoEletronico(
                    2,
                    "Daniel",
                    0,
                    StatusPedido.PENDENTE,
                    Categoria.ELETRONICO
            );
        });
    }

    @Test
    public void deveLancarExcecaoQuandoValorForNegativo() {
        assertThrows(ValorInvalidoException.class, () -> {
            new PedidoEletronico(
                    3,
                    "Daniel",
                    -50,
                    StatusPedido.PENDENTE,
                    Categoria.ELETRONICO
            );
        });
    }

    @Test
    public void deveProcessarPedidoPendente() throws PedidoInvalidoException {
        pedido.processarPedido();

        assertEquals(StatusPedido.PROCESSANDO, pedido.getStatus());
    }

    @Test
    public void naoDeveProcessarPedidoCancelado() {
        pedido.setStatus(StatusPedido.CANCELADO);

        assertThrows(PedidoInvalidoException.class, () -> {
            pedido.processarPedido();
        });
    }

    @Test
    public void naoDeveProcessarPedidoEntregue() {
        pedido.setStatus(StatusPedido.ENTREGUE);

        assertThrows(PedidoInvalidoException.class, () -> {
            pedido.processarPedido();
        });
    }
}
