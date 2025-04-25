package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class CulculationTest {
Calculation c= new Calculation();
@Test
public void testFindMax(){
int [] arr= {1,3,4,2};
 assertEquals(4,c.findMax(arr));


}
@Test
public void testFindMax2(){
int [] arr2= {-12,1,-3,-4,-2};
 assertEquals(1,c.findMax(arr2));
}
@Test
public void testFindMax2Edit(){
int [] arr2= {-12,-1,-3,-4,-2};
 assertEquals(-1,c.findMaxeEdit(arr2));
}
 @Test
 public void testReverseWord(){
 assertEquals("ila",c.reverseWord("ali"));
 }
}