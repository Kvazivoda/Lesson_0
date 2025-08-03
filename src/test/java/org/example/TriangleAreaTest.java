import org.example.TriangleArea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    @Test
    void testAreaWithPositiveNumbers() {
        assertEquals(10.0, TriangleArea.calculate(5, 4));
    }

    @Test
    void testAreaWithDecimalNumbers() {
        assertEquals(3.75, TriangleArea.calculate(2.5, 3));
    }

    @Test
    void testAreaWithZeroHeight() {
        assertEquals(0.0, TriangleArea.calculate(10, 0));
    }

    @Test
    void testAreaWithNegativeBase() {
        assertThrows(IllegalArgumentException.class, () ->
                TriangleArea.calculate(-5, 4));
    }
}
