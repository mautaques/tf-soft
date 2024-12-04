package test;

import main.Professor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestProfessor {
    public static Professor get() {
        return null;
    }

    @Test
    public void testCriacaoProfessor() {
        Professor professor = new Professor("Mauro Oliveira", "12345678923", "mauro@email.com",
                "123456798", "Rua B, 567", "maurooliveira", "senha567", "Ciências Biológicas", "Doutorado em biologia", "123456789-0");

        assertEquals("Mauro Oliveira", professor.getNomeCompleto());
        assertEquals("12345678923", professor.getCpf());
        assertEquals("mauro@email.com", professor.getEmail());
        assertEquals("maurooliveira", professor.getUsuario());
        assertEquals("senha567", professor.getSenha());
        assertEquals("Ciências Biológicas", professor.getAreaAtuacao());
        assertEquals("Doutorado em biologia", professor.getComprovanteQualificacao());
        assertEquals("123456789-0", professor.getContaBancaria());
    }

}
