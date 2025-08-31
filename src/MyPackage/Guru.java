package MyPackage;

public class Electricity{ 


public static void main(String[] args){

       int a = 100;
       int b = 2000;
       int c = 1500;

       int d = (a>b)? (a>c)? a:c : (b>c)? b:c ;
       //int d =(a>b)? (a>c)? a:(c>b)? c:b : (b>c)? b:c ;
       
       System.out.println(d);
}
    
    }