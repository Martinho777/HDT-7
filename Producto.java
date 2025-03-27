import java.util.Map;

public class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private Map<String, Integer> tallas;

    public Producto(String sku, String nombre, String descripcion, Map<String, Integer> tallas) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallas = tallas;
    }

    // Getters y Setters

    public String getSku() { return sku; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public Map<String, Integer> getTallas() { return tallas; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTallas(Map<String, Integer> tallas) {
        this.tallas = tallas;
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Nombre: " + nombre + ", Descripción: " + descripcion + ", Tallas: " + tallas.toString();
    }
}
