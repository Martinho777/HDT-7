public class BinaryTree<K extends Comparable<K>, V> {

    private class Nodo {
        K clave;
        V valor;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }
    private Nodo raiz;

    // Insertar
    public void insertar(K clave, V valor) {
        raiz = insertarRec(raiz, clave, valor);
    }

    private Nodo insertarRec(Nodo actual, K clave, V valor) {
        if (actual == null) {
            return new Nodo(clave, valor);
        }

        int comparacion = clave.compareTo(actual.clave);
        if (comparacion < 0) {
            actual.izquierdo = insertarRec(actual.izquierdo, clave, valor);
        } else if (comparacion > 0) {
            actual.derecho = insertarRec(actual.derecho, clave, valor);
        } else {
            // Si ya existe actualizamos el valor
            actual.valor = valor;
        }

        return actual;
    }

    // Buscar
    public V buscar(K clave) {
        Nodo actual = raiz;
        while (actual != null) {
            int comparacion = clave.compareTo(actual.clave);
            if (comparacion == 0) {
                return actual.valor;
            } else if (comparacion < 0) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }
        return null; // no encontrado
    }

    // Recorrido inorder
    public void inOrder() {
        inOrderRec(raiz);
    }

    private void inOrderRec(Nodo nodo) {
        if (nodo != null) {
            inOrderRec(nodo.izquierdo);
            System.out.println(nodo.valor);
            inOrderRec(nodo.derecho);
        }
    }
}
