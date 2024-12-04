package test;

import main.Avaliacao;
import main.Usuario;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestAvaliacao {

    private Usuario usuario;
    private Avaliacao avaliacao;

    @Before
    public void setUp() {
        usuario = new Usuario(
                "João Silva",
                "123.456.789-00",
                "joao.silva@email.com",
                "(11) 98765-4321",
                "Rua Exemplo, 123",
                "joaosilva",
                "senha123"
        );
        avaliacao = new Avaliacao(usuario, 10, "Ótimo trabalho!");
    }

    @Test
    public void testConstrutor() {
        assertEquals(usuario, avaliacao.getUsuario());
        assertEquals(10, avaliacao.getNota());
        assertEquals("Ótimo trabalho!", avaliacao.getComentario());
    }

    @Test
    public void testSetNota() {
        avaliacao.setNota(8);
        assertEquals(8, avaliacao.getNota());
    }

    @Test
    public void testSetComentario() {
        avaliacao.setComentario("Muito bom!");
        assertEquals("Muito bom!", avaliacao.getComentario());
    }
}
