/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import prova.paulino.diogenes.Disciplina;

/**
 * Web application lifecycle listener.
 *
 * @author FAMILIA
 */
public class DbListener implements ServletContextListener {
    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:C:\\Users\\FAMILIA\\Desktop\\prova_POO\\disciplina.db";
    
    public static String exceptionMessage = null;
    public static String statusMessage = null;

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL);    
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName(CLASS_NAME);
            con = DriverManager.getConnection(URL);
            stmt = con.createStatement();
            stmt.execute(Disciplina.getCreateStatement());
            if(Disciplina.getList().isEmpty()){
                stmt.execute("INSERT INTO disciplina(nome,ementa,ciclo) "
                + "VALUES('Banco de Dados','Conceitos de Base de Dados. Modelos conceituais de informações. Modelos de Dados: Relacional,  Redes e Hierárquicos. Modelagem de dados - conceitual, lógica e física. Teoria relacional: dependências funcionais e multivaloradas, formas normais. Restrições de integridade e de segurança em Banco de Dados Relacional. Sistemas Gerenciadores de Banco de Dados – objetivo e funções. Linguagens de declaração e de manipulação de dados.',4)");
                stmt.execute("INSERT INTO disciplina(nome,ementa,ciclo) "
                + "VALUES('Engenharia de Software III','Conceitos, evolução e importância de arquitetura de software. Padrões de Arquitetura. Padrões de Distribuição. Camadas no desenvolvimento de software. Tipos de Arquitetura de Software. Visões na arquitetura de software. Modelo de Análise e Projetos. Formas de representação. O processo de desenvolvimento. Mapeamento para implementação. Integração do sistema. Testes: planejamento e tipos. Manutenção. Documentação.',4)");
                stmt.execute("INSERT INTO disciplina(nome,ementa,ciclo) "
                + "VALUES('Programação Orientada a Objetos','Conceitos e evolução da tecnologia de orientação a objetos. Limitações e diferenças entre o paradigma da programação estruturada em relação à orientação a objetos. Conceito de objeto, classe, métodos, atributos, herança, polimorfismo, agregação, associação, dependência, encapsulamento, mensagem e suas respectivas notações na linguagem padrão de representação da orientação a objetos. Implementação de algoritmos orientado a objetos utilizando linguagens de programação. Aplicação e uso das estruturas fundamentais da orientação a objetos.',4)");
                stmt.execute("INSERT INTO disciplina(nome,ementa,ciclo) "
                + "VALUES('Linguagem de Programação IV','Comandos de linguagens usadas na construção e estruturação de sites para a Web, com páginas dinâmi­cas e interativas. Definição de layouts e formatação em geral. Adição de algorítmos usando laços, matrizes, datas, funções e condições. Introdução a Orientação a Objetos utilizando objetos, métodos e propriedades. Integração com Banco de Dados. Exercícios práticos com projeto de criação de sites.',4)");
            }
        }catch(Exception ex){
            exceptionMessage = ex.getLocalizedMessage();
        }finally{
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
