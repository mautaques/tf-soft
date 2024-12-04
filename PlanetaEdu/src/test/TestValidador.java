package test;

import main.Validador;

import main.Professor;
import main.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestValidador {
    @Test
    public void testValidarCPF() {
        Boolean validate = Validador.validarCPF("12345678900");

        assertEquals(true, validate);

    }

    @Test
    public void testValidarCPF_Null() {
        // CPF nulo
        String cpf = null;
        assertFalse(Validador.validarCPF(cpf));
    }

    @Test
    public void testAutenticar_UsuarioESenhaValidos() {
        Usuario usuario = new Usuario("Marcio Alves", "senha123", "usuario1@gmail.com", "123456789", "Rua G, 456", "marcioalves", "senha123");
        String usuarioInput = "marcioalves";
        String senhaInput = "senha123";

        // Testa autenticação válida
        assertTrue(Validador.autenticar(usuarioInput, senhaInput, usuario));
    }
}