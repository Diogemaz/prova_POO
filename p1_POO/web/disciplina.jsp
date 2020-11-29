<%-- 
    Document   : disciplina
    Created on : 3 de out de 2020, 18:03:01
    Author     : Diogenes P. <your.name at your.org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="prova.paulino.diogenes.Disciplina" %>
<%
    String msg = "";
    double nota = 0;
    String nome = "";
    String ementa = "";
    int ciclo = 0;
    if(request.getParameter("formNota")!= null ){
        try{
            nota = Double.parseDouble(request.getParameter("nota"));
            nome = request.getParameter("nome");
            msg = "parametros enviados.";
        }catch(Exception e){
            nota = -1;
            nome = "";
        }

        if(nota > -1){
            msg = "Nota não pode ser menor que 0";
            if(nota > 10){
                msg = "Nota não pode ser maior que 10";
            }else {
                msg = "Nota alterada com sucesso";
                Disciplina.addNota(nome, nota);
            }
        }
    }
    if(request.getParameter("remover")!=null){
         try{
            nome = request.getParameter("nome");
            Disciplina.RemoverDisciplina(nome);
            msg = "Disciplina foi removida";
            response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            msg=e.getLocalizedMessage();
        }
    }
    if(request.getParameter("formDisciplina")!=null){
         try{
            nome = request.getParameter("nomeDisciplina");
            ementa = request.getParameter("ementa");
            ciclo = Integer.parseInt(request.getParameter("ciclo"));
            Disciplina.addDisciplina(nome, ementa, ciclo);
            msg = "Disciplina foi Adicionada.";
            response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            msg=e.getLocalizedMessage();
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
            <% for(int i=0; i<Disciplina.getList().size(); i++){ %>
            <tr>
                <% Disciplina item = Disciplina.getList().get(i); %>
                <th><%= item.getNome() %></th>
                <th><%= item.getEmenta() %></th>
                <th><%= item.getCiclo() %></th>
            <form method="get">
                <th><input type="text" name="nota" value="<%= item.getNota() %>"></th>
                <input type="hidden" name="nome" value="<%= item.getNome() %>">
                <th><input type="submit" name="formNota" value="Adicionar nota"></th>
                <th><input type="submit" name="remover" value="Remover disciplina"></th>
            </form>
            </tr> 
            <% } %>
        </table>
        <fieldset>
            <legend>Adicionar disciplina</legend>
            <form method="POST">
                <div>Nome da disciplina:</div>
                <div><input type="text" name="nomeDisciplina"></div>
                <div>Ementa:</div>
                <div><input type="text" name="ementa"></div>
                <div>Ciclo:</div>
                <div><input type="text" name="ciclo"></div>
                <input type="submit" name="formDisciplina" value="Adicionar">
            </form>
        </fieldset>
    </body>
</html>
