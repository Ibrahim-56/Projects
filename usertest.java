package test;
import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test; 
 
class usertest { 
 
 user u1= new user(); 
  
 @Test 
 void test1() { 
   
  assertEquals("valid user",u1.login("admin")); 
 } 
  
  
 @Test 
 void test2() { 
   
  assertEquals("invalid user",u1.login("ahmad")); 
               } 
  
@Test 
void testwithNumber() { 
assertEquals("invalid user",u1.login("123")); 
                     } 
@Test 
void testwithCapital() { 
assertEquals("valid user",u1.login("ADMIN")); 
                            } 
}
