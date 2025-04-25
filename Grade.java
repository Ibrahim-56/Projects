package test;
public class Grade {
public char determinGrade(int grade) {
if (grade < 0) {
throw new IllegalArgumentException ("number can't be less then zero");
               }
else if (grade <60) {
return 'F';
                     }
else if (grade <70) {
return 'D';
                     }
else if (grade <80) {
return 'C';
                    }
else if (grade <90) {
return 'B';
               }
else {
return 'A';
         }
                                        }
                  }
