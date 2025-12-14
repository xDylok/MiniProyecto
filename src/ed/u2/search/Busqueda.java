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
    public static <T extends Comparable<T>> int secuencialCentinela(T[] datos, T clave) {
        if (datos == null || datos.length == 0) return -1;

        int n = datos.length;
        T ultimoBackup = datos[n - 1]; // 1. Guardamos el último real

        // Si el último es el que buscamos, retornamos de una vez
        if (ultimoBackup.compareTo(clave) == 0) return n - 1;

        // 2. Colocamos el centinela (la clave) al final
        datos[n - 1] = clave;

        int i = 0;
        // 3. Buscamos (sin verificar i < n, gracias al centinela)
        while (datos[i].compareTo(clave) != 0) {
            i++;
        }

        // 4. RESTAURAMOS el dato original (¡Muy importante!)
        datos[n - 1] = ultimoBackup;

        // 5. Verificamos si encontramos el centinela (i == n-1) o el dato real
        if (i < n - 1) {
            return i; // Encontrado antes del final
        } else {
            return -1; // Solo encontramos el centinela
        }
    }
}