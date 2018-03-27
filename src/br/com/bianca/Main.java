/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bianca;

import br.com.bianca.Escola.Aluno;
import br.com.bianca.Escola.Disciplina;
import br.com.bianca.Escola.Pessoa;
import br.com.bianca.Escola.Professor;
import java.awt.AWTEventMulticaster;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author bianca.149817
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        int escMenu = 0;
        int escolhaC = 0;
        int escolhaN = 0;
        ArrayList<Disciplina> materias = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Professor> prof = new ArrayList<>();

        do {
            escMenu = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções/; \n"
                    + "1. Cadastro Disciplinas: \n"
                    + "2. Cadastro de Alunos: \n"
                    + "3. Cadastro de Professores: \n"
                    + "4. Consultar por código: \n"
                    + "5. Colsultar por nome: \n"
                    + "6. Sair"));
            switch (escMenu) {
                case 1: {
                    do {
                        String Nome = JOptionPane.showInputDialog("Informe o Nome da Disciplina: ");
                        String departamento = JOptionPane.showInputDialog("Informe o Departamento: ");
                        char status = JOptionPane.showInputDialog("Informe o Status: ").charAt(0);
                        materias.add(new Disciplina(Nome, departamento, status));

                    } while ((JOptionPane.showConfirmDialog(null, "Deseja continuar a cadastrar a Disciplina?")) == 0);
                    break;
                }
                case 2: {
                    do {
                        int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matricula do Aluno: "));
                        String nome = JOptionPane.showInputDialog("Informe o nome do Aluno: ");
                        String rg = JOptionPane.showInputDialog("Informe o RG do Aluno: ");
                        String cpf = JOptionPane.showInputDialog("Informe o CPF do Aluno:");

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataM = sdf.parse(JOptionPane.showInputDialog("Informe a data de Matricula do Aluno: "));
                        Date data = sdf.parse(JOptionPane.showInputDialog("Informe a data de Nascimento do Aluno: "));

                        alunos.add(new Aluno(matricula, dataM, nome, rg, cpf, data));

                        if (JOptionPane.showConfirmDialog(null, "O aluno já se matriculou em alguma disciplina?") == 0) {
                            String materiasExistentes = " ";
                            for (Disciplina materia : materias) {
                                materiasExistentes += materias.indexOf(materia) + " " + materia.getNome() + "\n";
                            }
                            do {
                                int esc = Integer.parseInt(JOptionPane.showInputDialog("-- Informe a matéria -- \n" + materiasExistentes));
                                alunos.get(alunos.size() - 1).getDisciplina().add(materias.get(esc));
                            } while ((JOptionPane.showConfirmDialog(null, "Tem outra matéria para cadastrar?")) == 0);

                        }

                    } while ((JOptionPane.showConfirmDialog(null, "Deseja continuar a cadastrar o Aluno?")) == 0);
                    break;
                }

                case 3: {
                    do {
                        String nome = JOptionPane.showInputDialog("Informe o nome do Professor: ");
                        String rg = JOptionPane.showInputDialog("Informe o RG do Professor: ");
                        String cpf = JOptionPane.showInputDialog("Informe o CPF do Professor:");

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataNascimento = sdf.parse(JOptionPane.showInputDialog("informe a data de Nascimento do Professor: "));

                        int cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Informe a carga horaria: "));
                        float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da Hora: "));

                        prof.add(new Professor(cargaHoraria, valorHora, nome, rg, cpf, dataNascimento));
                        if (JOptionPane.showConfirmDialog(null, "O Professor já se matriculou em alguma disciplina?") == 0) {
                            String materiasExistentes = " ";
                            for (Disciplina materia : materias) {
                                materiasExistentes += materias.indexOf(materia) + " " + materia.getNome() + "\n";
                            }
                            do {
                                int esc = Integer.parseInt(JOptionPane.showInputDialog("-- Informe a matéria -- \n" + materiasExistentes));
                                alunos.get(alunos.size() - 1).getDisciplina().add(materias.get(esc));
                            } while ((JOptionPane.showConfirmDialog(null, "Tem outra matéria para cadastrar?")) == 0);

                        }

                    } while ((JOptionPane.showConfirmDialog(null, "Deseja continuar a cadastrar o Professor?")) == 0);
                    break;

                }
                case 4: {
                    do {
                        escolhaC = Integer.parseInt(JOptionPane.showInputDialog("Consultar por código: \n"
                                + "1. Consultar Disciplina; \n "
                                + "2. Consultar Alunos: \n"
                                + "3. Consultar Professores: \n"
                                + "4. Sair \n"));
                        switch (escolhaC) {
                            case 1: {
                                do {
                                    JOptionPane.showConfirmDialog(null, materias.toString());

                                } while ((JOptionPane.showConfirmDialog(null, "Deseja continuar ?")) == 0);
                                break;
                            }
                            case 2: {
                                JOptionPane.showConfirmDialog(null, alunos.toString());

                            }
                            while ((JOptionPane.showConfirmDialog(null, "Deseja continuar a consultar o Aluno?")) == 0);
                            break;

                            case 3: {
                                JOptionPane.showConfirmDialog(null, prof.toString());

                            }
                            while ((JOptionPane.showConfirmDialog(null, "Deseja continuar a consultar o Professor?")) == 0);
                            break;

                        }
                    } while (escolhaC != 4);
                }
                case 5:{
                     do {
                        escolhaN = Integer.parseInt(JOptionPane.showInputDialog("Consultar por nome: \n"
                                + "1. Consultar Disciplina: \n "
                                + "2. Consultar Alunos: \n"
                                + "3. Consultar Professores: \n"
                                + "4. Sair \n"));
                        switch (escolhaN) {
                            case 1: {
                                do {
                                    String matExistente = " ";                                        
                                    for (Disciplina materia : materias) {
                                        matExistente += "\n" + materias.indexOf(materia) + " : " + materia.getNome();                                
                                    }
                                    int inf = Integer.parseInt(JOptionPane.showInputDialog("Informe a matéria que deseja:"+ matExistente));
                                     JOptionPane.showConfirmDialog(null, materias.get(inf).toString());
                                    
                                } while ((JOptionPane.showConfirmDialog(null, "Deseja continuar a consultar a Disciplina?")) == 0);
                                break;
                            }
                            case 2: {
                                 String aluExistente = " ";   
                                for (Aluno aluno : alunos) {
                                     aluExistente += "\n" + alunos.indexOf(aluno) + " : " + aluno.getNome();
                                    }
                                int inf = Integer.parseInt(JOptionPane.showInputDialog("Informe a matéria que deseja:"+ aluExistente));
                                     JOptionPane.showConfirmDialog(null, alunos.get(inf).toString());

                            }while ((JOptionPane.showConfirmDialog(null, "Deseja continuar a consultar o Aluno?")) == 0);
                            break;

                            case 3: {
                                 String profExistente = " ";   
                                for (Professor professor : prof) {
                                  profExistente += "\n" + prof.indexOf(professor) + " : " + professor.getNome();
                                }
                                int inf = Integer.parseInt(JOptionPane.showInputDialog("Informe a matéria que deseja:"+ profExistente));
                                     JOptionPane.showConfirmDialog(null, prof.get(inf).toString());
                            }
                            while ((JOptionPane.showConfirmDialog(null, "Deseja continuar a consultar o Professor?")) == 0);
                            break;
                         }         
                     }while (escolhaN != 4);
                }
            }

        } while (escMenu != 6);

    }
}
