package main;

public class Aluno extends Usuario {
    private String dataNascimento;

    public Aluno(String nomeCompleto, String cpf, String email, String telefone, String endereco, String usuario, String senha, String dataNascimento) {
        super(nomeCompleto, cpf, email, telefone, endereco, usuario, senha);
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

}
