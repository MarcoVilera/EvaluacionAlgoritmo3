package ventana;
//@author MarcoVilera

public class ListaEnlazada {

    Nodo head;
    int size;

    public ListaEnlazada() {
        head = null;
        size = 0;
    }

    // Método para agregar un nodo al principio de la lista enlazada
    public void addFirst(int n) {
        // Si la lista está vacía, establece el nuevo nodo como la cabeza
        if (head == null) {
            head = new Nodo(n);
        } else {
            // Si la lista tiene elementos, crea un nuevo nodo y establece el siguiente nodo como el antiguo nodo de la cabeza
            Nodo temp = head;
            Nodo newHead = new Nodo(n);
            newHead.setNext(temp);
            head = newHead;
        }
        // Incrementa el tamaño de la lista
        size++;
    }

    // Método para obtener el valor de un nodo en una posición dada
    public int get(int index) {
        int cont = 0;
        Nodo temp = head;
        // Recorre la lista enlazada hasta llegar al índice deseado
        while (cont < index) {
            temp = temp.getSiguiente();
            cont++;
        }
        // Devuelve el valor del nodo en la posición deseada
        return temp.getValor();
    }

    // Método para eliminar un nodo en una posición dada
    public void delete(int index) {
        // Si se elimina el primer nodo, establece el siguiente nodo como la nueva cabeza
        if (index == 0) {
            head = head.getSiguiente();
        } else {
            /* Si se elimina un nodo diferente al primero,
            recorre la lista enlazada hasta llegar al nodo anterior al que se desea eliminar y enlaza ese nodo con el siguiente nodo
             */
            int cont = 0;
            Nodo temp = head;
            while (cont < index - 1) {
                temp = temp.getSiguiente();
                cont++;
            }
            temp.setNext(temp.getSiguiente().getSiguiente());
        }
        // Decrementa el tamaño de la lista
        size--;
    }

    //Método para ordenar de mayor a menor la lista
    public void sortMayor() {
        // Inicializar variables
        Nodo nodoActual = head; // Nodo actual que se está comparando en el bucle exterior
        boolean huboIntercambios = true; // Bandera que indica si se han hecho intercambios en la última iteración

        // Recorrer la lista mientras haya nodos que no estén ordenados y se hayan hecho intercambios en la última iteración
        while (nodoActual != null && huboIntercambios) {
            huboIntercambios = false;

            // Recorrer la lista comparando nodos adyacentes
            Nodo nodoAnterior = head; // Nodo anterior al nodo actual en el bucle interior
            while (nodoAnterior.getSiguiente() != null) {
                Nodo nodoSiguiente = nodoAnterior.getSiguiente(); // Nodo siguiente al nodo anterior en el bucle interior

                // Si el nodo anterior es menor que el nodo siguiente, intercambiar los nodos
                if (nodoAnterior.getValor() < nodoSiguiente.getValor()) {
                    // Intercambiar nodos
                    Nodo nodoTemporal = nodoAnterior.getSiguiente();
                    nodoAnterior.setNext(nodoSiguiente.getSiguiente());
                    nodoSiguiente.setNext(nodoAnterior);

                    // Actualizar referencias de los nodos involucrados en el intercambio
                    if (nodoAnterior == head) {
                        head = nodoSiguiente;
                    } else {
                        Nodo nodoAnteAnterior = head;
                        while (nodoAnteAnterior.getSiguiente() != nodoAnterior) {
                            nodoAnteAnterior = nodoAnteAnterior.getSiguiente();
                        }
                        nodoAnteAnterior.setNext(nodoSiguiente);
                    }
                    nodoAnterior = nodoSiguiente;
                    huboIntercambios = true;
                } else {
                    nodoAnterior = nodoSiguiente;
                }
            }

            // Mover al nodo siguiente para la próxima iteración
            nodoActual = nodoActual.getSiguiente();
        }
    }

    //Método para ordenar de menor a mayor la lista
    public void sortMenor() {
        // Inicializar variables
        Nodo nodoActual = head;
        boolean huboIntercambios = true;

        // Recorrer la lista mientras haya nodos que no estén ordenados y se hayan hecho intercambios en la última iteración
        while (nodoActual != null && huboIntercambios) {
            huboIntercambios = false;

            // Recorrer la lista comparando nodos adyacentes
            Nodo nodoAnterior = head;
            while (nodoAnterior.getSiguiente() != null) {
                Nodo nodoSiguiente = nodoAnterior.getSiguiente();

                // Si el nodo anterior es mayor que el nodo siguiente, intercambiar los nodos
                if (nodoAnterior.getValor() > nodoSiguiente.getValor()) {
                    // Intercambiar nodos
                    Nodo nodoTemporal = nodoSiguiente.getSiguiente();
                    nodoSiguiente.setNext(nodoAnterior);
                    nodoAnterior.setNext(nodoTemporal);
                    if (nodoAnterior == head) {
                        head = nodoSiguiente;
                    } else {
                        Nodo nodoAnteriorAnterior = head;
                        while (nodoAnteriorAnterior.getSiguiente() != nodoAnterior) {
                            nodoAnteriorAnterior = nodoAnteriorAnterior.getSiguiente();
                        }
                        nodoAnteriorAnterior.setNext(nodoSiguiente);
                    }
                    nodoAnterior = nodoSiguiente;
                    huboIntercambios = true;
                } else {
                    nodoAnterior = nodoSiguiente;
                }
            }

            // Mover al nodo siguiente para la próxima iteración
            nodoActual = nodoActual.getSiguiente();
        }
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        // Devuelve verdadero si la cabeza es nula, de lo contrario, devuelve falso
        return (head == null) ? true : false;
    }

    // Método para obtener el tamaño de la lista
    public int getSize() {
        return size;
    }

}
