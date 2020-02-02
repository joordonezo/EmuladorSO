/*
 * se encarga de almacenar los programas utilizados y sus respectivos metodos
 */
package clases;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author GEORGE
 */
public class ProgramasCargados {

    public static Vector<Programa> VecProgramas = new Vector<Programa>();

    public static void addPrograma(Programa programa) {
        VecProgramas.add(programa);
    }

    public static Vector<Programa> getVecProgramas() {
        return VecProgramas;
    }

    public static ArrayList getAtributos(int index) {
        Programa pro = VecProgramas.elementAt(index);
        ArrayList atributos = new ArrayList();
        atributos.add(pro.getId());
        atributos.add(pro.getNombre());
        atributos.add(pro.getCantidadInst());
        atributos.add(pro.getTll());
        atributos.add(pro.getRlc());
        atributos.add(pro.getRlp());

        return atributos;

    }
    public static ArrayList<String> getInstrucciones(int index){
        Programa pro = VecProgramas.elementAt(index);
        return pro.getInstrucciones();
    }
    

    public static boolean buscar(Programa programa) {
        Programa pro;
        if (VecProgramas.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < VecProgramas.size(); i++) {
                pro = (Programa) VecProgramas.elementAt(i);
                if (pro.equals(programa)) {
                    return true;
                }
            }
        }
        return false;
    }
}
