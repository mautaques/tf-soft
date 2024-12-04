package main;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String descricao;
    private double valor;
    private boolean gratuito;
    private List<Professor> professores;
    private List<Aula> aulas;

    public Curso(String nome, String descricao, double valor, boolean gratuito) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = gratuito ? 0.0 : valor;
        this.gratuito = gratuito;
        this.professores = new ArrayList<>();
        this.aulas = new ArrayList<>();
    }

    // Getter e Setters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    // Adicionar professor
    public boolean adicionarProfessor(Professor professor) {
        // Evitar duplicidade de professor
        for (Professor p : professores) {
            if (p.equals(professor)) {
                return false; // Professor já é proprietário do curso
            }
        }
        professores.add(professor);
        return true;
    }

    // Adicionar aula
    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }

}
