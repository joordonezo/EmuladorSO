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
public class Compilar {

    public static int numeroLinea = -1;
    public static int numeroInstruccion = -1;
    public static String instruccion = "null";
    public static String comentario = "null";
    public static String enteroo = "nullentero";
    public static String decimall = "nulldecimal";
    public static String tamanoR = "";

    public static boolean sinErroresSintaxy(ArrayList instrucciones) {
        boolean bandera = true;//asumimos que el codigo esta bien
        ArrayList<String> variables = new ArrayList<String>();
        for (int i = 0; i < instrucciones.size(); i++) {
            String linea = (String) instrucciones.get(i);
            String[] parteLinea = linea.split(" ");
            if (parteLinea.length > 1) {
                parteLinea[0] = parteLinea[0].trim();
                parteLinea[1] = parteLinea[1].trim();
                if (parteLinea.length >= 3) {
                    parteLinea[2] = parteLinea[2].trim();
                    if (parteLinea.length >= 4) {
                        parteLinea[3] = parteLinea[3].trim();
                    }
                }
            }

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
//                    if (parteLinea.length == 2) {
//                        if (!Character.isDigit(parteLinea[1].charAt(0))) {
//                            boolean existeVar = true;//asumimos que la variable existe
//
////verificar que la variable exista
//                            for (int j = 0; j < variables.size(); j++) {
//                                if (!parteLinea[1].equals(variables.get(j))) {
//
//                                    existeVar = false;
//                                    break;
//                                }
//                            }
//                            if (existeVar) {
//                                break;
//                            } else {
//                                numeroLinea = i;
//                                instruccion = parteLinea[1];
//                                comentario = "no ha sido declarada";
//                                bandera = false;
//                                break;
//                            }
//
//                        } else {
//                            numeroLinea = i;
//                            instruccion = parteLinea[1];
//                            comentario = "la variable comienza por un numero";
//
//                            bandera = false;
//                            break;
//
//                        }
//                    } else {
//
//                        numeroLinea = i;
//                        comentario = "el tamaño de la linea es diferente de 2";
//                        bandera = false;
//                        break;
//                    }
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

                                    numeroLinea = i;
                                    numeroInstruccion = j;
                                    instruccion = parteLinea[1];
                                    comentario = "ya ha sido declarada";

                                    existeVar = true;
                                    break;
                                }
                            }

                            if (existeVar) {
                                bandera = false;
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
                                                numeroLinea = i;
                                                instruccion = parteLinea[3];
                                                comentario = "no inicia ni temina por comilas";
                                                todoOK = false;
                                                break;
                                            }
                                        } else {
                                            numeroLinea = i;
                                            comentario = "faltan o sobran parametrros en C";
                                            todoOK = false;
                                            break;
                                        }

//enteros                                        
                                    case "I":
                                        if (parteLinea.length == 3) {
                                            variables.add(parteLinea[1]);
                                            break;
                                        } else if (parteLinea.length == 4) {
                                            boolean esEntero = true;//asumimos que es un entero
                                            char[] letras = parteLinea[3].toCharArray();
                                            for (int j = 0; j < letras.length; j++) {
                                                if (!Character.isDigit(letras[j])) {
                                                    numeroInstruccion = j;
                                                    esEntero = false;
                                                    break;
                                                }
                                            }
                                            if (esEntero) {
                                                variables.add(parteLinea[1]);
                                                break;

                                            } else {
                                                numeroLinea = i;
                                                instruccion = parteLinea[3];
                                                comentario = "Contine letras y debe ser un entero";
                                                todoOK = false;
                                                break;
                                            }

                                        } else {
                                            numeroLinea = i;
                                            comentario = "faltan o sobran parametrros en I";
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

                                                boolean esEntero = true;//asumimos que las partes del real son enteros
                                                for (int j = 0; j < entero.length; j++) {
                                                    if (!Character.isDigit(entero[j])) {
                                                        numeroInstruccion = j;
                                                        esEntero = false;
                                                        break;
                                                    }
                                                }
                                                for (int j = 0; j < decimal.length; j++) {
                                                    if (!Character.isDigit(decimal[j])) {
                                                        numeroInstruccion = j;
                                                        esEntero = false;
                                                        break;
                                                    }
                                                }
                                                if (esEntero) {
                                                    variables.add(parteLinea[1]);
                                                    break;

                                                } else {
                                                    numeroLinea = i;
                                                    instruccion = parteLinea[3];
                                                    comentario = "contiene letras el numero real";
                                                    todoOK = false;
                                                    break;

                                                }

                                            } else if (numreal.length > 2) {
                                                numeroLinea = i;
                                                instruccion = parteLinea[3];
                                                comentario = "Tiene mas de un punto(.)";
                                                todoOK = false;
                                                break;
                                            }
                                        } else {
                                            numeroLinea = i;
                                            comentario = "faltan o sobran parametrros en R";
                                            todoOK = false;
                                            break;//
                                        }
                                    case "L":
                                        if (parteLinea.length == 3) {
                                            variables.add(parteLinea[1]);
                                            break;
                                        } else if (parteLinea.length == 4) {
                                            char[] logico = parteLinea[3].toCharArray();
                                            if (logico.length > 1) {
                                                numeroLinea = i;
                                                instruccion = parteLinea[3];
                                                comentario = "Tiene mas de un caracter boleano es 0 ó 1";
                                                todoOK = false;
                                                break;
                                            } else if (logico.length == 1) {
                                                boolean esLogico = true;//asumimos que es 0 ó 1
                                                switch (parteLinea[3]) {
                                                    case "0":
                                                    case "1":
                                                        break;
                                                    default:
                                                        numeroLinea = i;
                                                        instruccion = parteLinea[3];
                                                        comentario = "debe ser 0 ó 1";
                                                        esLogico = false;
                                                        break;

                                                }
                                                if (esLogico) {
                                                    variables.add(parteLinea[1]);
                                                    break;
                                                } else {
                                                    numeroLinea = i;
                                                    comentario = "no es un valor lógico";
                                                    todoOK = false;
                                                    break;
                                                }
//                                             
                                            }

                                        } else {
                                            numeroLinea = i;
                                            comentario = "faltan o sobran parametrros en L";
                                            todoOK = false;
                                            break;
                                        }
                                    default:
                                        numeroLinea = i;
                                        instruccion = parteLinea[2];
                                        comentario = "no es un tipo conocido";
                                        todoOK = false;
                                        break;
                                }
                                if (todoOK) {
                                    //deberia de poner variables.add(parteLinea[1]);
                                    break;
                                } else {
                                    bandera = false;
                                    break;
                                }
                            }
                        } else {
                            numeroLinea = i;
                            comentario = "inicia con un número";
                            bandera = false;
                            break;
                        }
                    } else {
                        numeroLinea = i;
                        comentario = "no tiene todos los parametos requeridos o le sobran";
                        bandera = false;
                        break;
                    }

                case "etiqueta":
                    if (parteLinea.length == 3) {
                        boolean todoOK = true;//asumimos que todo esta ok
                        switch (parteLinea[1]) {
                            case "ciclo":
                            case "fin":

                                char[] numEtiqueta = parteLinea[2].toCharArray();
                                boolean esNumero = true;//asumimos que es numero
                                for (int j = 0; j < numEtiqueta.length; j++) {
                                    if (!Character.isDigit(numEtiqueta[j])) {
                                        esNumero = false;
                                        break;
                                    }
                                }
                                if (esNumero) {
                                    break;
                                } else {
                                    numeroLinea = i;
                                    instruccion = parteLinea[2];
                                    comentario = "no es un numero";
                                    todoOK = false;
                                    break;
                                }
                            default:
                                numeroLinea = i;
                                instruccion = parteLinea[2];
                                comentario = "no es ni ciclo ni fin";
                                todoOK = false;
                                break;
                        }
                        if (todoOK) {
                            break;
                        } else {
                            bandera = false;
                            break;
                        }
//break;
                    } else {

                        numeroLinea = i;
                        instruccion = parteLinea[3];//
                        comentario = "la etiquetaaaa no tiene todos los parametos requeridos o le faltan";
                        bandera = false;
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
//                    numeroLinea = 1234567890;
//                    instruccion = "default bandera";
//                    comentario = "entra en default del primer switch";
                    bandera = false;
                    break;
            }
        }

        return bandera;

    }
}
