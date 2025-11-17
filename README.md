# Taller - Ordenación	básica	en	Java:	Burbuja, Selección e Inserción - Estructura de Datos

---

Implementar y comparar tres algoritmos de ordenación in-place sobre arreglos pequeños, y validar su funcionamiento con trazas y casos de prueba reproducibles.


**Autores:**
* **Vasquez Calderon Jostin Xavier**
* **Maldonado Machuca Martina Alejandra**

---
## Ejecucion del proyecto:

1. Clonar el repositorio.
2. Abrir el proyecto en un IDE.
3. Ejecutar el archivo **SortingDemo.java**, dentro de este se encuentra el metodo *'main'*.
4. Aparecera un menu en la consola.
5. Seleccionar las opciones del 1 al 3 para ejecutar las pruebas de un algoritmo en específico,
6. Opcion 4 para salir.

---
## Desiciones de diseño:

* **Estructura del paquete:** Todo el codigo se encuentra en el paquete: `ed.u2.sorting`.
* **Clase `SortingUtils`:** Clase de utilidades la cual se encarga de:
    * Administrar los colores de la consola.
    * Gestionar los **dataSets de prueba**, entregando una copia `Arrays.copyOf()` cada vez que se solicita para evitar modificar los datos.
    * Contiene un "interruptor" global `HABILITAR_TRAZAS` para activar/desacticar las trazas del proyecto.
    * Metodo que formatea la salida.
* **Firmas y Sobrecarga:** Todos los algoritmos implementan dos firmas `sort()`.
    1. `sort(int[] arreglo)`: Firma estandar que llama a la version con trazas apagadas.
    2. `sort(int[] arreglo, boolean trace)`: Firma que contiene la logica de ordenacion e impreciones de traza.
* **Requsitos Especificos:** 
    * **`SelectionSort`:** Implementa contador `contSwaps` que se incrementa si `min != i`.
    * **`BubbleSort`:** Implementa unna bandera `boolean swapped` en cada pasada para permitir un corte temprano en caso de que el array ya este ordenado.
---
## Casos de prueba;
Se probaron los datasets requeridos mas los casos bordes solicitados, en donde se determino que los peores casos para *Insercion y Burbuja* son los arreglos en orden inverso `DataSet B` y el `DataSet C` fue necesario para probar el **Corte temprano** del algoritmo de Burbuja.

### DataSets:
* **DataSet A/E:** Arrays desordenados estándar.
* **DataSet B:** Array en orden inverso.
* **DataSet C:** Array ya ordenado.
* **DataSet D:** Array con todos los elementos duplicados.
* **DataSet F:** Array vacio (`[]`).
* **DataSet G:** Array con un solo elemento (`[2]`).