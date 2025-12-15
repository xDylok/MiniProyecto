package ed.u2;

import ed.u2.model.*;
import ed.u2.sorting.*;
import ed.u2.search.Busqueda;
import java.util.Arrays;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainProyecto {

    private static final Scanner in = new Scanner(System.in);
    private static final int REPS = 10;      // nro de repeticiones
    private static final int CALENTAMIENTO = 3;  // primeras corridas a descartar

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n".repeat(2));
            System.out.println(SortingUtils.C_AMARILLO +
                    "================ | SISTEMA VETERINARIO - MENU | ================" +
                    SortingUtils.C_RESET);
            System.out.println("| ~ 1. " + SortingUtils.C_VERDE + "Ejecucion automatica" + SortingUtils.C_RESET);
            System.out.println("| ~ 2. " + SortingUtils.C_VERDE + "Probar Busquedas" + SortingUtils.C_RESET);
            System.out.println("| ~ 3. " + SortingUtils.C_ROJO + "Salir");
            System.out.print(SortingUtils.C_AZUL + "| > Seleccione una opcion: " + SortingUtils.C_RESET);

            try {
                String input = in.nextLine();
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> ejecutarEstadisticas();
                case 2 -> ejecutarInteractivo();
                case 3 -> System.out.println(SortingUtils.C_ROJO + "| ~ Saliendo del sistema, bendiciones abundantes" + SortingUtils.C_RESET);
                default -> System.out.println(SortingUtils.C_ROJO + "| ~ Opcion invalida" + SortingUtils.C_RESET);
            }
        } while (opcion != 3);

    }
    public static void ejecutarEstadisticas() {
        try {
            SortContadores statsBubble = null;
            SortContadores statsAgenda = null;
            SortContadores statsInventario = null;

            System.out.println(SortingUtils.C_AMARILLO +
                    "\n=================" +
                    " | Experimentos (Repeticiones: " + REPS + ", Calentamiento:" + CALENTAMIENTO + ") | " +
                    "=================" +
                    SortingUtils.C_RESET);
            // modulo citas
            System.out.println("\n" + SortingUtils.C_AMARILLO + "------------ | Modulo A: Citas | ------------" + SortingUtils.C_RESET);
            Cita[] citasOriginal = ArchivosCSV.leerCitas("citas_100.csv");
            System.out.println("> Cargadas " + SortingUtils.C_CELESTE + citasOriginal.length + SortingUtils.C_RESET + " citas.");

            // 10 corridas bubblesort
            System.out.print(SortingUtils.C_VERDE + "\t| - BubbleSort (" + REPS + " corridas)" + SortingUtils.C_RESET);
            long[] tiemposBubble = new long[REPS];
            for (int i = 0; i < REPS; i++) {
                Cita[] copia = citasOriginal.clone(); // clona
                statsBubble = BubbleSort.sort(copia, false);
                tiemposBubble[i] = statsBubble.tiempoNano;
            }
            long medianaBubble = calcularMediana(tiemposBubble);
            statsBubble.tiempoNano = medianaBubble;
            System.out.println(" | Mediana: " + medianaBubble + " ns");


            // 10 corridas insertionSOrt
            System.out.print(SortingUtils.C_VERDE + "\t| - InsertionSort (" + REPS + " corridas)" + SortingUtils.C_RESET);
            long[] tiemposInsertion = new long[REPS];
            Cita[] citasOrdenadasFinal = null;

            for (int i = 0; i < REPS; i++) {
                Cita[] copia = citasOriginal.clone();
                statsAgenda = InsertionSort.sort(copia, false);
                tiemposInsertion[i] = statsAgenda.tiempoNano;
                if (i == REPS - 1) citasOrdenadasFinal = copia;
            }
            long medianaInsertion = calcularMediana(tiemposInsertion);
            statsAgenda.tiempoNano = medianaInsertion;
            System.out.println(" | Mediana: " + medianaInsertion + " ns");


            // prueba de busqueda
            if (citasOrdenadasFinal != null) {
                int indexBusqueda = (citasOrdenadasFinal.length > 50) ? 50 : citasOrdenadasFinal.length - 1;
                Cita citaBusqueda = citasOrdenadasFinal[indexBusqueda];
                System.out.println("\tBuscando cita del: " + SortingUtils.C_CELESTE + citaBusqueda.fechaHora);

                long t1 = System.nanoTime();
                int indice = Busqueda.binarySearch(citasOrdenadasFinal, citaBusqueda);
                long t2 = System.nanoTime();

                if (indice != -1) System.out.println("\t" + SortingUtils.C_AZUL + "> Encontrada en indice: " + SortingUtils.C_ROJO + indice + " | Tiempo: " + (t2 - t1) + " ns" + SortingUtils.C_RESET);
                else System.out.println("\t" + SortingUtils.C_ROJO + "| - No encontrada" + SortingUtils.C_RESET);
            }
            // modulo b: pacientes
            System.out.println("\n" + SortingUtils.C_AMARILLO + "------------ | Modulo B: Pacientes | ------------" + SortingUtils.C_RESET);
            Paciente[] arrayPacientes = ArchivosCSV.leerPacientes("pacientes_500.csv");
            ListaPacientes listaPacientes = new ListaPacientes();
            for (Paciente p : arrayPacientes) listaPacientes.add(p);
            System.out.println("> SLL Cargada (" + arrayPacientes.length + " ptes).");

            System.out.print(SortingUtils.C_VERDE + "\tBenchmark Busqueda Lineal (" + REPS + " corridas)" + SortingUtils.C_RESET);
            long[] tiemposBusquedaB = new long[REPS];
            List<Paciente> criticos = null;

            for (int i = 0; i < REPS; i++) {
                long inicio = System.nanoTime();
                criticos = listaPacientes.buscarTodosPrioridad(1);
                long fin = System.nanoTime();
                tiemposBusquedaB[i] = (fin - inicio);
            }
            long medianaB = calcularMediana(tiemposBusquedaB);

            System.out.println(" | Mediana: " + medianaB + " ns");
            System.out.println(SortingUtils.C_VERDE + "\t > Encontrados: " + SortingUtils.C_ROJO + (criticos != null ? criticos.size() : 0) + SortingUtils.C_RESET);

            if (criticos != null && !criticos.isEmpty()) {
                System.out.println(SortingUtils.C_AZUL + "\tEjemplo: " + SortingUtils.C_ROJO + criticos.get(0));
            }


            // modulo c: inventario
            System.out.println("\n" + SortingUtils.C_AMARILLO + "------------ | Modulo C: Inventario | ------------" + SortingUtils.C_RESET);
            Item[] itemsOriginal = ArchivosCSV.leerInventario("inventario_500_inverso.csv");
            System.out.println("> Cargados " + SortingUtils.C_CELESTE + itemsOriginal.length + SortingUtils.C_RESET + " items.");

            // 10 corridas selectionSort
            System.out.print(SortingUtils.C_VERDE + "\t| - SelectionSort (" + REPS + " corridas)" + SortingUtils.C_RESET);
            long[] tiemposSelection = new long[REPS];
            Item[] itemsOrdenadosFinal = null;

            for (int i = 0; i < REPS; i++) {
                Item[] copia = itemsOriginal.clone();
                statsInventario = SelectionSort.sort(copia, false);
                tiemposSelection[i] = statsInventario.tiempoNano;
                if (i == REPS - 1) itemsOrdenadosFinal = copia;
            }
            long medianaSelection = calcularMediana(tiemposSelection);
            statsInventario.tiempoNano = medianaSelection;
            System.out.println(" | Mediana: " + medianaSelection + " ns");

            // busqueda
            if (itemsOrdenadosFinal != null) {
                Item itemBuscado = itemsOrdenadosFinal[itemsOrdenadosFinal.length - 1];
                System.out.println("\tBuscando item: " + SortingUtils.C_ROJO + itemBuscado.insumo);
                int idx = Busqueda.binarySearch(itemsOrdenadosFinal, itemBuscado);
                if (idx != -1) System.out.println(SortingUtils.C_AZUL + "\t> Encontrado en indice: " + SortingUtils.C_ROJO + idx + SortingUtils.C_RESET);
            }


            // tabla final
            System.out.println("\n" + SortingUtils.C_AMARILLO + "=".repeat(85));
            System.out.println("\t\t\t\tResumen final (Mediana de " + (REPS - CALENTAMIENTO) + " corridas validas)");
            System.out.println("=".repeat(85) + SortingUtils.C_RESET);

            // Encabezado
            System.out.printf("| %-15s | %-15s | %-12s | %-10s | %-15s |\n",
                    "Modulo", "Algoritmo", "Comparacion", "Swaps", "Tiempo (ns)");
            System.out.println("-".repeat(85));

            if (statsBubble != null) {
                System.out.printf("| %-15s | %-15s | %-12d | %-10d | %-15d |\n",
                        "A: Citas", "BubbleSort", statsBubble.comparaciones, statsBubble.swaps, statsBubble.tiempoNano);
            }
            if (statsAgenda != null) {
                System.out.printf("| %-15s | %-15s | %-12d | %-10d | %-15d |\n",
                        "A: Citas", "InsertionSort", statsAgenda.comparaciones, statsAgenda.swaps, statsAgenda.tiempoNano);
            }
            if (statsInventario != null) {
                System.out.printf("| %-15s | %-15s | %-12d | %-10d | %-15d |\n",
                        "C: Inventario", "SelectionSort", statsInventario.comparaciones, statsInventario.swaps, statsInventario.tiempoNano);
            }

            System.out.println("-".repeat(85));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ejecutarInteractivo() {
        try {
            // carga y ordena
            Paciente[] arrayPaciente = ArchivosCSV.leerPacientes("pacientes_500.csv");
            ListaPacientes listaPacientes = new ListaPacientes();
            for (Paciente p : arrayPaciente) listaPacientes.add(p);

            Item[] items = ArchivosCSV.leerInventario("inventario_500_inverso.csv");
            // usa una copia para centinela pq desordena y otra ordenada para binaria
            Item[] itemsBinaria = items.clone();
            SelectionSort.sort(itemsBinaria, false);

            boolean volver = false;
            while (!volver) {
                System.out.println("\n\n" + SortingUtils.C_AMARILLO +
                        "================ | SUBMENU BUSQUEDAS | ================" +
                        SortingUtils.C_RESET);
                System.out.println(SortingUtils.C_CELESTE + "\t| >>> DATOS CARGADOS <<<2 | " + SortingUtils.C_RESET);
                System.out.println("| ~ 1. " + SortingUtils.C_VERDE + "Pacientes: Buscar primer Apellido (findFirst)" + SortingUtils.C_RESET);
                System.out.println("| ~ 2. " + SortingUtils.C_VERDE + "Pacientes: Buscar ultimo Apellido (findLast)" + SortingUtils.C_RESET);
                System.out.println("| ~ 3. " + SortingUtils.C_VERDE + "Inventario: Buscar por Stock (Binaria - Array Ordenado)" + SortingUtils.C_RESET);
                System.out.println("| ~ 4. " + SortingUtils.C_VERDE + "Inventario: Buscar por Stock (Centinela - Array Desordenado)" + SortingUtils.C_RESET);
                System.out.println("| ~ 5. " + SortingUtils.C_VERDE + "Volver" + SortingUtils.C_RESET);
                System.out.print(SortingUtils.C_AZUL + "| > Seleccione una opcion: " + SortingUtils.C_RESET);

                String entrada = in.nextLine();
                switch (entrada) {
                    case "1": // findFisrt
                        System.out.print(SortingUtils.C_CELESTE + "| ~ Apellido a buscar: " + SortingUtils.C_RESET);
                        String apellido1 = in.nextLine();
                        Paciente paciente1 = listaPacientes.buscarPrimerApellido(apellido1);
                        if (paciente1 != null)
                            System.out.println(SortingUtils.C_AZUL + "| - Encontrado (Primero): " + SortingUtils.C_RESET + paciente1);
                        else System.out.println(SortingUtils.C_ROJO + "| - No encontrado" + SortingUtils.C_RESET);
                        break;

                    case "2": // findLast)
                        System.out.print(SortingUtils.C_CELESTE + "| ~ Apellido a buscar: ");
                        String apellido2 = in.nextLine();
                        Paciente paciente2 = listaPacientes.buscarUltimoApellido(apellido2);
                        if (paciente2 != null)
                            System.out.println(SortingUtils.C_AZUL + "| - Encontrado (Ultimo): " + SortingUtils.C_RESET + paciente2);
                        else System.out.println(SortingUtils.C_ROJO + "| - No encontrado" + SortingUtils.C_RESET);
                        break;

                    case "3": // binaria
                        buscarInventarioBinaria(itemsBinaria);
                        break;

                    case "4": // centinela
                        // usa el array original <<items>> que no este ordenado
                        buscarInventarioCentinela(items);
                        break;

                    case "5":
                        volver = true;
                        break;
                    default:
                        System.out.println(SortingUtils.C_ROJO + "| - Opcion invalida" + SortingUtils.C_RESET);
                }
            }
        } catch (IOException e) {
            System.out.println(SortingUtils.C_ROJO + "| - Error archivos: " + e.getMessage() + SortingUtils.C_RESET);
        }
    }

    private static void buscarInventarioBinaria(Item[] items) {
        System.out.print(SortingUtils.C_AMARILLO + "| ~ Stock a buscar (Binaria): " + SortingUtils.C_RESET);
        try {
            int stock = Integer.parseInt(in.nextLine());
            Item item = new Item("", "", stock);
            int indice = Busqueda.binarySearch(items, item);
            if (indice != -1)
                System.out.println(SortingUtils.C_AZUL + "| - Encontrado en el indice [" + indice + "]: " + items[indice] + SortingUtils.C_RESET);
            else System.out.println(SortingUtils.C_ROJO + "| - No encontrado" + SortingUtils.C_RESET);
        } catch (Exception e) {
            System.out.println(SortingUtils.C_ROJO + "| - Numero invalido" + SortingUtils.C_RESET);
        }
    }

    private static void buscarInventarioCentinela(Item[] items) {
        System.out.print(SortingUtils.C_AMARILLO + "| ~ Stock a buscar (Centinela): " + SortingUtils.C_RESET);
        try {
            int stock = Integer.parseInt(in.nextLine());
            Item item = new Item("", "", stock);
            // llama al metodo centinela
            int indice = Busqueda.secuencialCentinela(items, item);

            if (indice != -1)
                System.out.println(SortingUtils.C_AZUL + "| - Encontrado en indice [" + indice + "]: " + items[indice] + SortingUtils.C_RESET);
            else System.out.println(SortingUtils.C_ROJO + "| - No encontrado." + SortingUtils.C_RESET);
        } catch (Exception e) {
            System.out.println(SortingUtils.C_ROJO + "| - Numero invalido" + SortingUtils.C_RESET);
        }
    }
    private static long calcularMediana(long[] tiempos) {
        // valida que haya suficientes datos
        if (tiempos.length <= CALENTAMIENTO) return 0;
        // copia solo las corridas validas; descargta las priemras 3
        long[] validos = new long[tiempos.length - CALENTAMIENTO];
        System.arraycopy(tiempos, CALENTAMIENTO, validos, 0, validos.length);
        // ordena los tiempos para hallar la mediana
        Arrays.sort(validos);
        // calcula la media
        int mitad = validos.length / 2;
        if (validos.length % 2 == 1) {
            return validos[mitad]; // impar
        } else {
            return (validos[mitad - 1] + validos[mitad]) / 2; // par
        }
    }
}