package ed.u2;

import ed.u2.model.*;
import ed.u2.sorting.*;
import ed.u2.search.Busqueda;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainProyecto {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n".repeat(2));
            System.out.println(SortingUtils.C_AMARILLO +
                    "================ | SISTEMA VETERINARIO (SIVET) - MENU | ================" +
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
                case 3 -> System.out.println(SortingUtils.C_ROJO + "| ~ Saliendo del sistema" + SortingUtils.C_RESET);
                default -> System.out.println(SortingUtils.C_ROJO + "| ~ Opcion invalida" + SortingUtils.C_RESET);
            }
        } while (opcion != 3);

    }

    public static void ejecutarEstadisticas() {
        try {
            // variables para guardar las estadisticas de ordenamiento
            SortContadores statsAgenda = null;
            SortContadores statsInventario = null;

            System.out.println(SortingUtils.C_AMARILLO +
                    "\n=================" +
                    " | Mini Proyecto U2: Sistema Veterinario | " +
                    "=================" +
                    SortingUtils.C_RESET);

            // moduloa a: agenda(citas) - arrays + sort + binarysearch
            System.out.println("\n" + SortingUtils.C_AMARILLO +
                    "------------ | MODULO A: 100 CITAS | ------------" +
                    SortingUtils.C_RESET);

            Cita[] citas = ArchivosCSV.leerCitas("citas_100.csv");

            System.out.println("> Cargadas " + SortingUtils.C_CELESTE + citas.length + SortingUtils.C_RESET + " citas.");

            // 1. urdena usando insertionSort
            System.out.println(SortingUtils.C_VERDE + "\tCitas Ordenadas (InsertionSort)" + SortingUtils.C_RESET);

            // captura el resultado en 'statsAgenda' para la tabla final
            statsAgenda = InsertionSort.sort(citas, false);

            // 2. busca una fecha especifica
            int indexBusqueda = (citas.length > 50) ? 50 : citas.length - 1;
            Cita citaBusqueda = citas[indexBusqueda];

            System.out.println("\tBuscando cita del: " + SortingUtils.C_CELESTE + citaBusqueda.fechaHora);

            long timeInicio = System.nanoTime();
            int indice = Busqueda.binarySearch(citas, citaBusqueda);
            long timeFin = System.nanoTime();

            if (indice != -1) {
                System.out.println("\t" + SortingUtils.C_AZUL +
                        "> Encontrada en el indice: " + SortingUtils.C_ROJO + indice + SortingUtils.C_AZUL +
                        " | Tiempo Busqueda: " + SortingUtils.C_ROJO + (timeFin - timeInicio) + " ns" +
                        SortingUtils.C_RESET);
            } else {
                System.out.println("\t" + SortingUtils.C_ROJO +
                        "No encontrada" +
                        SortingUtils.C_RESET);
            }


            // modulo B: pacientes - SLL + linearsearch
            System.out.println("\n" + SortingUtils.C_AMARILLO +
                    "------------ | MODULO B: 500 PACIENTES | ------------" +
                    SortingUtils.C_RESET);

            Paciente[] arrayPacientes = ArchivosCSV.leerPacientes("pacientes_500.csv");

            // 1. convierte Array a ListaEnlazada
            System.out.print("> Cargada Lista Enlazada (SLL)");
            ListaPacientes listaPacientes = new ListaPacientes();
            for (Paciente p : arrayPacientes) {
                listaPacientes.add(p);
            }
            System.out.println(SortingUtils.C_CELESTE + " (" + arrayPacientes.length + " pacientes)" + SortingUtils.C_RESET);

            // 2. busqueda lineal
            System.out.println("\tBusqueda de pacientes con Prioridad 1 (Alta):");

            long tiempoInicioB = System.nanoTime();
            List<Paciente> criticos = listaPacientes.buscarTodosPrioridad(1);
            long tiempoFinB = System.nanoTime();

            System.out.println(SortingUtils.C_VERDE +
                    "\t > Total de pacientes encontrados: " + SortingUtils.C_ROJO + criticos.size() +
                    SortingUtils.C_RESET);
            System.out.println("\tTiempo de busqueda Lineal: " +
                    SortingUtils.C_ROJO + (tiempoFinB - tiempoInicioB) +
                    SortingUtils.C_RESET + " ns");

            if (!criticos.isEmpty()) {
                System.out.println(SortingUtils.C_AZUL +
                        "\tEjemplo: " + SortingUtils.C_ROJO + criticos.get(0));
            }

            // modulo C: inventario - arrays + sort + binarysearch
            System.out.println("\n" + SortingUtils.C_AMARILLO +
                    "------------ | MODULO C: INVENTARIO | ------------" +
                    SortingUtils.C_RESET);

            Item[] items = ArchivosCSV.leerInventario("inventario_500_inverso.csv");
            System.out.println("> Cargados " + SortingUtils.C_CELESTE +
                    items.length + SortingUtils.C_RESET + " items.");

            // 1. Ordenar
            System.out.println("\tInventario Ordenado(SelectionSort).");

            // captura el resultado en 'statsInventario'
            statsInventario = SelectionSort.sort(items, false);

            // 2. buscar item
            Item itemBuscado = items[items.length - 1]; // ultimo
            System.out.println("\tBuscando item: " + SortingUtils.C_ROJO + itemBuscado.insumo);

            long tiempoInicioC = System.nanoTime();
            int indiceItem = Busqueda.binarySearch(items, itemBuscado);
            long tiempoFinC = System.nanoTime();

            System.out.println(SortingUtils.C_AZUL + "\t> Item encontrado en el indice: " + SortingUtils.C_ROJO + indiceItem +
                    SortingUtils.C_AZUL + " | Tiempo: " + SortingUtils.C_ROJO + (tiempoFinC - tiempoInicioC) + SortingUtils.C_AZUL + " ns" + SortingUtils.C_RESET);


            // tabla resultadso
            System.out.println("\n" + SortingUtils.C_AMARILLO + "=".repeat(85));
            System.out.println("\t\tRESUMEN DE METRICAS DE ORDENAMIENTO (INSTRUMENTACION)");
            System.out.println("=".repeat(85) + SortingUtils.C_RESET);

            // Encabezado de la tabla
            System.out.printf("| %-15s | %-15s | %-12s | %-10s | %-15s |\n",
                    "Modulo", "Algoritmo", "Comparac.", "Swaps", "Tiempo Sort (ns)");
            System.out.println("-".repeat(85));

            // fila modulo A
            if (statsAgenda != null) {
                System.out.printf("| %-15s | %-15s | %-12d | %-10d | %-15d |\n",
                        "A: Citas", "InsertionSort", statsAgenda.comparaciones, statsAgenda.swaps, statsAgenda.tiempoNano);
            }

            // fila modulo C
            if (statsInventario != null) {
                System.out.printf("| %-15s | %-15s | %-12d | %-10d | %-15d |\n",
                        "C: Inventario", "SelectionSort", statsInventario.comparaciones, statsInventario.swaps, statsInventario.tiempoNano);
            }

            System.out.println("-".repeat(85));
            System.out.println(SortingUtils.C_CELESTE +
                    "* Nota: El Modulo B no usa ordenamiento ya que es SLL con Busqueda Lineal." +
                    SortingUtils.C_RESET);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ejecutarInteractivo() {
        try {
            // carga y ordena
            Paciente[] arrPac = ArchivosCSV.leerPacientes("pacientes_500.csv");
            ListaPacientes listaPacientes = new ListaPacientes();
            for (Paciente p : arrPac) listaPacientes.add(p);

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
}