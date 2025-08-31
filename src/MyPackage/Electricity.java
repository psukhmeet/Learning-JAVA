package MyPackage;
import java.util.Scanner;

public class Electricity{
public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("..::::ELECTRICITY BILL CALCULATOR X NIT JSR::::..");
    System.out.println("PRESS 1: Domestic(Household Consumers)");
    System.out.println("PRESS 2: Commercial Consumers");
    int type = input.nextInt();
    if(type!=1 && type!=2){
     System.out.println("ERROR SELECT OPTION 1 or 2");   
    }else{
    
    System.out.println("ENTER UNITS CONSUMED: ");
    int units = input.nextInt();    
    
    double elecBill;
    double fixedCharges= 0;
    double energyCharges= 0;
    
    switch (type) {
        case 1: //HOUSEHOLD
        if(units<=100) {
            fixedCharges= 30;
            energyCharges= 3*units;
            break;
        }else {
            fixedCharges= 65;
            energyCharges= 300;
            energyCharges= energyCharges + 5.15*(units-100);
            break;
        }
        
        case 2: //COMMERCIAL
        System.out.println("PRESS 3: For Urban");
        System.out.println("PRESS 4: For Rural");
        
        int locality = input.nextInt();
        
        switch (locality) {
            case 3: //URBAN
            fixedCharges= 150;
            energyCharges= 4.15*units;    
                break;
            
            case 4: //RURAL
            fixedCharges=75; 
            energyCharges= 3*units;    
                break;
            
                default:
                System.err.println("ERROR 304: TRY AGAIN");
                break;
            }
        default:
        System.out.println("ERROR SELECT 1 Or 2 OPTION");
        break;        
    }    
    
    elecBill = fixedCharges + energyCharges;
    
    System.out.println("ELECTRICITY BILL: ");
    System.out.println("FIXED CHARGES: "+ fixedCharges);
    System.out.println("ENERGY CHARGES: "+ energyCharges);
    System.out.println("GROSS TOTAL BILL: "+elecBill);

    double subsidy= 0;
    
    if(type==1 && units>=201 && units<=400 ){
        subsidy = 2.05 * units;
        System.out.println("SUBSIDY: "+subsidy);
    }
    elecBill = elecBill-subsidy;
    System.out.println("BILL AFTER SUBSIDY: "+elecBill);

    double gst = elecBill*0.18;
    System.out.println("18% GST: "+ gst);
    elecBill = elecBill + gst; 
    System.out.println("NET BILL WITH GST: "+elecBill);
    
    if (units<=200 && type==1) {
        elecBill=0;
        System.out.println("But Since 200 Units Free Scheme Applies FINAL BILL: "+elecBill);
    }    
}}
}