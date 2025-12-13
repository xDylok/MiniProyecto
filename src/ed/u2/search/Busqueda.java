package ed.u2.search;

public class Busqueda {

    /**
     * busqueda binaria generica iterativa.
     * El arreglo debe estar ordenado
     */
    public static <T extends Comparable<T>> int binarySearch(T[] datos, T clave) {
        int low = 0;
        int high = datos.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = datos[mid].compareTo(clave);

            if (cmp == 0) {
                return mid; // encontrado
            } else if (cmp < 0) {
                low = mid + 1; // esta en la mitad derecha
            } else {
                high = mid - 1; // esta en la mitad izquierda
            }
        }
        return -1; // no encontrado
    }

    // encuentra el primer elemento que sea mayor o igual a la clave
    public static <T extends Comparable<T>> int lowerBound(T[] datos, T clave) {
        int low = 0;
        int high = datos.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (datos[mid].compareTo(clave) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // encuentra el primer elemento que sea estrictamente mayor a la clave
    public static <T extends Comparable<T>> int upperBound(T[] datos, T clave) {
        int low = 0;
        int high = datos.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (datos[mid].compareTo(clave) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}