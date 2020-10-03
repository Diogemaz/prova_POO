<%-- 
    Document   : disciplina
    Created on : 3 de out de 2020, 18:03:01
    Author     : Diogenes P. <your.name at your.org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="prova.paulino.diogenes.Disciplina" %>
<%
    String msg = "";
    double nota;
    int indice;
    Disciplina lista = (Disciplina)application.getAttribute("lista");
    if(lista == null){
        lista = new Disciplina("","",0);
    }
    try{
        nota = Double.parseDouble(request.getParameter("nota"));
        indice = Integer.parseInt(request.getParameter("indice"));
    }catch(Exception e){
        nota = -1;
        indice = -1;
    }
    
    if(nota > -1){
        msg = "Nota não pode ser menor que 0";
        if(nota > 10){
            msg = "Nota não pode ser maior que 10";
        }else {
            msg = "Nota alterada com sucesso";
            lista.addNota(indice, nota);
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disciplinas</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h1>Disciplinas</h1>
        <div><%= msg %></div>
        <table border="1">
            <tr>
                <th>Disciplina</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
            </tr>
            <% for(int i=0; i<lista.getList().size(); i++){ %>
            <tr>
                <% Disciplina item = lista.getList().get(i); %>
                <th><%= item.getNome() %></th>
                <th><%= item.getEmenta() %></th>
                <th><%= item.getCiclo() %></th>
            <form method="get">
                <th><input type="text" name="nota" value="<%= item.getNota() %>"></th>
                <input type="hidden" name="indice" value="<%= i %>">
                <th><input type="submit" value="Adicionar nota"></th>
            </form>
            </tr> 
            <% } %>
        </table>
    </body>
</html>
