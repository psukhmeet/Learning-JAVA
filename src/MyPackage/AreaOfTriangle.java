package MyPackage;

import java.util.*;
import java.math.*;
public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Program of Finding Area of Any Triangle");

        System.err.println("ENTER length of 1st Side: ");
        int side1 = input.nextInt();
        System.err.println("ENTER length of 2nd Side: ");
        int side2 = input.nextInt();
        System.err.println("ENTER length of 3rd Side: ");
        int side3 = input.nextInt();
        
        if(side1+side2>side3 || side2+side3>side1 || side1+side3>side2){

            double s = (side1+side2+side3)/2;

            double area = s*(s-side1)*(s-side2)*(s-side3);

            double result = Math.sqrt(area);

            System.out.println("AREA IS: " + result);
        }else{
            System.err.println("TRIANGLE IS NOT POSSIBLE");
        }
        
        
    
    }
}
