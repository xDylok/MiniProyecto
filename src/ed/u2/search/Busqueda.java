package ed.u2.search;

public class Busqueda {

    /**
     * busqueda binaria generica iterativa.
     * El arreglo debe estar ordenado
     */
    public static <T extends Comparable<T>> int binarySearch(T[] datos, T clave) {
        if (datos == null || clave == null || datos.length == 0) {
            return -1;
        }
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

    public static <T extends Comparable<T>> int secuencialCentinela(T[] datos, T clave) {
        if (datos == null || datos.length == 0) return -1;

        int n = datos.length;
        T ultimoBackup = datos[n - 1]; // guarda el ultimo real
        // si el ultimo es el q se busca, lo retorna
        if (ultimoBackup.compareTo(clave) == 0) return n - 1;
        // coloca la centinala al final
        datos[n - 1] = clave;
        int i = 0;
        // busca sin verificar i<n
        while (datos[i].compareTo(clave) != 0) {
            i++;
        }
        // restaura el dato original
        datos[n - 1] = ultimoBackup;
        // verifica si se encontro el centinela o el dato real
        if (i < n - 1) {
            return i; // encuentra antes del final
        } else {
            return -1; // solo si encuentra el centinela
        }
    }

    //lowerBound: busca el primer elemento que es mayor o igual a la clave, sirve para encontrar el iniicio de un rango
    public static <T extends Comparable<T>> int lowerBound(T[] datos, T clave) {
        if (datos == null || datos.length == 0) return -1;
        int bajo = 0;
        int alto = datos.length;
        while (bajo < alto) {
            int mid = bajo + (alto - bajo) / 2;
            if (datos[mid].compareTo(clave) < 0) {
                bajo = mid + 1;
            } else {
                alto = mid;
            }
        }
        return bajo;
    }
    // upperBound: busca el primer elemento que es obligatoriamente mayor a la clave este para encontrar el fibnal de un rango.
    public static <T extends Comparable<T>> int upperBound(T[] datos, T clave) {
        if (datos == null || datos.length == 0) return -1;
        int bajo = 0;
        int alto = datos.length;
        while (bajo < alto) {
            int mid = bajo + (alto - bajo) / 2;
            if (datos[mid].compareTo(clave) <= 0) {
                bajo = mid + 1;
            } else {
                alto = mid;
            }
        }
        return bajo;
    }
}
