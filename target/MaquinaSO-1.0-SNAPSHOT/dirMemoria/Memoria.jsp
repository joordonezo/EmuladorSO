<%-- 
    Document   : newjspMemoria
    Created on : 16/05/2019, 04:47:44 PM
    Author     : GEORGE
--%>
<%@page import="clases.Memoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page import="clases.Programa"%>
<%@page import="clases.ProgramasCargados" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Memoria</title>
        <link rel="icon" type="image/png" href="img/img_default/index.png" />
        <link rel="stylesheet" mdia="screen" href="../css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" mdia="screen" href="../css/bootstrap.css.map" type="text/css">
        <link rel="stylesheet" mdia="screen" href="../css/bootstrap.css" type="text/css">
        <link rel="stylesheet" mdia="screen" href="../css/bootstrap-theme.css" type="text/css">
        <link rel="stylesheet" mdia="screen" href="../css/bootstrap-theme.css.map" type="text/css">
        <link rel="stylesheet" mdia="screen" href="../css/bootstrap-theme.min.css" type="text/css">


        <script src="../js/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <script src="../js/npm.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="table table-responsive label-default small">
           
            <tr> 
                <td>
                    POS
                </td>
                <td>
                    Instrucción
                </td>
            </tr>
            <%

                Vector<Programa> programas = ProgramasCargados.getVecProgramas();//obtiene los programas cargador
                ArrayList<String> vecIns = new ArrayList<String>();//se inicializza el ArrayList para evitar confictos

                for (int i = 0; i < programas.size(); i++) {
                    Programa pro = programas.get(i);//asignamos un programa de los cargados
                    ArrayList instrucciones = pro.getInstrucciones();//recuperamos las intrucciones de este programa

                    for (int j = 0; j < instrucciones.size(); j++) {
                        String inst = (String) instrucciones.get(j);
                        //if (!inst.startsWith("//")) {//validamos si la instruccion es un comentario y se omite para almacenaje en memoria
                        String ceros = "000";//se formatea el texto a un maximo de 4 digitos
                        if (pro.getId() >= 10 && pro.getId() <= 99) {
                            ceros = "00";
                        } else if (pro.getId() >= 100 && pro.getId() <= 999) {
                            ceros = "0";
                        } else if (pro.getId() >= 1000 && pro.getId() <= 9999) {
                            ceros = "";
                        }
                        vecIns.add(ceros + pro.getId() + inst);//se guardan las instrucciones del programa sin comentarios
                        //}
                    }
                }
                Memoria.setMemoria(vecIns);//se guarda las nuevas instricciones en memoria libres de comentarios
                Vector<String> ins = Memoria.getVecMemoria();//obtenemos el vector de memoria 

                for (int i = 0; i < ins.size(); i++) {//lo mostramos en pantalla
                    if (i >= 0 && i <= 9) {
                        out.print("<tr><td>000" + (i + 1) + "</td><td>" + ins.get(i) + "</td></tr>");
                    } else if (i >= 10 && i <= 99) {
                        out.print("<tr><td>00" + (i + 1) + "</td><td>" + ins.get(i) + "</td></tr>");

                    } else if (i >= 100 && i <= 999) {
                        out.print("<tr><td>0" + (i + 1) + "</td><td>" + ins.get(i) + "</td></tr>");

                    } else if (i >= 1000 && i <= 9999) {
                        out.print("<tr><td>" + (i + 1) + "</td><td>" + ins.get(i) + "</td></tr>");
                    }
                }

            %>

        </table>
    </body>
</html>
