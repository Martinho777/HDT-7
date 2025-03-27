import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arboles binarios, uno con sku como clave, y otro con el nombre como clave
        BinaryTree<String, Producto> arbolSKU = new BinaryTree<>();
        BinaryTree<String, Producto> arbolNombre = new BinaryTree<>();

        // Cargar productos desde el csv
        List<Producto> productos = LectorCSV.leerArchivo("inventario.csv");
        for (Producto p : productos) {
            arbolSKU.insertar(p.getSku(), p);
            arbolNombre.insertar(p.getNombre(), p);
        }

        boolean salir = false;

        while (!salir) {
            System.out.println("\nOpciones");
            System.out.println("1. Ver productos ordenados por SKU");
            System.out.println("2. Ver productos ordenados por nombre");
            System.out.println("3. Buscar producto por SKU");
            System.out.println("4. Buscar producto por nombre");
            System.out.println("5. Editar producto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Productos por SKU:");
                    arbolSKU.inOrder();
                    break;
                case "2":
                    System.out.println("Productos por Nombre:");
                    arbolNombre.inOrder();
                    break;
                case "3":
                    System.out.print("Ingrese el SKU a buscar: ");
                    String skuBuscar = sc.nextLine();
                    Producto prodSKU = arbolSKU.buscar(skuBuscar);
                    if (prodSKU != null) System.out.println(prodSKU);
                    else System.out.println("Producto no encontrado.");
                    break;
                case "4":
                    System.out.print("Ingrese el Nombre a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    Producto prodNombre = arbolNombre.buscar(nombreBuscar);
                    if (prodNombre != null) System.out.println(prodNombre);
                    else System.out.println("Producto no encontrado.");
                    break;
                case "5":
                    Editor.editarProducto(arbolSKU, arbolNombre, sc);
                    break;
                case "6":
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion inválida.");
            }
        }

        sc.close();
    }
}



