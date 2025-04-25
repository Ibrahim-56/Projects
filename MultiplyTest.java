package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplyTest {

	@Test
	public void testMultiply() {
		junit test = new junit();
				   int result = test.multiply(3, 4);
				   assertEquals(12, result); }
	
	@Test	public void testMultiplys() {
						junit test = new junit();
								   int result = test.multiply(9, 9);
								   assertEquals(81, result); }
  @Test	public void testMultiplyz() {
					     junit test = new junit();
                            int result = test.multiply(4, 5);
					               assertEquals(20, result); }
  @Test	public void testMultiplysis() {
	     junit test = new junit();
         int result = test.multiply(55, 5);
	               assertEquals(275, result); }
  @Test	public void testMultiplyers() {
	     junit test = new junit();
         int result = test.multiply(20, 20);
	               assertEquals(400, result); }
  @Test	public void testMultiplyer() {
	     junit test = new junit();
         int result = test.multiply(11, 5);
	               assertEquals(55, result); }
  @Test	public void testMultiplyen() {
	     junit test = new junit();
         int result = test.multiply(52, 7);
	               assertEquals(364, result);
				   
	}

}
