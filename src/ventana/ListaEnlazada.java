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
    public void addFirst(double n) {
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
    public double get(int index) {
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
