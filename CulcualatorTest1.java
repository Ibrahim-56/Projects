package test.mohammed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

public class CalculatorTest1 {

    CalculatorServices cs = mock(CalculatorServices.class);
    Calculator c = new Calculator(cs);

    @Test
    void test() {
        when(cs.add(3, 2)).thenReturn(5);
        assertEquals(5, c.add(3, 2)); // Assuming c.add(3, 2) should return 5
    }
}
