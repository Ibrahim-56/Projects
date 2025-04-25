package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConcateTest {

	@Test
	public void testConcatenate() {
		junit test = new junit();
	   String result = test.concatenate("one", "two");
	   assertEquals("onetwo", result); 
	}

}
