package ventana;
//@author MarcoVilera

public class Nodo {

    private double valor;
    private Nodo siguiente;

    public Nodo(double n) {
        valor = n;
        siguiente = null;
    }

    // Método para establecer el siguiente nodo en la lista enlazada
    public void setNext(Nodo n) {
        siguiente = n;
    }

    // Método para obtener el valor del nodo
    public double getValor() {
        return valor;
    }

    // Método para obtener el siguiente nodo en la lista enlazada
    public Nodo getSiguiente() {
        return siguiente;
    }
}
