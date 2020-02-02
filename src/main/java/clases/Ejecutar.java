/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author GEORGE
 */
public class Ejecutar {
    
    
    public static  void Ejecutar(ArrayList instrucciones){
        ArrayList<String> variables = new ArrayList<String>();
        for (int i = 0; i < instrucciones.size(); i++) {
            String linea = (String) instrucciones.get(i);
            String[] parteLinea = linea.split(" ");
            switch (parteLinea[0]) {

                case "//":

                    break;
                case "cargue":
                    
                case "almacene":
                case "lea":
                case "sume":
                case "reste":
                case "multiplique":
                case "divida":
                case "muestre":
                case "imprima":
                    if (parteLinea.length == 2) {
                        if (Character.isDigit(parteLinea[1].charAt(0))) {
                            break;
                        } else {
                            boolean existe = false;

//verificar que la variable exista
                            for (int j = 0; j < variables.size(); j++) {
                                if (parteLinea[1].equals(variables.get(j))) {

                                    existe = true;
                                    break;
                                }
                            }

                            if (existe) {

                                break;
                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                case "vaya":

                    break;
                case "vayasi":

                    break;
                case "nueva":
                    if (parteLinea.length >= 3 && parteLinea.length <= 4) {
                        if (!Character.isDigit(parteLinea[1].charAt(0))) {
                            boolean existeVar = false; // asumimos que no existe

//verificar que la variable no exista
                            for (int j = 0; j < variables.size(); j++) {
                                if (parteLinea[1].equals(variables.get(j))) {


                                    existeVar = true;
                                    break;
                                }
                            }

                            if (existeVar) {
                                break;
                            } else {
                                boolean todoOK = true; //asumimos que todo esta bien
                                switch (parteLinea[2]) {
//                                    cadena                                   
                                    case "C":
                                        if (parteLinea.length == 3) {
                                            variables.add(parteLinea[1]);
                                            break;
                                        } else if (parteLinea.length == 4) {
                                            if (parteLinea[3].startsWith("\"") && parteLinea[3].endsWith("\"")) {
                                                variables.add(parteLinea[1]);
                                                break;
                                            } else {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }

//enteros                                        
                                    case "I":
                                        if (parteLinea.length == 3) {
                                            variables.add(parteLinea[1]);
                                            break;
                                        } else if (parteLinea.length == 4) {
                                            char[] letras = parteLinea[3].toCharArray();
                                            for (int j = 0; j < letras.length; j++) {
                                                if (!Character.isDigit(letras[j])) {
                                                    break;
                                                }
                                            }

                                        } else {
                                            todoOK = false;
                                            break;
                                        }
                                    case "R":

                                        if (parteLinea.length == 3) {
                                            variables.add(parteLinea[1]);
                                            break;
                                        } else if (parteLinea.length == 4) {
                                            String[] numreal = parteLinea[3].split("\\.");
                                            if (numreal.length == 2) {
                                                char[] entero = numreal[0].toCharArray();
                                                char[] decimal = numreal[1].toCharArray();

                                                for (int j = 0; j < entero.length; j++) {
                                                    if (!Character.isDigit(entero[j])) {
                                                       
                                                        break;
                                                    }
                                                }
                                                for (int j = 0; j < decimal.length; j++) {
                                                    if (!Character.isDigit(decimal[j])) {
                                                        
                                                        break;
                                                    }
                                                }
                                            } else if (numreal.length > 2) {
                                                
                                                break;
                                            }
                                        } else {
                                          
                                            break;//
                                        }
                                    case "L":
                                        if (parteLinea.length == 3) {
                                            variables.add(parteLinea[1]);
                                            break;
                                        } else if (parteLinea.length == 4) {
                                            char[] logico = parteLinea[3].toCharArray();
                                            if (logico.length > 1) {
                                             
                                                break;
                                            } else if (logico.length == 1) {
                                                boolean esLogico = true;//asumimos que es 0 ó 1
                                                switch (parteLinea[3]) {
                                                    case "0":
                                                    case "1":
                                                        break;
                                                    default:
                                                        
                                                        esLogico = false;
                                                        break;

                                                }
                                                if (esLogico) {
                                                    variables.add(parteLinea[1]);
                                                    break;
                                                } else {
                                                    
                                                    break;
                                                }
//                                             
                                            }

                                        } else {
                                            
                                            break;
                                        }
                                    default:
                                        
                                        break;
                                }
                                if (todoOK) {
                                    //deberia de poner variables.add(parteLinea[1]);
                                    break;
                                } else {
                                   
                                    break;
                                }
                            }
                        } else {
                           
                            break;
                        }
                    } else {
                        
                        break;
                    }

                case "etiqueta":

                    if (parteLinea.length == 3) {
                        switch (parteLinea[1]) {
                            case "ciclo":
                            case "fin":
                                char[] numEtiqueta = parteLinea[2].toCharArray();
                                boolean esLetra = false;
                                for (int j = 0; j < numEtiqueta.length; j++) {
                                    if (!Character.isDigit(numEtiqueta[j])) {
                                        esLetra = true;
                                        break;
                                    }
                                }
                                if (esLetra) {
                                    
                                    break;
                                } else {
                                    break;
                                }
                            default:
                             
                                break;
                        }
//break;
                    } else {

                        break;
                    }
                case "potencia":

                    break;
                case "modulo":

                    break;
                case "concatene":

                    break;
                case "elimine":

                    break;
                case "Extraiga":

                    break;
                case "Y":

                    break;
                case "O":

                    break;
                case "NO":

                    break;

                case "jorgexxx":

                    break;
                case "retorne":

                    break;
                default:
                    break;
            }
        }
    }
}
