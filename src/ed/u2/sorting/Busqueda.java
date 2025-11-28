package ed.u2.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Busqueda {
    // busca la primera ocurrencia dentro de un array
    public static int indexOfFirst(int[] a, int key) {
        if (a == null || a.length == 0) return -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
    // busca la ultima ocurrencia dentro de un array
    public static int indexOfLast(int[] a, int key) {
        if (a == null || a.length == 0) return -1;
        //recorrido inverso
        for (int i = a.length-1; i >= 0 ; i--) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
    // busca la primera ocurrencia en una SLLL
    public static Nodo findFirst(Nodo head, int key) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.valor == key) {
                return actual; // retorna el nodo apenas lo encuentra
            }
            actual = actual.sig; // Avanza al siguiente nodo
        }
        return null; // no encuentra
    }
    // busca la ultima ocurrencia  en una SLL recorriendo toda la lista pq no se puede en inversa
    public static Nodo findLast(Nodo head, int key) {
        Nodo ultimoVisto = null;
        Nodo actual = head;
        while (actual != null) {
            if (actual.valor == key) {
                ultimoVisto = actual;
            }
            actual = actual.sig;
        }
        return ultimoVisto;
    }

    // encuentra todos los indices en un array que cumplen una condicion
    public static List<Integer> findAll(int[] a, IntPredicate pred) {
        List<Integer> indices = new ArrayList<>();
        if (a == null) return indices;

        for (int i = 0; i < a.length; i++) {
            if (pred.test(a[i])) { // comprueba si el num pasa la prueba de predicado
                indices.add(i);
            }
        }
        return indices;
    }

    // encuentra todos los nodos en una SLL q cumplen la condicion
    public static List<Nodo> findAll(Nodo head, Predicate<Nodo> pred) {
        List<Nodo> nodosEncontrados = new ArrayList<>();
        Nodo actual = head;

        while (actual != null) {
            // evalua el NODO completo con el predicado
            if (pred.test(actual)) {
                nodosEncontrados.add(actual);
            }
            actual = actual.sig;
        }
        return nodosEncontrados;
    }
    // busqueda secuencial cin centinela
    // reduce el num de comparaciones del bucle eliminando el chequeo de limites
    public static int searchSequentialSentinel(int[] a, int key) {
        if (a == null || a.length == 0) return -1;

        int n = a.length;
        int last = a[n - 1]; // 1. Guardar el ultimo elemento original
        a[n - 1] = key;      // 2. Poner el centinela al final

        int i = 0;
        // 3. Bucle sin chequeo de límites (i < n), solo buscamos la clave
        while (a[i] != key) {
            i++;
        }
        a[n - 1] = last; // 4. Restaurar el ultimo elemento
        // 5. Verificar si lo encontramos de verdad o fue el centinela
        if (i < n - 1 || a[n - 1] == key)
            return i;
        return -1;
    }
    // busqueda binaria iteraticva, condicion: array ordenado ascendentemente
    public static int binaria(int[] a, int key) {
        if (a == null || a.length == 0) {
            return -1; // Caso borde: array vacío o null
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Evita overflow en arrays grandes
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Opcional: lowerBound - Retorna el indice de la primera ocurrencia del key
    public static int lowerBound(int[] a, int key) {
        if (a == null || a.length == 0) {
            return 0; // Posición de inserción en vacío
        }
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Opcional: upperBound - Retorna el índice después de la ultima ocurrencia del key
    public static int upperBound(int[] a, int key) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Metodo para validar si el array está ordenado (precondición)
    public static boolean estaOrdenado(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }
    // ordena el array ascendentemente
    public static void sort(int[] a) {
        if (a != null) {
            java.util.Arrays.sort(a);
        }
    }
}























