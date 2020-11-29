<%-- 
    Document   : index
    Created on : 3 de out de 2020, 17:46:53
    Author     : Diogenes P. <your.name at your.org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="prova.paulino.diogenes.Disciplina" %>
<% int num = Disciplina.getList().size(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h1>Nome: Diogenes Paulino</h1>
        <h1>RA: 1290481912037</h1>
        <h1>Quantidade de disciplinas: <%= num %></h1>
    </body>
</html>
