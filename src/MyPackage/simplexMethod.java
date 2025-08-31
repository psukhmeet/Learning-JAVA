package MyPackage;
import java.util.*;

public class simplexMethod{
    
    public static double[] calZj(int rows, int columns, double[][] table, double[] cb){

        double[] zj = new double[columns];
        
        for(int j=0;j<columns;j++){
            double sum=0;
            for(int i=0; i<rows;i++){
                sum = sum +(cb[i] * table[i][j]);
            }
            zj[j]=sum;
        }   
        return zj;
    }



    
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Declaring All Variables:
        int rows, columns;
        
        int minZjIndex=0;
        int minMinRatioIndex=0;
        
        double keyElement;
        
        //INTIALIZING TABLE:
        System.out.println("Enter Number of Rows & Columns Respectively: ");
        System.out.println("(Rows Represents: NUMBER OF EQUATIONS)\n(Columns Represents: NUMBER OF VARIABLES)");
        rows=input.nextInt();
        columns=input.nextInt();
        
        double[][] table = new double[rows][columns];
        
        //ENTERing TABLE VALUES:
        System.out.println("Enter Table Values: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                table[i][j]= input.nextDouble();
            }
        }
        
        //SHOWING TABLE 1:
        System.out.println("TABLE: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(table[i][j]+"    ");
            }
            System.out.println();
        }
        
        //DECLARING OTHER ARRAYS: 
        double[] cb = new double[rows];
        double[] b = new double[rows];
        double[] cj = new double[columns];
        double[] zj = new double[rows];
        double[] zjminuscj = new double[rows];
        double[] keyColumn = new double[rows];
        double[] keyRow = new double[columns]; 
        double[] minRatio = new double[rows];

        //ENTRINGing THE VALUES of ARRYS:
        System.out.println("Enter: cb Values");
        for(int i=0;i<rows;i++){
            cb[i] = input.nextDouble();
        }
        System.out.println("Enter: b Values");
        for(int i=0;i<rows;i++){
            b[i] = input.nextDouble();
        }
        System.out.println("Enter: cj Values");
        for(int i=0;i<columns;i++){
            cj[i] = input.nextDouble();
        }

        //CALCULATING: Zj
        calZj(rows, columns, table, cb);
        

        //CALCULATING: Zj-Cj:
        for(int i=0;i<columns;i++){
            zjminuscj[i]=zj[i]-cj[i];
        }

        //CALCULATING: MINIMUM OF Zj-Cj:
        double minZjValue=0;
        for(int i=0;i<columns;i++){
            minZjValue=zj[i];
            if(zj[i]<minZjValue){
                minZjValue=zj[i];
                minZjIndex=i;
            }
        }
        
        //CALCULATING: KEY COLUMN:
        for(int i=0;i<rows;i++){
            keyColumn[i]=table[i][minZjIndex];
        }
        
        //CALCULATING: MINIMUM RATIO ARRAY:
        for(int i=0;i<rows;i++){
            minRatio[i] = b[i]/keyColumn[i];
        }
        
        //CALCULATING: MINIMUM RATIO VALUE
        double minRatioValue;
        for(int i=0;i<rows;i++){
            minRatioValue=minRatio[i];
            if(minRatio[i]<minRatioValue){
                minRatioValue=minRatio[i];
                minMinRatioIndex=i;
            }
        }
        
        //CALCULATING KEY ROW:
        for(int i=0;i<columns;i++){
            keyRow[i]=table[minMinRatioIndex][i];
        }

        //CALCULATING: KEY ELEMENT:
        keyElement=table[minMinRatioIndex][minZjIndex];
        
        
        //CREATING SHADOWS:
        double[] enteringArray = keyRow;
        double[] exitArray = keyColumn;       
        
        //LET'S START ITERATIONS:
        if(minZjValue<=0){
            
            //MAKING KEY ELEMENT = 1 ALSO KEY ROW CHANGED:
            for(int i=0;i<columns;i++){
                keyRow[i] = keyRow[i]/keyElement;
            }

            //MAKING ZEROs:
            // for(int i=0;i<rows-1;i++){
            // keyRow[i] = keyRow[i] * keyColumn[i];
            // for(int j=0;j<rows-1;j++){
            //     table[i][j] = 

            // }
            // }
        }else{

        }



        System.out.println("NEW TABLE: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(table[i][j]+"    ");
            }
            System.out.println();
        }

    }
}
