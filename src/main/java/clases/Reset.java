/*
 * reicicia la memria y kernel indicado u finaliza todo para un nuevo inicio
 */
package clases;

/**
 *
 * @author GEORGE
 */
public class Reset {

    public static void apagar() {
        Memoria.kernel = 0;
        Memoria.memoria = -1;
        basicas();

    }

    public static void reiniciar(int kernel, int memoria) {
        Memoria.kernel = kernel;
        Memoria.memoria = memoria;
        basicas();
    }

    public static void basicas() {
        try {
            Memoria.vecMemoria.clear();

            Memoria.acumulador = 0;
            Memoria.modo = "Kernel";

            ProgramasCargados.VecProgramas.clear();

            Programa.cantidad = 0;
        } catch (Exception e) {
            System.err.println("Error apagando: " + e.getMessage());
        }
    }
}
