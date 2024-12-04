package test;

import main.Aula;
import main.Curso;

import main.Professor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestCurso{

    private Curso curso;
    private Professor professor1;
    private Professor professor2;
    private Aula aula;

    @Before
    public void setUp() {
        curso = new Curso("Java Básico", "Curso introdutório de Java", 100.0, false);
        professor1 = new Professor(
                "Maria Silva",
                "123.456.789-01",
                "maria.silva@email.com",
                "(11) 91234-5678",
                "Rua Exemplo, 456",
                "mariasilva",
                "senha123",
                "Programação",
                "Certificado",
                "654321-0"
        );
        professor2 = new Professor(
                "Carlos Souza",
                "987.654.321-00",
                "carlos.souza@email.com",
                "(11) 92345-6789",
                "Rua Exemplo, 789",
                "carlossouza",
                "senha123",
                "Programação",
                "Certificado",
                "789456-1"
        );
        aula = new Aula("Introdução", "Programação", true, 20.00, professor1);
    }

    @Test
    public void testGetNome() {
        assertEquals("Java Básico", curso.getNome());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Curso introdutório de Java", curso.getDescricao());
    }

    @Test
    public void testGetValor() {
        assertEquals(100.0, curso.getValor(), 0.0);
    }

    @Test
    public void testIsGratuito() {
        assertFalse(curso.isGratuito());

        Curso cursoGratuito = new Curso("Python Básico", "Curso gratuito de Python", 200.0, true);
        assertTrue(cursoGratuito.isGratuito());
        assertEquals(0.0, cursoGratuito.getValor(), 0.0);
    }

    @Test
    public void testAdicionarProfessor() {
        assertTrue(curso.adicionarProfessor(professor1));
        assertFalse(curso.adicionarProfessor(professor1)); // Não pode adicionar duplicado
        assertTrue(curso.adicionarProfessor(professor2));

        List<Professor> professores = curso.getProfessores();
        assertEquals(2, professores.size());
        assertTrue(professores.contains(professor1));
        assertTrue(professores.contains(professor2));
    }

    @Test
    public void testAdicionarAula() {
        curso.adicionarAula(aula);
        assertEquals(1, curso.getAulas().size());
        assertEquals(aula, curso.getAulas().get(0));
    }

    @Test
    public void testGetProfessores() {

        assertEquals(0, curso.getProfessores().size());
        curso.adicionarProfessor(professor1);
        assertEquals(1, curso.getProfessores().size());
    }

    @Test
    public void testGetAulas() {
        assertEquals(0, curso.getAulas().size());
        curso.adicionarAula(aula);
        assertEquals(1, curso.getAulas().size());
    }


}