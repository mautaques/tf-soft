package test;

import main.Aula;
import main.Professor;
import test.TestProfessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAula {
    @Test
    public void testCriacaoAula() {
        Professor professor = TestProfessor.get();
        Aula aula = new Aula("Educação Ambiental", "Ciências Biológicas", false, 100.00, professor);

        assertEquals("Educação Ambiental", aula.getNome());
        assertEquals("Ciências Biológicas", aula.getAreaEnsino());
        assertEquals(false, aula.isGratuita());
        assertEquals(100.00, aula.getValor(), 0.001);
        assertEquals(professor, aula.getProfessor());
    }

    @Test
    public void testAulaGratuitaComValorZero() {
        Professor professor = TestProfessor.get();
        Aula aula = new Aula("Educação Ambiental", "Ciências Biológicas", true, 0.00, professor);

        assertTrue(aula.isGratuita());
        assertEquals(0.00, aula.getValor(), 0.001);
    }

    @Test
    public void testAlteracaoValorAula() {
        Professor professor = TestProfessor.get();
        Aula a = new Aula("Educação Ambiental", "Ciências Biológicas", false, 100.00, professor);

        // Alterando o valor da aula
        a.setValor(120.00);
        assertEquals(120.00, a.getValor(), 0.001);
    }
}