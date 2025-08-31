package MyPackage;

import java.util.Scanner;

public class simplex {
    // MAX z = 3x + 4y
    // x+2y<=4
    // 3x+2y<=6
    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    double [][] itr1 = new double[2][4];

    System.out.println("ENTER x,y,x1,y1");
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                itr1[i][j]= input.nextInt();
            }
        }
        
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                System.out.println("FIRST TABLE IS: "+itr1[i][j]);
            }
        }


        //ENTRING Cb:
        int[] cb = new int[2];
        System.out.println("ENTER Cb ELEMENTS: ");
        for(int i=0; i<cb.length;i++){
            cb[i]=input.nextInt();
        }
        
        //ENTERING (b) BASE VARIABLES:
       System.out.println("ENTER (b) base ELEMENTS: ");
        double[] b = new double[2];
        for(int i=0; i<2; i++){
            b[i]=input.nextDouble();
        }

        //CALCULATING ZJ
       //System.out.println("ENTER (b) base ELEMENTS: ");
        double[] zj = new double[4];
        for(int i=0;i<1;i++){
            for(int j=0; j<1;j++){
            zj[i]=(cb[i])*(itr1[i][j]);
        }

    }
    
        //Entering CJ ELEMNTS:
        double[] cj= new double[4];
        System.out.println("ENTER CJ ELEMNTS: ");
        for(int i=0;i<2;i++){
            cj[i]=input.nextInt();
        }


        //CALCULATING Zj-Cj
        
        double[] zjminuscj= new double[4];

        for(int i=0;i<4;i++){
            zjminuscj[i]=zj[i]-cj[i];
        }
        
        
        for(int i=0;i<4;i++){
        System.out.println("Zj-Cj"+zjminuscj[i]);
        }

        for(int i=0;i<1;i++){
            for(int j=0; j<1;j++){
           System.out.println( zj[i]=(cb[i])*(itr1[i][j]));
        }
    
    }
    
    double min=0;
    int minIndex=0;
    for(int i=0;i<1;i++){
        for(int j=0; j<1;j++){
            min=zjminuscj[i]; 
            if (zjminuscj[i]>zjminuscj[i+1]) {
                min=zjminuscj[i+1];
                minIndex=i+1;
            System.out.println("INDEX OF MIN: "+minIndex);
        }        
    }
}

System.out.println("Minimum of zj-cj" +min);
        
    double[] keyColmn= new double[2];

    for(int i=0;i<keyColmn.length;i++){
        
        keyColmn[i]=itr1[i][minIndex];
    
}
System.out.println("Min INDEX: "+minIndex);

    for(int i=0;i<2;i++){
        System.out.println("KEY COLUMN: "+keyColmn[i]);
    }

    //CalCulating Min Ratio:
    double[] minRatio= new double[2];
    for(int i=0;i<2;i++){
        minRatio[i]=b[i]/keyColmn[i];
    }
    
for(int i=0;i<2;i++){
    System.out.println("Min Ratio Column: "+minRatio[i]);    
   
    }
    double minratio=minRatio[0];
    double minratioIndex=0;
for(int i=0;i<2;i++){
    if(minRatio[i]<minratio){
        minratio=minRatio[i];
        minratioIndex=i;
    }

}

System.out.println("MIn Ratio: "+minratio);

double keyEle = itr1[minIndex][(int)minratioIndex];

System.out.println("KEY ELEM: "+keyEle);


for(int i=0;i<4;i++){
    itr1[(int)minratioIndex][i]=itr1[(int)minratioIndex][i]/keyEle;
}
for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                System.out.print(itr1[i][j]);
            }
            System.out.println();
        }



    
    
   
    // for(int i=0;i<2;i++){
    //     keyRow[i] = b[i]/keyColmn[i];
    // }

    // for(int i=0;i<2;i++){
    // System.out.println("KEY COLUMN: "+keyColmn[i]);
    // }

    // for(int i=0;i<4;i++){
    // System.out.println("KEY ROW: "+keyRow[i]);
    // }


    // //KEY ELEMNT: 
    // int keyEle=0;
    // for(int i=0;i<2;i++){
    
    // if(keyColmn[i]==keyRow[i]){
    //     keyEle=keyColmn[i];

    // }
    
    //     System.out.println("KEY ELE: "+keyEle);
    // }
}
}
