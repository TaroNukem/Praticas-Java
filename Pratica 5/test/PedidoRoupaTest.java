import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoRoupaTest {

    private PedidoRoupa pedido;

    @BeforeEach
    public void configurar(){
        pedido = new PedidoRoupa(1, "Daniel", 100, StatusPedido.PENDENTE, Categoria.ROUPA);
        System.out.println("Iniciando testes de pedido roupa");
    }

    @AfterEach
    public void finalizar(){
        System.out.println("Testes Finalizados!");
    }

    @Test
    public void naoDeveTerDesconto(){
        assertEquals(100, pedido.calcularValorFinal(), 0.001);
    }

    @Test
    public void deveTerDesconto(){
        pedido.setValor(300.0);
        assertEquals(240, pedido.calcularValorFinal(), 0.001);
    }

    @Test
    public void caculaFrete(){
        assertEquals(15.0, pedido.calcularFrete(), 0.001);
    }
}
