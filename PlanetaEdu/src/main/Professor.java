package main;

public class Professor extends Usuario {
    private String areaAtuacao;
    private String comprovanteQualificacao;
    private String contaBancaria;
    private double avaliacaoGeral;


    public Professor(String nomeCompleto, String cpf, String email, String telefone, String endereco, String usuario, String senha, String areaAtuacao, String comprovanteQualificacao, String contaBancaria) {
        super(nomeCompleto, cpf, email, telefone, endereco, usuario, senha);
        this.areaAtuacao = areaAtuacao;
        this.comprovanteQualificacao = comprovanteQualificacao;
        this.contaBancaria = contaBancaria;
        this.avaliacaoGeral = 0.0;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public String getComprovanteQualificacao() {
        return comprovanteQualificacao;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public double getAvaliacaoGeral() {
        return avaliacaoGeral;
    }

    public void recalcularAvaliacaoGeral() {
        // Simulação de cálculo real
        // Isso depende de obter todas as aulas e calcular as médias
        System.out.println("Recalculando avaliação geral do professor...");
        this.avaliacaoGeral = Math.random() * 5; // Placeholder
    }

}

