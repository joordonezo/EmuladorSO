<%-- 
    Document   : index
    Created on : 9/05/2019, 05:20:38 PM
    Author     : GEORGE
--%>

<%@page import="clases.Memoria"%>
<%@page import="java.io.File"%>
<%@page import="javax.swing.JButton"%>
<%@page import="javafx.scene.control.Slider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ch Maquina</title>
        <meta charset="UTF-8">
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


        <style type="text/css">
            html, body {margin:0; padding:0; width:100%; height:100%; overflow:hidden; text-align:left;}
            body {font-family: 'Tinos', serif;}
            #background{position:absolute; z-index:1; width:100%; height:100%;}
            #impresora{position:absolute; z-index:1; width:550; height:310;}
            #fixed {position:absolute; top:25px; left:10px; width:160px; z-index:10; color:#333; padding:10px;}
            #scroller {position:absolute; width:100%; height:100%; top:0; left:0; overflow:auto; z-index:2;} 
            #content {padding:20px 20px 20px 200px;}

        </style>
    </head>
    <body>

        <!--inicio de interfaz grafica-->
        <div>
            <img id="background" src="img/fondo/portatil.jpg" alt="" title="" /> 
        </div>
        <div id="scroller">
            <div id="content">
                <div id="fixed">

                    <div class="container">
                        <div class="row">
                            <div class="col-lg-10 col-lg-offset-2 col-xs-7 col-xs-offset-5 col-sm-10 col-sm-offset-2">

                                <!--inicio de superior portatil-->
                                <iframe name="contenedor" class="" width="100%" height="370" frameborder="0" src="<% if (Memoria.memoria == -1) {
                                        out.print("img/Pantalla/FondoPantalla.jpg");
                                    } else {
                                        out.print("ChSoftware.jsp");
                                    }%>"></iframe> 
                                <div class="row">  
                                    <!--inicio de boton encendido-->
                                    <div class="spinner-border text-muted"></div>
                                    <!--<button class="btn btn-primary" disabled>
                                        <span class="spinner-grow spinner-grow-sm"></span>
                                        Loading..
                                    </button>-->
                                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#encender" ><span class="glyphicon glyphicon-off"></span></button>
                                    <!--fin de boton encendido-->

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!--fin de interfaz grafica scroller-->



        <!--inicio MODAL Encender -->


        <div class="container" id="1">
            <div class="row">

                <% if (Memoria.memoria == -1) { //solo esta disponible si la memoria aun no esta iniciada%>
                <!--Modal Encender-->
                <form class="form-control" name="formEncendido" method="post" action="Inicio" target="contenedor">
                    <div class="modal fade" id="encender" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                        <div class="modal-dialog modal-sm" role="document">
                            <div class="modal-content ">

                                <div class="modal-header ">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="encenderLabel">Encendiendo...</h4><div class="spinner-border text-muted"></div>

                                </div>

                                <div class="modal-body ">
                                    <div class="clearfix"></div>

                                    <div class="form-group ">

                                        <div class="">
                                            <div class="form-grup has-warning">
                                                <label class="control-label" for="memoria">Memoria: </label>
                                                <input type="number" name= "memoria" id= "memoria" class="form-control required" placeholder="null" value="100"/>
                                                <br>
                                            </div>        
                                            <div class="form-grup has-warning">
                                                <label class="control-label" for="kernel">Kernel </label>
                                                <input type="number" class="form-control required" name="kernel" id="kernel" placeholder="null" value="69"/>
                                            </div>
                                            <br>

                                            <input class="btn btn-success btn-block" type="submit" id="encenderbtn" name="encenderbtn" value="Aceptar"/>

                                        </div>
                                    </div>

                                </div>

                            </div>

                        </div>
                    </div>
                </form>
                <!--FIN DEL MODAL Encender -->
                <%
                    }
                %>
            </div>
        </div>


        <!--fin MODAL Encender-->

    </body>
</html>
