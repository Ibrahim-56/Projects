package test;
import java.util.StringTokenizer;
public class Calculation {

 public int findMax(int arr[]){

 int max=0;
 for(int i=1;i<arr.length;i++){
 if(max<arr[i])
 max=arr[i];
 }
 return max;
 }



 public int findMaxeEdit(int arr[]){

 int max=arr[0];
 for(int i=1;i<arr.length;i++){
 if(max<arr[i])
 max=arr[i];
 }
 return max;
 }


 public String reverseWord(String str){

 StringBuilder result=new StringBuilder();
 StringTokenizer tokenizer=new StringTokenizer(str," ");

 while(tokenizer.hasMoreTokens()){
 StringBuilder sb=new StringBuilder();
 sb.append(tokenizer.nextToken());
 sb.reverse();

 result.append(sb);
 result.append("");
 }
 return result.toString();
 }
}