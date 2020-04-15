<%-- 
    Document   : Programa
    Created on : 16/05/2019, 04:48:34 PM
    Author     : GEORGE
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="clases.Programa"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.ProgramasCargados" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programa</title>
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
                    ID
                </td>
                <td>
                    Programa
                </td>
                <td>
                    Ints
                </td>
                <td>
                    TLL
                </td>
                <td>
                    RLC
                </td>
                <td>
                    RLP
                </td>
            </tr>
            <%
                Vector<Programa> programas = ProgramasCargados.getVecProgramas(); //obtiene los programas cargados

                for (int i = 0; i < programas.size(); i++) {
                    ArrayList atributos = ProgramasCargados.getAtributos(i);//obtirne los atributos de un programa
                    out.print("<tr>");

                    for (int j = 0; j < atributos.size(); j++) {

                        if (j == 0) {
                            int atrib = (int) atributos.get(0); //formatea la salida del codigo a solo 4 digitos
                            String ceros = "000";
                            if (atrib >= 10 && atrib <= 99) {
                                ceros = "00";
                            } else if (atrib >= 100 && atrib <= 999) {
                                ceros = "0";
                            } else if (atrib >= 1000 && atrib <= 9999) {
                                ceros = "";
                            }
                            out.print("<td>" + ceros + atributos.get(j) + "</td>");
                        } else {
                            out.print("<td>" + atributos.get(j) + "</td>");
                        }
                    }

                    out.print("</tr>");
                }

            %>

        </table>
    </body>
</html>
