import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private BinaryTree<String, String> arbol;

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>();
    }

    @Test
    public void testInsertarYBuscar() {
        arbol.insertar("001", "Zapatos deportivos");
        arbol.insertar("002", "Camiseta técnica");

        assertEquals("Zapatos deportivos", arbol.buscar("001"));
        assertEquals("Camiseta técnica", arbol.buscar("002"));
    }

    @Test
    public void testBuscarInexistente() {
        arbol.insertar("001", "Zapatos deportivos");

        assertNull(arbol.buscar("999")); // no existe
    }
   
}
