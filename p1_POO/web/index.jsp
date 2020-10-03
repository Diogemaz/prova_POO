<%-- 
    Document   : index
    Created on : 3 de out de 2020, 17:46:53
    Author     : Diogenes P. <your.name at your.org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="prova.paulino.diogenes.Disciplina" %>
<%
    Disciplina obj = (Disciplina)application.getAttribute("lista");
    if(obj == null){
        Disciplina lista = new Disciplina("","",0);
        
        Disciplina bd = new Disciplina("Banco de Dados","Conceitos de Base de Dados. Modelos conceituais de informações. Modelos de Dados: Relacional,  Redes e Hierárquicos. Modelagem de dados - conceitual, lógica e física. Teoria relacional: dependências funcionais e multivaloradas, formas normais. Restrições de integridade e de segurança em Banco de Dados Relacional. Sistemas Gerenciadores de Banco de Dados – objetivo e funções. Linguagens de declaração e de manipulação de dados.",4);
        Disciplina eng = new Disciplina("Engenharia de Software III","Conceitos, evolução e importância de arquitetura de software. Padrões de Arquitetura. Padrões de Distribuição. Camadas no desenvolvimento de software. Tipos de Arquitetura de Software. Visões na arquitetura de software. Modelo de Análise e Projetos. Formas de representação. O processo de desenvolvimento. Mapeamento para implementação. Integração do sistema. Testes: planejamento e tipos. Manutenção. Documentação.",4);
        Disciplina poo = new Disciplina("Programação Orientada a Objetos","Conceitos e evolução da tecnologia de orientação a objetos. Limitações e diferenças entre o paradigma da programação estruturada em relação à orientação a objetos. Conceito de objeto, classe, métodos, atributos, herança, polimorfismo, agregação, associação, dependência, encapsulamento, mensagem e suas respectivas notações na linguagem padrão de representação da orientação a objetos. Implementação de algoritmos orientado a objetos utilizando linguagens de programação. Aplicação e uso das estruturas fundamentais da orientação a objetos.",4);
        Disciplina lp = new Disciplina("Linguagem de Programação IV","Comandos de linguagens usadas na construção e estruturação de sites para a Web, com páginas dinâmi­cas e interativas. Definição de layouts e formatação em geral. Adição de algorítmos usando laços, matrizes, datas, funções e condições. Introdução a Orientação a Objetos utilizando objetos, métodos e propriedades. Integração com Banco de Dados. Exercícios práticos com projeto de criação de sites.",4);
        
        lista.addList(bd);
        lista.addList(eng);
        lista.addList(poo);
        lista.addList(lp);
        
        application.setAttribute("lista", lista);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Nome: Diogenes Paulino</h1>
        <h1>RA: 1290481912037</h1>
        <h1>Quantidade de disciplinas: <% out.print(obj.getList().size());  %></h1>
    </body>
</html>
