package test;

import main.Aluno;
import main.Usuario;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestUsuario {
    public static Usuario get() {
        return null;
    }

    @Test
    public void testNomeUsuario() {
        Usuario usuario = new Usuario("João Silva", "12345678900", "joao@email.com", "123456789", "Rua A, 123", "joaosilva", "senha123");

        assertEquals("João Silva", usuario.getNomeCompleto());
        assertEquals("12345678900", usuario.getCpf());
        assertEquals("joao@email.com", usuario.getEmail());
        assertEquals("joaosilva", usuario.getUsuario());
        assertEquals("senha123", usuario.getSenha());
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
