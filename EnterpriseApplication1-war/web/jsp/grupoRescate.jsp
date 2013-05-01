<%-- 
    Document   : grupoRescate
    Created on : Apr 30, 2013, 3:45:43 PM
    Author     : JuanM
--%>

<%@page import="EnterpriseApplication1.entity.Gruporescate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <base href="<%=basePath%>">
        <meta charset="utf-8" />
        <title>Grupos de Rescate</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <h1 class="text-center">Gesti&oacuten de Grupos de Rescate</h1>
        <% List<Gruporescate> grupos = (List<Gruporescate>) request.getAttribute("grupos");
           List<Integer> numusers = (List<Integer>) request.getAttribute("numusers");
           int cont = 0;%>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <div class="container">
            <div class="row">
                <div class="span6 offset1">
                    <table class="table table-striped table-bordered table-hover">
                        <caption>Grupos de Rescate</caption>
                        <thead>
                            <tr>
                                <th>Select</th>
                                <th>Id</th>
                                <th>N&#176 usuarios</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Gruporescate gr : grupos) {%>
                            <tr>
                                <td>
                                    <label class="radio">
                                        <input type="radio" name="optionsRadios" id="optionsRadios<%System.out.print(cont);%>" value="option<%System.out.print(cont);%>">
                                    </label>
                                </td>
                                <td><%= gr.getIdgrupoRescate().toString() %>
                                </td>
                                <td><%= numusers.get(cont++) %>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <div class="span3 offset1">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Acci&oacuten</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <button class="btn" type="button">Crear<i class="icon-plus"></i>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button class="btn" type="button">Eliminar<i class="icon-remove"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button class="btn" type="button">Ver<i class="icon-eye-open"></i></button>
                                </td>
                            </tr>
                            <tr><td>
                                    <button class="btn" type="button">Modificar<i class="icon-wrench"></i></button>  	
                                </td>
                            </tr>
                        </tbody>
                    </table>				
                </div>
            </div>	 
            <div class="row offset1">
                <button class="btn btn-info"  type="button" href="usuariosGrupoRescate"> Ver lista de usuarios
                </button>
                
                <button class="btn btn-primary offset2"  type="button">Volver
                </button>
            </div>
        </div>
    </body>
</html>
