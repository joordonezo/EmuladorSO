/*
 * Maneja la memoria interna del computador 
 */
package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author GEORGE
 */
public class Memoria {

    public static Vector<String> vecMemoria;

    public static HashMap<String, String> hashMapVariables = new HashMap<String, String>();
    
    public static int kernel;
    public static int memoria = -1;
    public static double acumulador;
    public static String modo = "Kernel";

    public static void crearMemoria() {

        vecMemoria = new Vector<String>(memoria);
        vecMemoria.insertElementAt("Acumulador", 0);
        for (int i = 1; i < kernel; i++) {
            vecMemoria.insertElementAt("Kernel", i);
        }
    }

    public static Vector<String> getVecMemoria() {
        return vecMemoria;
    }

    public static HashMap<String, String> getHashMapVariable(){
        return hashMapVariables;
    }
    public static String getValVariable(String codMemoria) {
        return hashMapVariables.get(codMemoria);
    }

    public static void setMemoria(ArrayList<String> instricciones) {
        for (int i = 0; i < instricciones.size(); i++) {
            vecMemoria.addElement(instricciones.get(i));
        }
    }

    public static void setValVariables(String codMemoria, String valor) {
        hashMapVariables.put(codMemoria, valor);
    }

    public static int getMemoria() {
        return memoria;
    }

    public static int getKernel() {
        return kernel;
    }

    public static double getAcumulador() {
        return acumulador;
    }

    public static String getModo() {
        return modo;
    }

}
