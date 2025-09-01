package MyPackage;
import java.util.Scanner;

public class simplexVersion {

    //Function 1: Calculating "Zj"
    public static float[] cal_Zj(int columns, float[][] table, float[] cb){
        float[] result = new float[columns];
        for(int i=0;i<columns;i++){
            float sum=0;
            for(int j=0;j<table.length;j++){
                sum = sum + cb[j]*table[j][i];
            }
            result[i] = sum;
        }
        return result;
    }

    //Function 2: Calculating "Zj-Cj"
    public static float[] cal_Zj_minus_Cj(float[] zj, float[] cj){
        float[] result = new float[zj.length];
        for(int i=0;i<zj.length;i++)
            result[i] = zj[i]-cj[i];
        return result;
    }

    //Function 3: Calculating "min(Zj-Cj)"
    public static float cal_min_Zj_minus_cj(float[] zj_minus_cj){
        float minimum = zj_minus_cj[0];
        for(int i=0;i<zj_minus_cj.length;i++){
            if(minimum>zj_minus_cj[i])
                minimum=zj_minus_cj[i];
        }
        return minimum;
    }

    //Function 4: Calculating "Index(Zj-Cj)"
    public static int cal_Index_min_Zj_minus_cj(float[] zj_minus_cj){
        float minimum = zj_minus_cj[0];
        int index=0;
            for(int i=0;i<zj_minus_cj.length;i++){
                if(minimum>zj_minus_cj[i]){
                    minimum=zj_minus_cj[i];
                    index = i;
                }
            }
            return index;
    }

    //Function 5: Calculating "Key Column"
    public static float[] cal_Key_Column(int rows, float table[][],int indexOf_minOf_zj_minus_cj){
        float[] result = new float[table.length];
            for(int i=0;i<rows;i++){
                result[i]=table[i][indexOf_minOf_zj_minus_cj];
            }
            return result;
    }

    //Function 6: Calculating "Minimum Ratio"
    public static float[] cal_min_Ratio(float[] b, float[] key_Column_Array){
        float[] result = new float[b.length];
            for(int i=0;i<b.length;i++){
                result[i]=b[i]/key_Column_Array[i];
            }
            return result;
    }

    //Function 7: Calculating "Key Row" 
    public static float[] cal_Key_Row(int columns, float table[][],int indexOf_minOf_minRAtio){
        float[] result = new float[columns];
            for(int i=0;i<columns;i++){
            result[i]= table[indexOf_minOf_minRAtio][i];
            }
            return result;
    }

    //Function 8: Calculating "Key Element"
    public static float cal_Key_element(float[][] table, int indexOf_minOf_minRAtio, int indexOf_minOf_zj_minus_cj){
        float result = table[indexOf_minOf_minRAtio][indexOf_minOf_zj_minus_cj];
        return result;
    }
    
    //Function 9: Dividing Key Row (=1)
    public static float[][] cal_Key_Element1_NewKeyRow(int indexOf_minOf_zj_minus_cj, int rows,float[] b,int columns,float table[][], int indexOf_minOf_minRAtio , float key_Element){
        for(int i=0; i<columns;i++){
        table[indexOf_minOf_minRAtio][i] = table[indexOf_minOf_minRAtio][i] / key_Element;
        }    
        for(int i=0;i<rows;i++){
            if(i!=indexOf_minOf_zj_minus_cj){

                b[i]=b[i]/key_Element;
            }
        }    
        return table;
    }

    //Function 10: Calculating "Other Key Elements"
    public static float cal_other_keyElements(float[] key_Column_Array ,int columns,float table[][],int indexOf_minOf_minRAtio, int indexOf_minOf_zj_minus_cj){
        float result=0;
        for(int i=0;i<table.length;i++){
            if(i!=indexOf_minOf_minRAtio){
                result = key_Column_Array[i];
            }
        } 
        return result;
    }

    //Function 11: Calculating "Index of other Key Elements"
    public static int cal_Index_of_Other_Key_Element(int rows, int indexOf_minOf_zj_minus_cj, float key_Column_Array){
        int result=0;
        for(int i=0;i<rows;i++){
            if(i == indexOf_minOf_zj_minus_cj){
                result = i;
            }
        }
        return result;
    }

    //Function 11: Dividing Other Row (=1) 
    // public static float[][] cal_OtherRow1_NewKeyRow(float other_Key_Element,int rows, int indexOf_minOf_zj_minus_cj,float[] key_Column_Array, float[] b,int columns,float table[][], int indexOf_minOf_minRAtio , float key_Element){    
    //     for(int i=0; i<rows; i++){
    //         if(i!= indexOf_minOf_minRAtio){
    //             b[i]=b[i]/other_Key_Element;                    
    //         }
    //         for(int j=0; j<columns;j++){
    //             if(i!= indexOf_minOf_minRAtio){
    //                 table[i][j] = table[i][j]/other_Key_Element;
    //             }
    //         }
    //     }
    //     return table;
    // }
    
    //Function 12: Multiply New Key Row by Other Key Element
    public static float[] cal_Multiply_new_line(int columns, float[] key_Row_Array, float other_Key_Element){
        for(int i=0;i<columns;i++){
            key_Row_Array[i] = key_Row_Array[i] * other_Key_Element;
        }
        return key_Row_Array;
    }
    
    //Function13: Performing: Minus Between Rows:
    public static float[][] cal_Perform_Minus(float[][]table, float[] key_Row_Array, int index_of_Other_Key_Element){
        for(int i=0;i<table[0].length;i++){
            table[index_of_Other_Key_Element][i] = table[index_of_Other_Key_Element][i]-key_Row_Array[i];
        }
        return table;
    }
        



    //Function 13: "Doing Row Operations"
    // public static float[][] cal_OtherRows_minus_KeyRows(float[] b, float[][] table, int indexOf_minOf_minRAtio, int indexOf_minOf_zj_minus_cj, int columns){
    //     for(int i=0; i<columns;i++){
    //         table[indexOf_minOf_zj_minus_cj][i]=table[indexOf_minOf_zj_minus_cj][i]-table[indexOf_minOf_minRAtio][i];
    //     }
    //     for(int i=0; i<table.length;i++){
    //         if(i!=indexOf_minOf_minRAtio){
    //             b[i] = b[i]-b[indexOf_minOf_minRAtio];
    //         }
    //     }
    //     return table;
    // }
        

//..............................................Main Function......................................................./
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Declaring & Initializing Variables: 
        int rows, columns, indexOf_minOf_zj_minus_cj, indexOf_minOf_minRAtio, index_of_Other_Key_Element;
        float minOf_MinRatio_Value, key_Element, other_Key_Element;
        
        System.out.println("Enter Number of Equations (Rows): ");
        rows = input.nextInt();
        System.out.println("Enter Number of Variables (Columns): ");
        columns = input.nextInt();
        
        //Declaring Arrays:
        float[] cb = new float[rows];
        float[] b = new float[rows];
        float[] cj = new float[columns];
        float[] zj = new float[columns];
        float[] zj_minus_cj_array = new float[columns]; 
        float[] key_Row_Array = new float[columns];
        float[] key_Column_Array = new float[rows];
        float[] min_Ratio_Array = new float[rows];
        
        //Declaring & Initializing Table: 
        float [][] table = new float[rows][columns]; 
        System.out.println("Enter Table Values: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                table[i][j] = input.nextFloat();
            }
        }
        
        //Entering "Cb"
        System.out.println("Enter Cb VAlues: ");
        for(int i=0; i<rows;i++){
            cb[i] = input.nextFloat();
        }
        
        //Entering "b"
        System.out.println("Enter b VAlues: ");
        for(int i=0; i<rows;i++){
            b[i] = input.nextFloat();
        }

        //Entering "Cj"
        System.out.println("Enter Cj Values: ");
        for(int i=0; i<columns;i++){
            cj[i] = input.nextFloat();
        }

        //Calculating: "Zj"
        zj = cal_Zj(columns, table, cb);

        //Calculating: "Zj-Cj"
        zj_minus_cj_array = cal_Zj_minus_Cj(zj, cj);

        //Calculating: "Minimum of Zj-Cj"
        float minOf_zj_minus_cj_Value = cal_min_Zj_minus_cj(zj_minus_cj_array);
        
        //Iterations:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            for(int i=0;minOf_zj_minus_cj_Value<0;i++){
                
                //Calculating: "Index of Minimum of Zj-Cj"
                System.out.println();
                indexOf_minOf_zj_minus_cj = cal_Index_min_Zj_minus_cj(zj_minus_cj_array);
                System.out.println("Index of Minimum of Zj-Cj : "+indexOf_minOf_zj_minus_cj);
                
                //Calculating: "Key Column"
                System.out.println();
                System.out.println("KEY COLUMN: ");
                key_Column_Array = cal_Key_Column(rows,table, indexOf_minOf_zj_minus_cj);
                    for(int p=0; p<table.length;p++){
                        System.out.println(key_Column_Array[p]);
                    }
                
                //Calculating: "Minimum Ratio"
                System.out.println();
                System.out.println("Minimum Ratio Array: ");
                min_Ratio_Array = cal_min_Ratio(b, key_Column_Array);
                    for(int p=0;p<table.length;p++){
                        System.out.println(min_Ratio_Array[p]);
                    }
                
                //Calculating: "Minimum of Minimum Ratio"
                System.out.println();
                System.out.println("Minimum of Minimum Ratio: ");
                minOf_MinRatio_Value=cal_min_Zj_minus_cj(min_Ratio_Array);
                System.out.println(minOf_MinRatio_Value); 
                
                //Calculating: "Index of Minimum of Minimum Ratio"
                System.out.println();
                System.out.println("Index of Minimum of Minimum Ratio: ");
                indexOf_minOf_minRAtio = cal_Index_min_Zj_minus_cj(min_Ratio_Array);
                System.out.println(indexOf_minOf_minRAtio);
                
                //Calculating: "Key Row"
                System.out.println();
                System.out.println("Key Row: ");
                key_Row_Array = cal_Key_Row(columns, table, indexOf_minOf_zj_minus_cj);
                    for(int p=0;p<table[0].length;p++){
                        System.out.println(key_Row_Array[p]+"  ");
                    }    

                //Calculating: "Key Element"
                System.out.println();
                System.out.println("Key Element: ");
                key_Element = cal_Key_element(table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj);
                System.out.println(key_Element);
                
                //Making: "Key Row Divided by Key Element (=1)"
                System.out.println();
                System.out.println("Key Row Divided by Key Element");        
                table = cal_Key_Element1_NewKeyRow(indexOf_minOf_zj_minus_cj ,rows,b,columns, table, indexOf_minOf_minRAtio, key_Element);
                    for(int p1=0;p1<rows;p1++){
                        for(int p2=0;p2<columns;p2++){
                            System.out.print(table[p1][p2]+"  ");
                        }
                        System.out.println();
                    }
                
                //Calculating: "Other Key Elements"
                System.out.println();
                System.out.println("Other Key Elements: ");
                other_Key_Element = cal_other_keyElements(key_Column_Array, columns, table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj);
                System.out.println(other_Key_Element);

                //Making: "Other Rows Dividing by Value (=1)"
                // System.out.println();
                // System.out.println("Other Rows Dividing by Value (=1)");
                // table = cal_OtherRow1_NewKeyRow(other_Key_Element,rows, indexOf_minOf_zj_minus_cj, key_Column_Array, b, columns, table, indexOf_minOf_minRAtio, key_Element);
                //     for(int j=0;j<rows;j++){
                //         for(int k=0;k<columns;k++){
                //             System.out.print(table[j][k]+"  ");
                //         }
                //         System.out.println();
                //     }
                System.out.println();
                index_of_Other_Key_Element = cal_Index_of_Other_Key_Element(rows, indexOf_minOf_zj_minus_cj, columns);
                
                System.out.println("Index Of Other Key Element: "+index_of_Other_Key_Element);

                key_Row_Array= cal_Multiply_new_line(columns, key_Row_Array, other_Key_Element);
                table=cal_Perform_Minus(table, key_Row_Array, index_of_Other_Key_Element);
                
                System.out.println("...............NEwTable..............");
                
                for(int p1=0;p1<rows;p1++){
                    for(int p2=0;p2<columns;p2++){
                        System.out.print(table[p1][p2]+"  ");
                    }
                System.out.println();
                }    
















                //Making "Other Rows Minus Key Row (=0)"
                // System.out.println();
                // System.out.println("Other Rows Minus Key Row (=0)");
                // table = cal_OtherRows_minus_KeyRows(b, table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj, columns);
                //     for(int p1=0;p1<rows;p1++){
                //         for(int p2=0;p2<columns;p2++){
                //             System.out.print(table[p1][p2]+"  ");
                //         }
                //         System.out.println();
                //     }
                    
                //Updating: "Cb"
                System.out.println();
                System.out.println("Updating 'Cb': ");
                cb[indexOf_minOf_minRAtio]= cj[indexOf_minOf_zj_minus_cj];
                    for(int p=0;p<rows;p++){
                        System.out.println(cb[p]);
                    }

                //Updating: "b"
                System.out.println();
                System.out.println("Updating 'b': ");
                    for(int p=0;p<rows;p++){
                        System.out.println(b[p]);
                    }
                
                //Updating: "Zj"
                System.out.println();
                System.out.println("Updating 'Zj': ");
                zj = cal_Zj(columns, table, cb);
                    for(int p=0;p<columns;p++){
                        System.out.print(zj[p]+" ");
                    }
                
                //Updating: "Zj-Cj"
                System.out.println();
                System.out.println("Updating 'Zj-Cj'");
                zj_minus_cj_array = cal_Zj_minus_Cj(zj, cj);
                    for(int p=0;p<columns;p++){
                    System.out.print(zj_minus_cj_array[p]+" ");
                    }
                    
                //Updating: "Minimum of Zj-Cj"
                minOf_zj_minus_cj_Value = cal_min_Zj_minus_cj(zj_minus_cj_array);
                System.out.println("Updating Minimum of Zj-Cj: "+minOf_zj_minus_cj_Value);
                
                //Updated Table:
                System.out.println();
                System.out.println("Updated Table: ");
                for(int p1=0;p1<rows;p1++){
                    for(int p2=0;p2<columns;p2++){
                        System.out.print(table[p1][p2]+"  ");
                    }
                System.out.println();
                }
            
            }    
        
        }   
    
    }    