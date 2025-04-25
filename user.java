package test;

public class user { 

  
  
 public String login(String user) 
 { 
 String message=null; 
  
  if (user.equalsIgnoreCase("admin")) 
  { 
   message="valid user"; 
  } 
  else  
  { 
   message="invalid user"; 
  } 

  return message; 
 
} 
                 } 