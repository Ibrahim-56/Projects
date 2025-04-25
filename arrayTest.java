package Test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class arrayTest {
array obj = new array();
@Test
 public void testAdd() {
 obj.add("Emma");
 obj.add("Ronan");
 obj.add("Antonio");
 obj.add("Paul");
 assertEquals( 4, obj.sizeOfStudent());
 }

 @Test
 public void testSize() {
 obj.add("Emma");
 obj.add("Ronan");
 obj.add("Antonio");
 assertEquals( 3, obj.sizeOfStudent());
 }

 @Test
 public void testRemove() {
 obj.add("Antonio");
 obj.add("Paul");
 obj.remove("Paul");
 assertEquals( 1, obj.sizeOfStudent());
 }
 @Test
 public void removeAll() {
 obj.add("Antonio");
 obj.removeAll();
 assertEquals( 0, obj.sizeOfStudent());
 }


}