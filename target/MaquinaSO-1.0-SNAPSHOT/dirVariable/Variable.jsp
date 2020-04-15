<%-- 
    Document   : variable
    Created on : 16/05/2019, 04:47:00 PM
    Author     : GEORGE
modulo de muetra de variables
--%>

<%@page import="clases.Programa"%>
<%@page import="java.util.Vector"%>
<%@page import="clases.Memoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Variable</title>
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
                    Variable
                </td>
            </tr>
            <%
                Vector<String> instrucciones = Memoria.getVecMemoria(); // obtenemos la memoria principal
                int contador = 0; // contador para otrogar la posicion de las variables
                for (int i = 0; i < instrucciones.size(); i++) {
                    String numPrograma = instrucciones.get(i).substring(0, 4);//obtener codigo del programa al que pertenece
                    String texto = instrucciones.get(i).substring(4, instrucciones.get(i).length()); //obtener la instruccion nueva para confirmar que se trata de una variable 

                    if (texto.startsWith("nueva")) {
                        contador++;
                        texto = texto.substring(5, texto.length()); //se toma el resto de la cadena

                        texto = texto.trim();

                        String[] text = texto.split(" ");//eliminar el resto de informacion inecesaria para esta labor
                        String ceros = "000";//formatea el numero en memoria solo de 4 digitos
                        if (contador >= 10 && contador <= 9) {
                            ceros = "00";
                        } else if (contador >= 100 && contador <= 99) {
                            ceros = "0";
                        } else if (contador >= 1000 && contador <= 9999) {
                            ceros = "";
                        }
                        out.print("<tr><td>" + ceros + contador + "</td><td>" + numPrograma + text[0] + "</td></tr>");

                    }
                }


            %>

        </table>
    </body>
</html>
