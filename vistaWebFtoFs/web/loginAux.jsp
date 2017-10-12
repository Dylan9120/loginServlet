<%-- 
    Document   : loginAux
    Created on : 29/09/2017, 10:11:31 AM
    Author     : Alumno
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String name = request.getParameter("usuario");
    String pass = request.getParameter("contra");
    String js = "";
    database.cDatos db = new database.cDatos();
    ResultSet res = null;
    boolean done = true;
    
    db.conectar();
    // res = db.consulta("select * from tabla where name = '"+name+"' and pass = '"+pass+"'");
    
    // while(res.next()) {
    if(name.equals("test") && pass.equals("90210")) {
        js = "swal({title: 'Datos correctos', text: 'Bienvenido "+name+"', type: 'success'}).then(function(){window.location.href = 'usr/index.html';});";
        done = false;
    }
    if (done) {
        js = "swal({title: 'Datos incorrectos', text: 'Error "+name+"', type: 'error'}).then(function(){window.location.href = 'login.html';});";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="swal/sweetalert2.min.css" rel="stylesheet" type="text/css"/>
        <script src="swal/sweetalert2.min.js" type="text/javascript"></script>
        <script>
            window.onload = function() {
                <%=js%>
            };
        </script>
    </head>
    <body>
    </body>
</html>