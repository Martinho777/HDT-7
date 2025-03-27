import java.io.*;
import java.util.*;

public class LectorCSV {

    public static List<Producto> leerArchivo(String nombreArchivo) {
        List<Producto> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Ignorar líneas vacías

                String[] partes = linea.split(",", 4);
                if (partes.length < 4) continue; // línea inválida

                String sku = partes[0].trim();
                String nombre = partes[1].trim();
                String descripcion = partes[2].trim();
                String tallasRaw = partes[3].trim();

                Map<String, Integer> tallas = new HashMap<>();
                String[] paresTalla = tallasRaw.split("\\|");
                for (String par : paresTalla) {
                    String[] t = par.split(":");
                    if (t.length == 2) {
                        tallas.put(t[0], Integer.parseInt(t[1]));
                    }
                }

                Producto producto = new Producto(sku, nombre, descripcion, tallas);
                productos.add(producto);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return productos;
    }
}
