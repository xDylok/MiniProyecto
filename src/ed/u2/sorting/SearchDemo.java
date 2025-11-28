package ed.u2.sorting;

import java.util.Arrays;
import java.util.List;

public class SearchDemo {

    public static void main(String[] args) {
        System.out.println(SortingUtils.C_AZUL +
                "TALLER 7 - DEMO COMPLETO" +
                SortingUtils.C_RESET + "\n");

        System.out.println(SortingUtils.C_AMARILLO +
                "1. PRUEBAS ESTÁNDAR (Secuencial vs Centinela)" +
                SortingUtils.C_RESET);
        formatoEncabezado();

        testSequential(SortingUtils.getDataSetA(), "Set A (Random)", 3); // repetido
        testSequential(SortingUtils.getDataSetB(), "Set B (Inverso)", 4);
        testSequential(SortingUtils.getDataSetE(), "Set E (Random)", 9); // al inicio


        System.out.println("\n" + SortingUtils.C_AMARILLO +
                "2. PRUEBAS BINARIA (Con Auto-Ordenamiento)" +
                SortingUtils.C_RESET);
        formatoEncabezado();

        // Set C: Ya está ordenado
        testBinary(SortingUtils.getDataSetC(), "Set C (Ordenado)", 4);

        // Set J: Fallará primero, se ordenará y buscará de nuevo
        testBinary(SortingUtils.getDataSetJ(), "Set J (Casi Ord)", 10);

        // Set K: Fallará primero, se ordenará y buscará de nuevo
        testBinary(SortingUtils.getDataSetK(), "Set K (Casi Ord)", 1);


        // CASOS BORDE
        System.out.println("\n" + SortingUtils.C_AMARILLO +
                "3. CASOS BORDE" +
                SortingUtils.C_RESET);
        formatoEncabezado();

        // F: vacio
        testSequential(SortingUtils.getDataSetF(), "Set F (Vacio)", 5);

        // G: un elemento
        testSequential(SortingUtils.getDataSetG(), "Set G (Uno Solo)", 2); // Existe
        testSequential(SortingUtils.getDataSetG(), "Set G (Uno Solo)", 5); // No existe


        // DUPLICADOS Y TIPOS DE DATOS
        System.out.println("\n" + SortingUtils.C_AMARILLO +
                "4. TIPOS DE DATOS Y DUPLICADOS" +
                SortingUtils.C_RESET);
        formatoEncabezado();

        // D: todos iguales
        int[] d = SortingUtils.getDataSetD();
        formatoFila("Set D (Duplics)", Arrays.toString(d), 2, "First Occur", Busqueda.indexOfFirst(d, 2));
        formatoFila("Set D (Duplics)", Arrays.toString(d), 2, "Last Occur", Busqueda.indexOfLast(d, 2));

        // H: negatiovs
        testSequential(SortingUtils.getDataSetH(), "Set H (Negativos)", -8);

        // I: negativos y positivos
        testSequential(SortingUtils.getDataSetI(), "Set I (Mixtos)", 0);


        // ListasEnlazadas
        System.out.println("\n" + SortingUtils.C_AMARILLO +
                "5. LISTAS ENLAZADAS (SLL)" +
                SortingUtils.C_RESET);
        Lista sll = new Lista();
        sll.pushBack(3);
        sll.pushBack(1);
        sll.pushBack(3);
        sll.pushBack(2);

        System.out.println("Lista: 3 -> 1 -> 3 -> 2");
        Nodo first = Busqueda.findFirst(sll.getHead(), 3);
        Nodo last = Busqueda.findLast(sll.getHead(), 3);

        System.out.println("Find First (3): " + formatoNode(first));
        System.out.println("Find Last  (3): " + formatoNode(last));

        // Predicado: buscar negativos en una lista nueva
        Lista sllNegativos = new Lista();
        sllNegativos.pushBack(10);
        sllNegativos.pushBack(-5);
        sllNegativos.pushBack(20);
        System.out.print("Lista Neg: 10 -> -5 -> 20. Buscar negativos: ");
        List<Nodo> negs = Busqueda.findAll(sllNegativos.getHead(), n -> n.valor < 0);
        for (Nodo n : negs) System.out.print(formatoNode(n) + " ");
        System.out.println();
    }

    // metodos para formatear la saldia:

    private static void testSequential(int[] data, String name, int key) {
        // 1. Prueba Secuencial Normal
        int idx = Busqueda.indexOfFirst(data, key);
        formatoFila(name, contResumen(data), key, "Secuencial", idx);

        // 2. IMPLEMENTACIÓN AGREGADA: Prueba con Centinela (Requerido por PDF)
        int idxSent = Busqueda.searchSequentialSentinel(data, key);
        formatoFila("", "  (Idem)", key, "Centinela", idxSent);
    }

    private static void testBinary(int[] data, String name, int key) {
        if (Busqueda.estaOrdenado(data)) {
            int idx = Busqueda.binaria(data, key);
            formatoFila(name, contResumen(data), key, "Binaria", idx);
        } else {
            // reporta q no estaba ordenado
            formatoFila(name, contResumen(data), key, "Binaria", -999);
            // se ordena el array
            Busqueda.sort(data);
            // vuelve a buscar
            int idx = Busqueda.binaria(data, key);
            formatoFila(name + " [Sort]", contResumen(data), key, "Binaria+Sort", idx);
        }
    }

    private static String contResumen(int[] data) {
        if (data.length > 6) {
            return "| Tamaño data: " + data.length;
        }
        return Arrays.toString(data);
    }

    private static String formatoNode(Nodo n) {
        if (n == null) {
            return SortingUtils.C_ROJO + "null" + SortingUtils.C_RESET;
        }
        return SortingUtils.C_VERDE + "@" + Integer.toHexString(n.hashCode()) + "(val=" + n.valor + ")" + SortingUtils.C_RESET;
    }

    private static void formatoEncabezado() {
        System.out.printf("%-18s %-18s %-5s %-12s %-10s\n", "Dataset", "Contenido", "Key", "Metodo", "Resultado");
        System.out.println("------------------------------------------------------------------");
    }

    private static void formatoFila(String set, String contenido, int key, String metodo, int resultado) {
        String resultadoString;
        if (resultado == -999) {
            resultadoString = SortingUtils.C_ROJO + "NO ORDENADO" + SortingUtils.C_RESET;
        } else if (resultado == -1) {
            resultadoString = SortingUtils.C_ROJO + "-1 (No encontrado)" + SortingUtils.C_RESET;
        }
        else {
            resultadoString = SortingUtils.C_VERDE + resultado + SortingUtils.C_RESET;
        }
        System.out.printf("%-18s %-18s %-5d %-12s %s\n", set, contenido, key, metodo, resultadoString);
    }
}