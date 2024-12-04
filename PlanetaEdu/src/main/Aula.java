package main;

import java.util.ArrayList;
import java.util.List;

public class Aula {
    private String nome;
    private String areaEnsino;
    private boolean gratuita;
    private double valor;
    private Professor professor;
    private List<Avaliacao> avaliacoes;
    private List<Usuario> usuariosQueAssistiram;

    public Aula(String nome, String areaEnsino, boolean gratuita, double valor, Professor professor) {
        this.nome = nome;
        this.areaEnsino = areaEnsino;
        this.gratuita = gratuita;
        this.valor = gratuita ? 0.0 : valor;
        this.professor = professor;
        this.avaliacoes = new ArrayList<>();
        this.usuariosQueAssistiram = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getAreaEnsino() {
        return areaEnsino;
    }

    public Professor getProfessor() {
        return professor;
    }

    public boolean isGratuita() {
        return gratuita;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAreaEnsino(String areaEnsino) {
        this.areaEnsino = areaEnsino;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setGratuita(boolean gratuita) {
        this.gratuita = gratuita;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Registrar que um usuário assistiu à aula
    public void registrarVisualizacao(Usuario usuario) {
        if (!usuariosQueAssistiram.contains(usuario)) {
            usuariosQueAssistiram.add(usuario);
        }
    }

    // Verificar se o usuário assistiu à aula
    public boolean usuarioAssistiu(Usuario usuario) {
        return usuariosQueAssistiram.contains(usuario);
    }

    // Adicionar uma avaliação
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (usuarioAssistiu(avaliacao.getUsuario())) {
            avaliacoes.add(avaliacao);
            professor.recalcularAvaliacaoGeral(); // Atualiza a média do professor
        } else {
            throw new IllegalStateException("O usuário não assistiu à aula e não pode avaliá-la.");
        }
    }

    // Calcular a média das avaliações
    public double calcularMediaAvaliacoes() {
        return avaliacoes.stream().mapToInt(Avaliacao::getNota).average().orElse(0);
    }
}
