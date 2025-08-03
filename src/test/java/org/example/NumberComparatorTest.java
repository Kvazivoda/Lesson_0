import org.example.NumberComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void testFirstGreater() {
        assertEquals("5 > 3", NumberComparator.compare(5, 3));
    }

    @Test
    void testSecondGreater() {
        assertEquals("2 < 4", NumberComparator.compare(2, 4));
    }

    @Test
    void testEqualNumbers() {
        assertEquals("7 == 7", NumberComparator.compare(7, 7));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals("-3 > -5", NumberComparator.compare(-3, -5));
    }
}