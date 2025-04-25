 package sdr;

public class factorial {
public int getfact(int n) {
if (n==0) {
return 1;
}
if (n == 1) { // base case
 return 1;
 }
else {return getfact(n - 1) * n;} // recuersion case
}

 public int getSum(int x) {
 // this the base case
 if (x==0) {
 return -1;

 }

 if (x == 1) {
 return 1;
 } else {
 return x + getSum(x-1);
 }
 }
}