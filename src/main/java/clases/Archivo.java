/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static java.awt.image.ImageObserver.ERROR;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author GEORGE
 */
public class Archivo {

    private static String nombre;
    private static ArrayList<String> instrucciones;
    private static File rutaArch;
    private static FileWriter escritor;
    private static BufferedWriter bufSalida;
    private static PrintWriter salida;

    public Archivo() {

    }

    public static void guardarArchivo(String nombre, ArrayList<String> instrucciones) {

        try {
            rutaArch = new File("/ArchivosCh/" + nombre);
            escritor = new FileWriter(rutaArch, false);
            bufSalida = new BufferedWriter(escritor);
            salida = new PrintWriter(bufSalida);

            for (int i = 0; i < instrucciones.size(); i++) {

                if (instrucciones.get(i) != null) {
                    salida.print(instrucciones.get(i));
                } else {
                    break;
                }
            }

            salida.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo", "error creando el archivo", ERROR);

        }
    }

    public static void leerArchivo() {
        try {
            File nombre = new File("src/Archivos/Jugadores.txt");
            FileReader lector = new FileReader(nombre);
            BufferedReader entrada = new BufferedReader(lector);
            String dato;
            int i = 1;
            dato = entrada.readLine();
            while (dato != null) {
                dato = entrada.readLine();
                i++;
            }
            entrada.close();

            nombre = new File("src/Archivos/Jugadores.txt");
            lector = new FileReader(nombre);
            entrada = new BufferedReader(lector);
//            listaNombres = new String[i];
            i = 0;
            dato = entrada.readLine();
//            listaNombres[i] = dato;
            while (dato != null) {
                dato = entrada.readLine();
//                listaNombres[i] = dato;
                i++;
            }
            entrada.close();

        } catch (IOException e) {

            try {
                File nombre = new File("src/Archivos/Jugadores.txt");
                FileWriter escritor = new FileWriter(nombre);
                BufferedWriter bufSalida = new BufferedWriter(escritor);
                PrintWriter salida = new PrintWriter(bufSalida);
                salida.println("************");
                salida.println("---Seleccione---");
                salida.close();
                JOptionPane.showMessageDialog(null, "Error leyendo el archivo, ejecute nuevamete el programa", "Error de lectura", JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, "El problema fue solucionado correctamente", "Solucionado", JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Imposible solucionar el problema", "Error de lectura", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
