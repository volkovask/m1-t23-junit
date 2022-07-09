package notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationCalculatorTest {

    ReversePolishNotationCalculator reversePolishNotationCalculator =
             new ReversePolishNotationCalculator();

    @Test
    public void shouldCalculateAddition() {
        Assertions.assertEquals(9, reversePolishNotationCalculator.calculatePolishNotation("5 4 +"));
    }

    @Test
    public void shouldCalculateSubtraction() {
        int result = reversePolishNotationCalculator.calculatePolishNotation("4 3 -");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void shouldCalculateMultiplication() {
        int result = reversePolishNotationCalculator.calculatePolishNotation("5    4 -3 * *");
        Assertions.assertEquals(-60, result);
    }

}