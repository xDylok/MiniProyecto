# Mini-Proyecto U2: Sistema Veterinario

---

Implementacion integral de algoritmos de **Ordenamiento** (Insertion, Selection) y **Busqueda** (Binaria, Secuencial, Centinela) aplicados a un contexto real de gestion veterinaria. El sistema combina estructuras estaticas (Arrays) y dinamicas (Listas Enlazadas - SLL), integrando instrumentacion cientifica para la medicion del rendimiento.

**Autores:**
* **Jostin Vasquez**
* **Miguel Veintimilla**
* **Darwin Correa**
* **Wilson Palma**

---

## Ejecucion del Proyecto

1.  **Clonar el repositorio:** Asegurarse de tener los archivos `.csv` en la carpeta correcta.
2.  **Verificar Entorno:** JDK 17 o superior. No requiere librerias externas.
3.  **Ejecutar:**
    * **Clase Principal:** `src/ed/u2/MainProyecto.java`
    * **Flujo:** El programa iniciara un **Menu Interactivo** en consola.
4.  **Opciones del Menu:**
    * **Opcion 1 (Modo Reporte):** Ejecuta un benchmark automatico, valida los algoritmos y genera tablas de rendimiento.
    * **Opcion 2 (Modo Interactivo):** Permite al usuario buscar pacientes o items manualmente para probar la robustez de las busquedas.

---

## Arquitectura y Funcionalidades

### 1. Motor de Busqueda (`ed.u2.search.Busqueda`)
Implementacion **Generica (`<T>`)** para reutilizacion de codigo:
* `binarySearch(T[] datos, T clave)`: Busqueda logaritmica O(log n). Incluye **blindaje contra nulos** y arrays vacios.
* `secuencialCentinela(T[] datos, T clave)`: Optimizacion que reduce comparaciones en el bucle al eliminar la verificacion de limites.
* `lowerBound` / `upperBound`: Algoritmos para busquedas por rangos.

### 2. Estructuras de Datos (`ed.u2.model`)
* **Modulo Pacientes (SLL):** Se implemento una **Lista Simplemente Enlazada** (`ListaPacientes`) manual (sin usar `java.util.LinkedList`).
    * `buscarPrimerApellido`: Encuentra la primera coincidencia (O(n)).
    * `buscarUltimoApellido`: Recorre toda la lista para hallar la ultima coincidencia.
    * `buscarTodosPrioridad`: Retorna una sub-lista con todos los pacientes que coinciden con el criterio.
* **Modelos:** Clases `Cita`, `Item`, `Paciente` implementando `Comparable<T>` para permitir el ordenamiento natural.

### 3. Algoritmos de Ordenamiento (`ed.u2.sorting`)
Instrumentados con `SortContadores` para medir comparaciones, swaps y tiempo real.
* **InsertionSort:** Usado en Agenda (Citas) por su eficiencia en datos casi ordenados.
* **SelectionSort:** Usado en Inventario para minimizar escrituras (swaps) en memoria.

---

## Analisis y Conclusiones Tecnicas

1.  **Eficiencia en Busquedas:**
    * La **Busqueda Binaria** (Modulos A y C) demostro ser drasticamente mas rapida que la lineal, pero impuso la precondicion obligatoria de mantener los arrays ordenados (O(n log n) previo).
    * En el Modulo B (Pacientes), la **Busqueda Lineal** fue la unica opcion viable debido a la naturaleza secuencial de la Lista Enlazada (acceso no aleatorio).

2.  **Manejo de Casos Borde (Robustez):**
    * Se implemento "blindaje" en el `Main` para evitar caidas (`Crash`) si los archivos CSV estan vacios o tienen menos datos de los esperados.
    * Las busquedas manejan referencias `null` y elementos no encontrados devolviendo `-1` o `null` de forma segura.

3.  **Justificacion de Estructuras:**
    * **Listas Enlazadas (SLL):** Ideales para el modulo de Pacientes donde la insercion y eliminacion dinamica es frecuente, evitando el redimensionamiento costoso de los arrays.
    * **Arrays Estaticos:** Ideales para Citas e Inventario donde la velocidad de acceso por indice es critica para la Busqueda Binaria.

---

## Resultados (Evidencia de Ejecucion)

Los siguientes datos fueron obtenidos mediante la instrumentacion en el **Modo Reporte**:

### 1. Resumen de Metricas de Ordenamiento
| Modulo | Algoritmo | Comparaciones | Swaps | Tiempo (ns) |
| :--- | :--- | :--- | :--- | :--- |
| **A: Citas** | InsertionSort | 2,245 | 2,148 | 155,400 |
| **C: Inventario** | SelectionSort | 124,750 | 250 | 6,706,600 |

*Nota: InsertionSort es superior en tiempo gracias a que el dataset de citas llega parcialmente ordenado. SelectionSort muestra un alto costo temporal por su complejidad cuadratica fija, pero mantiene los swaps bajos.*

### 2. Pruebas de Busqueda (Casos de Exito)

| Modulo | Tipo Busqueda | Estructura | Caso de Prueba | Resultado |
| :--- | :--- | :--- | :--- | :--- |
| **A: Citas** | Binaria | Array | Fecha indice 50 | **Encontrado** (Tiempo < 1000ns) |
| **B: Pacientes** | Lineal (findAll) | SLL | Prioridad 1 | **Encontrados: N** (Recorrido completo) |
| **C: Inventario** | Binaria | Array | Ultimo Elemento | **Encontrado** (Indice correcto) |

### 3. Validacion de Casos Borde
* **Archivo Vacio:** El sistema detecta `length == 0` y salta el modulo sin lanzar excepcion.
* **Elemento Inexistente:** Retorna mensaje visual "No encontrado" en lugar de error.
* **Input de Usuario:** El menu valida entradas numericas para evitar `NumberFormatException`.