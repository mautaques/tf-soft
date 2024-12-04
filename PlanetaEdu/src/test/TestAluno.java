package test;

import main.Aluno;
import static org.junit.Assert.assertEquals;

import main.Aula;
import main.Professor;
import org.junit.Test;

public class TestAluno {
    @Test
    public void testCriacaoAluno() {
        Aluno aluno = new Aluno("João Silva", "12345678900", "joao@email.com",
                "123456789", "Rua A, 123", "joaosilva", "senha123", "01/01/2000");

        assertEquals("João Silva", aluno.getNomeCompleto());
        assertEquals("12345678900", aluno.getCpf());
        assertEquals("01/01/2000", aluno.getDataNascimento());
        assertEquals("joao@email.com", aluno.getEmail());
        assertEquals("senha123", aluno.getSenha());
    }

    @Test
    public void testAlteracaoEmailAluno() {
        Aluno aluno = new Aluno("João Silva", "12345678900", "joao@email.com",
                "123456789", "Rua A, 123", "joaosilva", "senha123", "01/01/2000");

        // Alterando o valor do email
        aluno.setEmail("guilherme@email.com");
        assertEquals("guilherme@email.com", aluno.getEmail());
    }
}
