import java.util.Scanner;

public class SI {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("ENTER -> Principle Amount: ");
        float p = input.nextFloat();
        System.out.println("ENTER -> ROI: ");
        float r = input.nextFloat();
        System.out.println("ENTER -> Interest Earned: ");
        float si = input.nextFloat();

        float t = (si*100)/(p*r);
        System.out.println("Time Period is: "+t+" years");
    }
}
