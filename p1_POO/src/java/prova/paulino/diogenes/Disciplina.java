/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.paulino.diogenes;

import java.sql.*;
import java.util.ArrayList;
import web.DbListener;

/**
 *
 * @author Diogenes P. <your.name at your.org>
 */
public class Disciplina {
    private String nome;
    private String ementa;
    private int ciclo;
    private double nota;
    private ArrayList<Disciplina> Lista = new ArrayList<Disciplina>();
    
    public Disciplina(String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }

    public Disciplina(String nome, String ementa, int ciclo, double nota) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the ementa
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     * @param ementa the ementa to set
     */
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    /**
     * @return the ciclo
     */
    public int getCiclo() {
        return ciclo;
    }

    /**
     * @param ciclo the ciclo to set
     */
    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * @return the nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(double nota) {
        this.nota = nota;
    }
    public static ArrayList<Disciplina> getList() throws Exception{
        ArrayList<Disciplina> list = new ArrayList<>();
        Connection con = DbListener.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM disciplina");
        while(rs.next()){
            list.add(new Disciplina(
                    rs.getString("nome"),
                    rs.getString("ementa"),
                    rs.getInt("ciclo"),
                    rs.getDouble("nota")
            ));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }
    public static void addNota(String nome, double nota) throws Exception{
        Connection con = DbListener.getConnection();
        PreparedStatement stmt = con.prepareStatement
        ("UPDATE disciplina SET nota = ? WHERE nome = ?");        
        stmt.setDouble(1,nota);
        stmt.setString(2,nome);
        stmt.execute();
        stmt.close();
        con.close();
    }
    public static void addDisciplina(String nome, String ementa, int ciclo) throws Exception{
        Connection con = DbListener.getConnection();
        PreparedStatement stmt = con.prepareStatement
        ("INSERT INTO disciplina(nome, ementa, ciclo) VALUES (?,?,?)");        
        stmt.setString(1,nome);
        stmt.setString(2,ementa);
        stmt.setInt(3,ciclo);
        stmt.execute();
        stmt.close();
        con.close();
    }
    public static void RemoverDisciplina(String nome) throws Exception{
        Connection con = DbListener.getConnection();
        PreparedStatement stmt = con.prepareStatement
        ("DELETE FROM disciplina WHERE nome = ?");
        stmt.setString(1,nome);
        stmt.execute();
        stmt.close();
        con.close();
    }
     public static String getCreateStatement(){
        return "CREATE TABLE IF NOT EXISTS disciplina("
                + "nome VARCHAR(50) UNIQUE NOT NULL,"
                + "ementa TEXT NOT NULL,"
                + "ciclo INT(1) NOT NULL,"
                + "nota DOUBLE(2.2) NOT NULL DEFAULT 0"
                + ");";
    }
}
