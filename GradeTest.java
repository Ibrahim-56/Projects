package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GradeTest {
Grade g= new Grade();
@Test
void case1() {
assertEquals('F', g.determinGrade(59));
}
@Test
void case2() {
assertEquals('D', g.determinGrade(65));
}
@Test
void case3() {
assertEquals('C', g.determinGrade(74));
}
@Test
void case4() {
assertEquals('B', g.determinGrade(80));
}
@Test
void case5() {
assertEquals('A', g.determinGrade(91));
}
/*
 @Test
void case6() {
assertEquals("number can't be less then zero",
g.determinGrade(-1));
}
*/
@Test
void case7() {
assertThrows(IllegalArgumentException.class, () -> {
g.determinGrade(-1);});
}
}