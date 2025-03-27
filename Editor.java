import java.util.Map;
import java.util.Scanner;

public class Editor {

    public static void editarProducto(BinaryTree<String, Producto> arbolSKU, BinaryTree<String, Producto> arbolNombre, Scanner sc) {
        System.out.println("¿Desea buscar el producto por:");
        System.out.println("1. SKU");
        System.out.println("2. Nombre");
        String opcion = sc.nextLine();

        Producto producto = null;

        if (opcion.equals("1")) {
            System.out.print("Ingrese el SKU del producto: ");
            String sku = sc.nextLine();
            producto = arbolSKU.buscar(sku);
        } else if (opcion.equals("2")) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = sc.nextLine();
            producto = arbolNombre.buscar(nombre);
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Producto encontrado:");
        System.out.println(producto);

        System.out.print("¿Desea modificar la descripción? (s/n): ");
        String cambiarDesc = sc.nextLine();
        if (cambiarDesc.equalsIgnoreCase("s")) {
            System.out.print("Nueva descripción: ");
            String nuevaDesc = sc.nextLine();
            producto.setDescripcion(nuevaDesc);
        }

        System.out.print("¿Desea modificar las tallas? (s/n): ");
        String cambiarTallas = sc.nextLine();
        if (cambiarTallas.equalsIgnoreCase("s")) {
            System.out.println("Ingrese las tallas en formato xs:10|s:15|m:20 (solo las que desea modificar): ");
            String entradaTallas = sc.nextLine();
            Map<String, Integer> tallas = producto.getTallas();

            String[] pares = entradaTallas.split("\\|");
            for (String par : pares) {
                String[] t = par.split(":");
                if (t.length == 2) {
                    try {
                        String talla = t[0];
                        int cantidad = Integer.parseInt(t[1]);
                        tallas.put(talla, cantidad);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al leer cantidad en: " + par);
                    }
                }
            }
        }

        System.out.println("Producto modificado:");
        System.out.println(producto);
    }
}