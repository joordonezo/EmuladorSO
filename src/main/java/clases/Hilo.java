/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
/**
 *
 * @author GEORGE
 */
public class Hilo extends Thread{
    Programa programa;
    
    public Hilo(Programa programa){
        this.programa = programa;
    }
    
    @Override
    public void run(){
        while (programa.getInstrucciones() != null) {  
            
            
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Error en el hilo "+e.getMessage());
            }
 
        }
    }
}
