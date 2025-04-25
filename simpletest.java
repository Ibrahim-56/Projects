package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class simpletest {
simpleCalculators sc= new simpleCalculators();
@Test
void testCase1() {
//asserEquuaks(Exected, Results)
assertEquals(4, sc.add(2, 2));
}
@Test
void testFiveTimesTwoEqual10() {
assertEquals(10, sc.multiply(5, 2));
}
@Test
void testTwoTimsTwoEqual4() {
assertEquals(4, sc.multiply(2, 2));
}
@Test
void testTwoTimsthreeEqual6() {
// assertTrue ( method == exected) True or False
assertTrue(sc.multiply(2, 3) ==6);
}
}