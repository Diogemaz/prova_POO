/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.paulino.diogenes;

import java.util.ArrayList;

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
    public ArrayList<Disciplina> getList(){
        return Lista;
    }
    public void addList(Disciplina disciplina){
        Lista.add(new Disciplina(disciplina.getNome(), disciplina.getEmenta(), disciplina.getCiclo()));
    }
    public void addNota(int indice, double nota){
        Lista.get(indice).setNota(nota);
    }
}
