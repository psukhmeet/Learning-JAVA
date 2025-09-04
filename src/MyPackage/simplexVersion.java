package MyPackage;
import java.util.Scanner;

public class simplexVersion {

    //Function 1: Calculating "ZJ"
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

    //Function 2: Calculating "Zj-CJ"
    public static float[] cal_Zj_minus_Cj(float[] zj, float[] cj){
        float[] result = new float[zj.length];
        for(int i=0;i<zj.length;i++)
            result[i] = zj[i]-cj[i];
    return result;
    }

    //Function 3: Calculating "min(Zj-CJ)"
    public static float cal_min_Zj_minus_cj(float[] zj_minus_cj){
        float minimum = zj_minus_cj[0];
        for(int i=0;i<zj_minus_cj.length;i++){
            if(minimum>zj_minus_cj[i])
                minimum=zj_minus_cj[i];
        }
    return minimum;
    }



    public static float cal_min_minRatio(float[] min_Ratio_Array){
        float minimum = min_Ratio_Array[0];
        float min2 = minimum;
        for(int i=0;i<min_Ratio_Array.length;i++){
            if(minimum>min_Ratio_Array[i])
                minimum=min_Ratio_Array[i];
                if (minimum<0) {
                 continue;       
                }
                        
        }
        return minimum;

    }









    //Function 4: Calculating "(index(min(Zj-CJ)))"
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

    //Function 6: Calculating "Ratio"
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
    
    //Function 9: Calculating "Key Row Dividing by Key Element also "b" "
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

    //Function 10: Calculating "Other Key Element"
    public static float cal_other_keyElements(float[] key_Column_Array ,int columns,float table[][],int indexOf_minOf_minRAtio, int indexOf_minOf_zj_minus_cj){
        float result=0;
        for(int i=0;i<table.length;i++){
            if(i!=indexOf_minOf_minRAtio){
                result = key_Column_Array[i];
            }
        } 
        return result;
    }

    //Function 11: Calculating "Other Key Row Dividing by Other Key Element also "b" "
    public static float[][] cal_OtherRow1_NewKeyRow(float other_Key_Element ,int rows, int indexOf_minOf_zj_minus_cj,float[] key_Column_Array, float[] b,int columns,float table[][], int indexOf_minOf_minRAtio , float key_Element){    
        for(int i=0; i<rows; i++){
            if(i!= indexOf_minOf_minRAtio){
                b[i]=b[i]/other_Key_Element;                    
            }
            for(int j=0; j<columns;j++){
                if(i!= indexOf_minOf_minRAtio){
                    table[i][j] = table[i][j]/other_Key_Element;
                }
            }
        }
        return table;
    }
                
                
    //Function 12: Calculating "Other Rows - Key Rows"
    
    public static float[][] cal_OtherRows_minus_KeyRows(float[][] table, int indexOf_minOf_minRAtio, int indexOf_minOf_zj_minus_cj, int columns){
        
        for(int i=0; i<columns;i++){
            table[indexOf_minOf_zj_minus_cj][i]=table[indexOf_minOf_zj_minus_cj][i]-table[indexOf_minOf_minRAtio][i];
        }
        return table;
    }
        
    //Function 13: Operation "Other 'b' - Key 'b'"   
    public static float[] cal_b_minus_b(int rows,float[] b, int indexOf_minOf_minRAtio){
        for(int i=0;i<rows;i++){
            if(i!=indexOf_minOf_minRAtio){

                b[i] = b[i]-b[indexOf_minOf_minRAtio];
            }
        }

        return b;
    }

    //Function 14: Semi Final Operation "Cb * b"
    public static float[] cal_Cb_into_b(int rows, float[] cb, float[] b){
        float[] result = new float[rows];
        for(int i=0;i<rows;i++){
            result[i] = cb[i] * b[i];
        }
        return result;
    }

    //Function 15: Final Operation "sum"
    public static float cal_final_sum(int rows, float[] resultant){
        float sum=0;
        for(int i=0; i<rows;i++){
            sum = sum+ resultant[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            
            //Declaring all required Variables:
            int rows, columns;
            float minOf_zj_minus_cj_Value; 
            int indexOf_minOf_zj_minus_cj;
            float minOf_MinRatio_Value;
            float key_Element; 
            int indexOf_minOf_minRAtio;
            float other_Key_Element;
            float sum;

            //Dispalying: Initials
            System.out.println("\nஷாலூ's psukhmeet \n");
            System.out.println("Welcome To Simplex Program");

            //Declaring Rows & Columns:
            System.out.println("Enter Number of Equations (Rows): ");
            rows = input.nextInt();
            System.out.println("Enter Number of Variables (Columns): ");
            columns = input.nextInt();

            //Declaring & Initializing Table:
            float [][] table = new float[rows][columns];
            System.out.println("Enter Table Values: ");
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    table[i][j] = input.nextFloat();
                }
            }

            //Declaring all required Arrays:
            float[] cb = new float[rows];
            float[] b = new float[rows];
            float[] cj = new float[columns];
            float[] zj = new float[columns];
            float[] zj_minus_cj_array = new float[columns]; 
            float[] min_Ratio_Array = new float[rows];
            float[] key_Column_Array = new float[rows];
            float[] key_Row_Array = new float[columns];
            float[] resultant = new float[rows];

            //Entring "Cb"
            System.out.println("Enter 'Cb': ");
            for(int i=0; i<rows;i++){
                cb[i] = input.nextFloat();
            }

            //Entring "b"
            System.out.println("Enter 'b': ");
            for(int i=0; i<rows;i++){
                b[i] = input.nextFloat();
            }

            //Entering "Cj"
            System.out.println("Enter 'Cj': ");
            for(int i=0; i<columns;i++){
                cj[i] = input.nextFloat();
            }

            //Calculating: "Zj"
            System.out.println();
            zj=cal_Zj(columns, table, cb);
            System.out.println("Calculating 'Zj':");
                for(int p=0;p<columns;p++){
                    System.out.print(zj[p]+" ");
                }

            //Calculating: "Zj-CJ"
            System.out.println();
            zj_minus_cj_array= cal_Zj_minus_Cj(zj, cj);
            System.out.println("Calculating: Zj-Cj");
                for(int p=0;p<columns;p++){
                    System.out.print(zj_minus_cj_array[p]+" ");
                }

            //Calculating: "min(Zj-Cj)"
            System.out.println();
            minOf_zj_minus_cj_Value = cal_min_Zj_minus_cj(zj_minus_cj_array);            
            System.out.println("min(Zj-Cj): "+minOf_zj_minus_cj_Value);
            
            //Getting into Iterations:
            
                for(int i=0;i<5;i++){
                    
                    //Calculating: "Index(min(Zj-Cj))"
                    System.out.println();
                    indexOf_minOf_zj_minus_cj = cal_Index_min_Zj_minus_cj(zj_minus_cj_array);
                    System.out.println("Index(min(Zj-Cj)): " +indexOf_minOf_zj_minus_cj);
                            
                    //Calculating: "Key Column Array"
                    System.out.println();
                    key_Column_Array = cal_Key_Column(rows,table, indexOf_minOf_zj_minus_cj);
                    System.out.println("Key Column Array: ");
                    for(int p=0;p<rows;p++){
                        System.out.println(key_Column_Array[p]);
                    }

                    //Calculating: "Ratio"
                    System.out.println();
                    min_Ratio_Array= cal_min_Ratio(b, key_Column_Array);
                    System.out.println("Ratio Array");
                    for(int p=0;p<rows;p++){
                        System.out.println(min_Ratio_Array[p]);
                    }
                
                    //Calculating: "min(Ratio)"
                    System.out.println();
                    minOf_MinRatio_Value= cal_min_minRatio(min_Ratio_Array);
                    System.out.println("min(Ratio): "+minOf_MinRatio_Value); 
                    

                    // if(minOf_MinRatio_Value<0){
                    //     continue;
                    // }else{

                        

                   
                    
                    //Calculating: "Index(min(Ratio))"
                    System.out.println();
                    indexOf_minOf_minRAtio = cal_Index_min_Zj_minus_cj(min_Ratio_Array);
                    System.out.println("Index(min(Ratio)): "+ indexOf_minOf_minRAtio);

                    //Calculating: "Key Row Array"
                    System.out.println();
                    key_Row_Array = cal_Key_Row(columns, table, indexOf_minOf_minRAtio);
                    System.out.println("Key Row Array:");    
                        for(int p=0; p<columns;p++){
                            System.out.print(key_Row_Array[p]+" ");
                        }
                    
                    //Calculating: "Key Element"
                    System.out.println();
                    key_Element = cal_Key_element(table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj);
                    System.out.println("Key Element is: "+ key_Element);
                        
                    //Calculating: "Other Key Element"
                    System.out.println();
                    other_Key_Element = cal_other_keyElements(key_Column_Array, columns, table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj);
                    System.out.println("Other Key Element: "+other_Key_Element);

                    //Table Updating: "Dividing Key Row by Key Element (=1)"        
                    System.out.println();
                    System.out.println("Updating Table: Dividing Key Row by Key Element (=1)");
                    table=cal_Key_Element1_NewKeyRow(indexOf_minOf_zj_minus_cj ,rows,b,columns, table, indexOf_minOf_minRAtio, key_Element);
                    for(int p1=0;p1<rows;p1++){
                        for(int p2=0;p2<columns;p2++){
                            System.out.print(table[p1][p2]+"  ");
                        }
                        System.out.println();
                    }
                    
                    //Displaying: "b"
                    System.out.println();
                    System.out.println("Updating 'b'");
                    for(int p=0;p<rows;p++){
                        System.out.println(b[p]);

                    }
                            
                    //Table Updating: "Dividing Other Rows by Other Key Element As Well As by 'b'"
                    System.out.println();
                    table = cal_OtherRow1_NewKeyRow(other_Key_Element,rows, indexOf_minOf_zj_minus_cj, key_Column_Array, b, columns, table, indexOf_minOf_minRAtio, key_Element);
                    System.out.println("Dividing Other Rows by Other Key Element As Well As by 'b'(=1(other rows))");
                        for(int j=0;j<rows;j++){
                            for(int k=0;k<columns;k++){
                                System.out.print(table[j][k]+"  ");
                            }
                            System.out.println();
                        }

                        //Displaying: "b"
                    System.out.println();
                    System.out.println("Updating 'b'");
                    for(int p=0;p<rows;p++){
                        System.out.println(b[p]);

                    }

                    //Operation: "Other Rows - Key Row (=0)"
                    System.out.println();
                    table = cal_OtherRows_minus_KeyRows(table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj, columns);
                    System.out.println("Other Rows - Key Row (=0)");
                            for(int j=0;j<rows;j++){
                                for(int k=0;k<columns;k++){
                                    System.out.print(table[j][k]+"  ");
                                }
                                System.out.println();
                            }

                            
                    //Operation: "Other 'b' - Key 'b'"
                    System.out.println();
                    b = cal_b_minus_b(rows,b,indexOf_minOf_minRAtio);
                    System.out.println("Updating 'b'");
                    for(int p=0;p<rows;p++){
                        System.out.print(b[p]+" ");
                    }

                    //Displaying: "b"
                    System.out.println();
                    System.out.println("Updating 'b'");
                    for(int p=0;p<rows;p++){
                        System.out.println(b[p]);

                    }

                    // Semi-Final Result Calculation (cb * b)
                    resultant =cal_Cb_into_b(rows,cb,b);
                    System.out.println();
                        System.out.println("Final Result: ");
                        for(int p=0; p<rows;p++){
                        System.out.println(resultant[i]);
                        }

                    //final Sum
                    System.out.println("Sum is...................................");
                        sum = cal_final_sum(rows,resultant);
                        System.out.println(sum);

                        //cb updating
                        cb[indexOf_minOf_minRAtio]= cj[indexOf_minOf_zj_minus_cj];
                        
                        System.out.println("NEW Cb");
                        for(int r=0;r<rows;r++){

                            System.out.println(cb[r]);
                        }

                        //zj updating
                        zj = cal_Zj(columns, table, cb);
                        System.out.println("NEW ZJ: ");
                            for(int r=0;r<columns;r++){
                                System.err.print(zj[r]+" ");
                            }
                            System.out.println();
                
                            //zj-cj updating
                            zj_minus_cj_array= cal_Zj_minus_Cj(zj, cj);
                                System.out.println("NEW ZJ-CJ: ");
                            for(int r=0;r<columns;r++){
                                System.err.print(zj_minus_cj_array[r]+" ");
                            }
                            System.out.println();
                            
                            //updating:min(zj-cj)
                            minOf_zj_minus_cj_Value = cal_min_Zj_minus_cj(zj_minus_cj_array);
                            System.out.println("MIN OF ZJ-CJ");
                            System.out.println(minOf_zj_minus_cj_Value);
                            
                            
                        }
                        
                    }    
                    
                }
          
//    }
