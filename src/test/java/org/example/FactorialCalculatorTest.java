import org.example.FactorialCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculate(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculate(1));
    }

    @Test
    void testFactorialOfFive() {
        assertEquals(120, FactorialCalculator.calculate(5));
    }

    @Test
    void testFactorialOfTen() {
        assertEquals(3628800, FactorialCalculator.calculate(10));
    }
}
