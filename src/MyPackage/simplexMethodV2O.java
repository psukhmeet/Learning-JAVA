package MyPackage;

import java.util.*;

public class simplexMethodV2O {

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
            
    public static double[] calZjMinusCj(int columns, double[] zj, double[] cj){
        
        double[] zjMinusCj = new double[columns];
        for(int i=0; i<columns; i++){
            zjMinusCj[i] = zj[i]-cj[i];
        }
        return zjMinusCj;
    }

    public static double calMinOfZjMinusCj(int columns, double[] zjminuscjArray){
        double minOfZjMinusCj=zjminuscjArray[0];
        int indexOfMinOfZjMinusCj=0;
        for(int i=0;i<columns;i++){
            if(minOfZjMinusCj>zjminuscjArray[i]){
                minOfZjMinusCj=zjminuscjArray[i];
                indexOfMinOfZjMinusCj=i;
            }
        }
        return minOfZjMinusCj;
    }

    public static double calIndexMinOfZjMinusCj(int columns, double[] zjminuscjArray){
        double minOfZjMinusCj=zjminuscjArray[0];
        int indexOfMinOfZjMinusCj=0;
        for(int i=0;i<columns;i++){
            if(minOfZjMinusCj>zjminuscjArray[i]){
                minOfZjMinusCj=zjminuscjArray[i];
                indexOfMinOfZjMinusCj=i;
            }
        }
        return indexOfMinOfZjMinusCj;
    }

    public static double calKeyColumn(int rows,int column, double[] keyColumnArray, double[][] table){
    
        for(int i=0;i<rows;i++){
            keyColumnArray[i] = table[i][(int)calIndexMinOfZjMinusCj(column, keyColumnArray)];
            System.out.println("PRINTING: KEY COLUMN: "+keyColumnArray[i]);
        }
         return    

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        

        //Declaring Variables:
        int rows, columns;

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
        double[] cbArray = new double[rows];
        double[] bArray = new double[rows];
        double[] cjArray = new double[columns];
        double[] zjArray = new double[rows];
        double[] zjminuscjArray = new double[rows];
        double[] keyColumnArray = new double[rows];
        double[] keyRowArray = new double[columns]; 
        double[] minRatioArray = new double[rows];

        //ENTRINGing THE VALUES of ARRYS:
        System.out.println("Enter: cb Values");
        for(int i=0;i<rows;i++){
            cbArray[i] = input.nextDouble();
        }
        System.out.println("Enter: b Values");
        for(int i=0;i<rows;i++){
            bArray[i] = input.nextDouble();
        }
        System.out.println("Enter: cj Values");
        for(int i=0;i<columns;i++){
            cjArray[i] = input.nextDouble();
        }

        // CALLING FUNCTIONS
        // Zj
        zjArray = calZj(rows, columns, table, cbArray);
        System.out.println("PRINTING: Zj");
        for(int i=0;i<columns;i++){
            System.out.println(zjArray[i]+"   ");
            System.out.println();
        }
        
        System.out.println();

        //Zj-Cj
        zjminuscjArray = calZjMinusCj(columns, zjArray, cjArray);
        System.out.println("PRINTING: Zj-Cj");
        for(int i=0;i<columns;i++){
            System.out.println(zjminuscjArray[i]+"   ");
            System.out.println();
        }

        //Minimum Of Zj-Cj
        double minZj_Cj = calMinOfZjMinusCj(columns, zjminuscjArray);
        System.out.println("MINIMUM OF Zj-Cj: "+minZj_Cj+" at INDEX: "+calIndexMinOfZjMinusCj(columns, zjminuscjArray));

        
        //GETTING KEY COLUMN:
        for(int i=0;i<rows;i++){
            keyColumnArray[i] = table[i][indexOfMinOfZjMinusCj];
            System.out.println("PRINTING: KEY COLUMN: "+keyColumnArray[i]);
        }

        //FINDING: MINIMUM RATIO:








    }
}
