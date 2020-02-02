/*
 * guarda todos los atributos y detalles de un programa al momento de cargarlo
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author GEORGE
 */
public class Programa {

    public static int cantidad = 0;
    private int id;
    private String nombre;
    private int cantidadInst;
    private int tll;
    private int rlc;
    private int rlp;
    private ArrayList<String> instrucciones;

    public Programa(int id, String nombre, int cantidadInst, int tll, int rlc, int rlp, ArrayList<String> instrucciones) {
        cantidad++;
        this.id = id;
        this.nombre = nombre;
        this.cantidadInst = cantidadInst;
        this.tll = tll;
        this.rlc = rlc;
        this.rlp = rlp;
        this.instrucciones = instrucciones;

    }

    //setters
    private void setId(int id) {
        this.id = id;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setCantidadInst(int cantidadInst) {
        this.cantidadInst = cantidadInst;
    }

    private void setTll(int tll) {
        this.tll = tll;
    }

    private void setRlc(int rlc) {
        this.rlc = rlc;
    }

    private void setRlp(int rlp) {
        this.rlp = rlp;
    }

    //geters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadInst() {
        return cantidadInst;
    }

    public int getTll() {
        return tll;
    }

    public int getRlc() {
        return rlc;
    }

    public int getRlp() {
        return rlp;
    }
    
    public ArrayList<String> getInstrucciones(){
        return instrucciones;
    }
    
    public void setInstrucciones(ArrayList<String> instrucciones){
        this.instrucciones = instrucciones;
    }

}
