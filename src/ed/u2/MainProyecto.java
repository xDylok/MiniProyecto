package ed.u2;

import ed.u2.model.*;
import ed.u2.sorting.*;
import ed.u2.search.Busqueda;
import java.io.IOException;
import java.util.List;

public class MainProyecto {
    public static void main(String[] args) {
        try {
            // variables para guardar las estadisticas de ordenamiento
            SortContadores statsAgenda = null;
            SortContadores statsInventario = null;

            System.out.println(SortingUtils.C_AZUL +
                    "=================" +
                    " | Mini Proyecto U2: Sistema Veterinario | "+
                    "=================" +
                    SortingUtils.C_RESET);

            // moduloa a: agenda(citas) - arrays + sort + binarysearch
            System.out.println("\n" + SortingUtils.C_AMARILLO +
                    "------------ | MODULO A: 100 CITAS | ------------" +
                    SortingUtils.C_RESET);

            Cita[] citas = ArchivosCSV.leerCitas("citas_100.csv");

            System.out.println("> Cargadas " + SortingUtils.C_CELESTE + citas.length + SortingUtils.C_RESET +" citas.");

            // 1. urdena usando insertionSort
            System.out.println(SortingUtils.C_VERDE +"\tCitas Ordenadas (InsertionSort)" + SortingUtils.C_RESET);

            // captura el resultado en 'statsAgenda' para la tabla final
            statsAgenda = InsertionSort.sort(citas, false);

            // 2. busca una fecha especifica
            Cita citaBusqueda = citas[50];

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
                    SortingUtils.C_RESET +" ns");

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
                    items.length + SortingUtils.C_RESET +" items.");

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

            System.out.println(SortingUtils.C_AZUL + "\t> Item encontrado en el indice: " +SortingUtils.C_ROJO + indiceItem +
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
}