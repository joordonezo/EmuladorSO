<%-- 
    Document   : Pantalla
    Created on : 16/05/2019, 03:20:18 PM
    Author     : GEORGE
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="clases.Compilar" %>
<%@page import="clases.Memoria" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="img/img_default/index.png" />
        <link rel="stylesheet" mdia="screen" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" mdia="screen" href="css/bootstrap.css.map" type="text/css">
        <link rel="stylesheet" mdia="screen" href="css/bootstrap.css" type="text/css">
        <link rel="stylesheet" mdia="screen" href="css/bootstrap-theme.css" type="text/css">
        <link rel="stylesheet" mdia="screen" href="css/bootstrap-theme.css.map" type="text/css">
        <link rel="stylesheet" mdia="screen" href="css/bootstrap-theme.min.css" type="text/css">


        <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/npm.js" type="text/javascript"></script>


    </head>
    <body>
        <form class="" name="InstruccionesTexto" method="post" action="servCompilarEjecutar" target="Mensajes" enctype="">

        <% if (request.getAttribute("nombre") != null) {

        %>
        
            <div class="row">
                <div class="col-lg-12 col-sm-12 col-xs-12">
                    <ul class="nav nav-tabs small">
                        <li role="presentation" class=""><a href="#"><span class="glyphicon glyphicon-pause"> Pausa</span></a></li>

                        <ul class="nav nav-tabs">
                            <li role="presentation" class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"> Ejecutar</span> <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu " role="menu">
                                    
                                    <li role="presentation">
                                        <div class="btn btn-group"><span class="glyphicon glyphicon-play-circle"></span><input type="submit" name="enviado" value="Normal"/></div>
                                    </li>
                                    <li class="divider"></li>
                                    <li role="presentation"><a type="submit" href="" target="Pantalla" value="pasoapaso"><span class="glyphicon glyphicon-play-circle" aria-hidden="true"> Paso a Paso</span> </a></li>


                                </ul>
                            </li>
                            <li role="presentation" class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <span class="glyphicon glyphicon-file" aria-hidden="true"> Archivo</span> <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu " role="menu">
                                    <li role="presentation"><a class="" href="dirPantalla/Pantalla.jsp" target="Pantalla"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"> Guardar
                                                <li role="presentation"><a  href="dirPantalla/Pantalla.jsp" target="Pantalla"><span class="glyphicon glyphicon-download" aria-hidden="true"> Descargar</span> </a></li>

                                                <li class="divider"></li>
                                                <li role="presentation"><a href="" id="" data-toggle="modal" data-target="#myModal" target="index"><span class="glyphicon glyphicon-print"> Imprimir</span></a></li>
                                                </ul>
                                                </li>


                                                </ul>
                                                </ul>
                                                </div>
                                                </div>


                                                <div class="row">
                                                    <div class="col-lg-12 col-sm-12 col-xs-12">



                                                        <input class="" type="hidden" name="nombrePro" value="<%= request.getAttribute("nombre")%>"/> <h3><%= request.getAttribute("nombre")%> </h3>


                                                        <% ArrayList<String> lista = (ArrayList<String>) request.getAttribute("lista"); %>
                                                        <table style="width: 300px; height: 200px;">
                                                            <tr>
                                                                <td>
                                                                    <textarea style="width: 30px; height: 2200px; align-items: left; resize: none" disable="true"><%

                                                                        for (int i = 1; i <= 100; i++) {
                                                                            out.print(i + "\n");//imprime el numero de linea
                                                                        }
                                                                        %>
                                                                    </textarea>
                                                                </td>
                                                                <td>
                                                                    
                                                                    <textarea name="textoPrograma" style="width: 1000px; height: 2200px; align-items: left; resize: none"><%
                                                                        for (String list : lista) {
                                                                            out.print(list + "\n"); // imprime la instruccion por linea
                                                                        }
                                                                        %>
                                         
                                                                    </textarea>
                                                                    
                                                                </td>
                                                            </tr>
                                                        </table>
                                                                        

                                                    </div>

                                                </div>
                                                <%}%>
                                                </form> 



                                                <!--inicio MODAL IMPRIMIR -->

                                                <form class="form-control">

                                                    <div class="container" id="1">
                                                        <div class="row">
                                                            <div class="col-xs-6 col-xs-offset-6">
                                                                <!--Modal Imprimir-->
                                                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                                                    <div class="modal-dialog" role="document">
                                                                        <div class="modal-content">
                                                                            <div class="modal-header">
                                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                                                <h4 class="modal-title" id="myModalLabel">Imprimiendo...</h4><div class="spinner-border text-muted"></div>

                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-lg-12 col-sm-12 col-xs-12>"

                                                                                     <div class="modal-body">
                                                                                        <div class="clearfix"></div>
                                                                                        <div class="form-group">
                                                                                            <img id="impresora" src="../img/impresora/impresora.png" class="img-responsive" alt="" title="" />
                                                                                            <div class="">

                                                                                                <textarea class="glyphicon glyphicon-print col-lg-4 col-lg-offset-4">Aquí va la impresión</textarea>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>

                                                                                </div>
                                                                            </div>
                                                                        </div>

                                                                    </div>
                                                                    <!--fin MODAL IMPRIMIR-->
                                                                </div>
                                                            </div>

                                                        </div>

                                                </form>
                                                </body>
                                                </html>
