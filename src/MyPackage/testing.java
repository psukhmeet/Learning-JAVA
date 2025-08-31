package MyPackage;
import java.util.*;

public class testing {
    
    public static void triangleBasedOnSide(int side1, int side2, int side3){
        if(side1+side2>side3 && side2+side3>side1 && side1+side3>side2){

            if(side1==side2 && side1==side3){
                System.out.println("Triangle is:  Triangle");
            }else if(side1==side2 || side2==side3 || side3==side1){
                System.out.println("Triangle is: Isosceles Traingle");
            }else if(side1*side1+side2*side2-side3*side3==0 || side2*side2+side3*side3-side1*side1==0 || side3*side3+side1*side1-side2*side2==0){
                System.err.println("Triangle is: Right Angle Triangle");
            }else{
                System.out.println("Triangle is: Scalene Triangle");
            }
        }else{
            System.out.println("Triangle is NOT POSSIBLE, Try with another sides");
        }
    }
        
    public static void triangleBasedOnAngle(int angle1, int angle2, int angle3){
        if(angle1!=0 && angle2!=0 && angle3!=0){
            if(angle1==60 && angle2==60 && angle3==60){
                System.out.println("Triangle is: Equilateral Triangle");
            }else if(angle1==angle2 || angle2==angle3 || angle1==angle3){
                System.out.println("Triangle is: Isosceles Traingle");
            }else if (angle1==90 || angle2==90 || angle3==90) {
                System.out.println("Triangle is: Right Angle Triangle");
            }else{
                System.out.println("Triangle is: Scalene Triangle");
            }
       
        }else{
            System.out.println("Triangle is NOT POSSIBLE, Try with another sides");
        }
    }

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("::::::::::WELCOME TO MY PROGRAM::::::::::");
    System.out.println("PRESS 1: From SIDEs of Triangle: ");
    System.out.println("PRESS 2: From ANGLEs of Triangle: ");
    int type = input.nextInt();
    switch (type) {
        case 1:
            System.out.println("ENTER THE SIDES OF TRIANGLE: ");
            int side1= input.nextInt();
            int side2= input.nextInt();
            int side3= input.nextInt();
            triangleBasedOnSide(side1,side2,side3);
            break;
            
        case 2:
            System.out.println("ENTER THE ANGLES OF TRIANGLE: ");
            int angle1= input.nextInt();
            int angle2= input.nextInt();
            int angle3= input.nextInt();
            triangleBasedOnAngle(angle1, angle2, angle3);
            break;

        default:
            System.out.println("Kindly Enter Valid Option!!!");
            break;
        }
    }
}