import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = LectorCSV.leerArchivo("inventario.csv");

        BinaryTree<String, Producto> arbolSKU = new BinaryTree<>();
        BinaryTree<String, Producto> arbolNombre = new BinaryTree<>();

        for (Producto p : productos) {
            arbolSKU.insertar(p.getSku(), p);
            arbolNombre.insertar(p.getNombre(), p);
        }

        System.out.println("Listado por SKU:");
        arbolSKU.inOrder();

        System.out.println("\nListado por Nombre:");
        arbolNombre.inOrder();
    }
}

