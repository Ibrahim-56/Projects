package sdr;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class factorialTest {
factorial fact= new factorial();
@Test
void test() {
assertEquals(120,fact.getfact(5));
assertEquals(1,fact.getfact(1));
assertEquals(1,fact.getfact(0));
assertEquals(15,fact.getSum(5));
assertEquals(-1,fact.getSum(0));
// assertEquals(1,fact.getSum(1));
}
}
