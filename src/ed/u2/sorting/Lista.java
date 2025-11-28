package ed.u2.sorting;

// Lista enlazada simple (SLL)
public class Lista {
    private Nodo head;

    public Lista() {
        head = null;
    }

    // Agrega al final
    public void pushBack(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (head == null) {
            head = nuevo;
            return;
        }
        Nodo actual = head;
        while (actual.sig != null)
            actual = actual.sig;
        actual.sig = nuevo;
    }

    public int size() {
        int c = 0;
        Nodo actual = head;
        while (actual != null) {
            c++;
            actual = actual.sig;
        }
        return c;
    }

    public Nodo getHead() {
        return head;
    }
}