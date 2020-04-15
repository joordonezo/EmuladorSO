<%-- 
    Document   : index1
    Created on : 28/05/2019, 12:57:33 AM
    Author     : GEORGE
--%>

<%@page import="java.net.URI"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.Memoria" %>
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
        <!--Inicio de formulario direccion al servlet servChMaquina -->
        <!---->
        <form name="" method="post"  action="" target="" enctype="">
            <div class="btn-group btn-group-sm col-lg-12 col-sm-10 col-xs-12" role="group" aria-label="">
                <div class="btn-group" role="group">
                    <div class="list-group" role="group">
                        <label type="" class="control-label">Memoria</label>
                        <input type="number" class="input-sm" name="memoriaf" placeholder="Null" value="<%out.print(Memoria.getMemoria());%>"/>

                        <label title="" class="control-label">Kernel</label>
                        <input type="number" class="input-sm" name="kernelf" placeholder="Null" value="<%out.print(Memoria.getKernel());%>" />

                        <label title="" class="control-label">Acumulador: </label>
                        <label type="" class="control-label" name="acumulador" ><%out.print(Memoria.getAcumulador());%></label>
                    </div>
                </div>
            </div>

            <div class="clearfix" ></div>

            <!--fin de superior portatil-->
            <div class="row">

                <div class="col-lg-12 col-sm-12 col-xs-12">



                    <!--inicio de dropdown vertical-->
                    <div class="btn-group col-lg-2 col-sm-2 col-xs-2">

                        <div class="btn-group-vertical btn-group-sm" role="group" aria-label="">
                            <div class="btn-group" role="group">
                                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#subir" ><span class="glyphicon glyphicon-file"></span> Archivo </button>

                                <label type="" class="btn label"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></label>
                            </div>
                            <div class="btn-group" role="group">
                                <button id="" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"> Programas </span> <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu " role="menu">

                                    <%
                                        String ruta = "/ArchivosCh";
                                        //String ruta = "C:\\Users\\GEORGE\\Documents\\NetBeansProjects\\ChMaquina\\web\\ArchivosCh"; 
                                        //File dir = new File(ruta);
                                        //out.print(getServletContext().getResource(ruta));
                                        File dir = new File(getServletContext().getResource(ruta).getPath());
                                                
                                        String[] nombreArchivos = dir.list();//retorna y guarda la lista de los ficheros en el directorio
                                        int i = 0;
                                        for (String re : nombreArchivos) {//muestra los nombres de los archivos

                                            // out.print("<li><span class='glyphicon glyphicon-play-circle' aria-hidden='true' ><input class='btn btn-default' formaction='LeerArchivo' formtarget='Texto' type='submit' name='cargar' value='" + re + "'/></span><div class='clearfix'></div></li>");
                                    %>
                                    <li><span class='glyphicon glyphicon-play-circle' aria-hidden='true' ><input class='btn btn-default' formaction='LeerArchivo' formtarget='Pantalla' type='submit' name='cargar' value='<% out.print(re);%> '/></span><div class='clearfix'></div></li>
                                            <%
                                                }
                                            %>
                                </ul>

                            </div>
                            <a href="dirMemoria/Memoria.jsp" target="Memoria" type="button" class="btn btn-default"><span class="glyphicon glyphicon-tasks" aria-hidden="true"> Memoria</span></a>
                            <label type="" class="btn label"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></label>
                            <label type="" class="btn label"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></label>

                            <button id="" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-ban-circle" aria-hidden="true"> Inicio <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu " role="menu">
                                <li><input class="btn btn-default" type="submit" value="reiniciar" name="reset" formaction="servChMaquina"/></li>
                                <li><input class="btn btn-default" type="submit" value="apagar" name="reset" formaction="servChMaquina"/></li>

                                <%//@include file="dirReset/Reset.jsp" %>    
                            </ul>
                            <div class="row">
                                <div class="col-lg-12 col-sm-12 col-xs-12">
                                    <iframe class="" name="Mensajes" width="100%" height="70" frameborder="0" src=""></iframe>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!--fin de dropdown vertial grafica-->
                    <div class="col-lg-11 col-sm-10 col-xs-9">
                        <div class="col-lg-6 col-sm-6 col-xs-12">
                            <label class="text">Modo: </label>
                            <label class="badge"><%out.print(Memoria.getModo()); // retorna y muestra el valor de el modo de funcionamiento actual(kernel o usuario) %> </label>

                            <iframe class="" name="Pantalla" width="100%" height="270" frameborder="0" src=""></iframe>
                        </div>
                        <div class="col-lg-6  col-sm-6 col-xs-12">
                            <div class="row">
                                <div class="col-lg-4  col-sm-4 col-xs-12">
                                    <label class="badge center-block">Variables <a href="dirVariable/Variable.jsp" target="Variable"><span class="glyphicon glyphicon-refresh"></span></a></label>
                                    <iframe class="" name="Variable" width="100%" height="175" frameborder="0" src="dirVariable/Variable.jsp"></iframe>
                                </div>
                                <div class="col-lg-4 col-sm-4 col-xs-12">
                                    <label class="badge center-block">Memoria <a href="dirMemoria/Memoria.jsp" target="Memoria"><span class="glyphicon glyphicon-refresh"></span></a></label>
                                    <iframe class="" name="Memoria" width="100%" height="175" frameborder="0"></iframe>
                                </div>
                                <div class="col-lg-4 col-sm-4 col-xs-12">
                                    <label class="badge center-block">Etiqueta <a href="dirEtiqueta/Etiqueta.jsp" target="Etiqueta"><span class="glyphicon glyphicon-refresh"></span></a></label>
                                    <iframe class="" name="Etiqueta" width="100%" height="175" frameborder="0" src="dirEtiqueta/Etiqueta.jsp"></iframe>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-sm-12 col-xs-12">
                                    <label class="badge center-block">Programa <a href="dirPrograma/Programa.jsp" target="Programa"><span class="glyphicon glyphicon-refresh"></span></a></label>
                                    <iframe class="" name="Programa" width="100%" height="70" frameborder="0" src="dirPrograma/Programa.jsp"></iframe>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </form>

        <!--Modal Instalar-->
        <form class="form-control" name="formAbrir" method="post" action="SubirArchivo" enctype="multipart/form-data">
            <div class="modal fade" id="subir" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content ">

                        <div class="modal-header ">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="encenderLabel">Abrir Archivo</h4><div class="spinner-border text-muted"></div>

                        </div>

                        <div class="modal-body ">
                            <div class="clearfix"></div>

                            <div class="form-group ">

                                <div class="">

                                    <div class="form-grup has-default">
                                        <label class="control-label" for="seleccione">Seleccione: <span class="text-muted">Solo archivos de extensión</span> <span class="badge">.ch</span></label>
                                        <input type="file" accept=".ch" class="dropdown-toggle btn btn-default" name="rutaArchivo" /> <br>
                                    </div> 
                                    <button class="btn btn-default btn-lg dropdown-toggle" type="submit" value="Instalar">
                                        <span class="glyphicon glyphicon-folder-open" aria-hidden="true">
                                            Instalar
                                        </span> 
                                    </button>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>
            </div>
        </form>
        <!--FIN DEL MODAL Instalar -->
    </body>
</html>
