import org.example.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {

    @Test
    void testAddition() {
        String result = ArithmeticOperations.performOperations(5, 3);
        assertTrue(result.contains("5 + 3 = 8"));
    }

    @Test
    void testSubtraction() {
        String result = ArithmeticOperations.performOperations(10, 4);
        assertTrue(result.contains("10 - 4 = 6"));
    }

    @Test
    void testMultiplication() {
        String result = ArithmeticOperations.performOperations(7, 6);
        assertTrue(result.contains("7 * 6 = 42"));
    }

    @Test
    void testDivision() {
        String result = ArithmeticOperations.performOperations(10, 2);
        assertTrue(result.contains("10 / 2 = 5.0"));
    }

    @Test
    void testDivisionByZero() {
        String result = ArithmeticOperations.performOperations(5, 0);
        assertTrue(result.contains("Деление на ноль невозможно!"));
    }
}
