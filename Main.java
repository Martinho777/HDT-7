public class Main {
    public static void main(String[] args) {
        List<Producto> productos = LectorCSV.leerArchivo("inventario.csv");

        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}
