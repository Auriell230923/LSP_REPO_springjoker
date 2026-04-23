package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    @Test
    public void testAverage() {
        GradeCalculator calc = new GradeCalculator();
        assertEquals(90.0, calc.average(80, 90, 100), 0.001);
    }

    @Test
    public void testLetterGrade() {
        GradeCalculator calc = new GradeCalculator();
        double avg = calc.average(90, 95, 100);
        assertEquals("A", calc.letterGrade(avg));
    }

    @Test
    public void testIsPassing() {
        GradeCalculator calc = new GradeCalculator();
        double avg = calc.average(60, 60, 60);
        assertTrue(calc.isPassing(avg));
    }

    @Test
    public void testPassingBoundaryValue() {
        GradeCalculator calc = new GradeCalculator();
        assertTrue(calc.isPassing(60.0));
    }

    @Test
    public void testFailingBoundaryValue() {
        GradeCalculator calc = new GradeCalculator();
        assertFalse(calc.isPassing(59.9));
    }

    @Test
    public void testAverageThrowsExceptionForNegativeScore() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.average(-1, 90, 100);
        });
    }

    @Test
    public void testAverageThrowsExceptionForScoreOverOneHundred() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.average(80, 90, 101);
        });
    }
}