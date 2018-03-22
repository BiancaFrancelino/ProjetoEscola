/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bianca.Escola;

import java.util.Date;

/**
 *
 * @author bianca.149817
 */
public class Disciplina {

    private String nome, departamento;
    private char status;

    public Disciplina(String nome, String departamento, char status) {
        this.nome = nome;
        this.departamento = departamento;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Disciplinas: \n"
                + "Nome = " + nome
                + "\n Departamento = " + departamento
                + "\n Status = " + status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

}
