package MyPackage;
import java.util.Scanner;

public class simplexVersion {

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

    public static float[] cal_Zj_minus_Cj(float[] zj, float[] cj){
        float[] result = new float[zj.length];
        for(int i=0;i<zj.length;i++)
            result[i] = zj[i]-cj[i];
        return result;
    }

    public static float cal_min_Zj_minus_cj(float[] zj_minus_cj){
        float minimum = zj_minus_cj[0];
        for(int i=0;i<zj_minus_cj.length;i++){
            if(minimum>zj_minus_cj[i])
                minimum=zj_minus_cj[i];
        }
        return minimum;
    }

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

    public static float[] cal_Key_Column(int rows, float table[][],int indexOf_minOf_zj_minus_cj){
        float[] keyCol = new float[table.length];
        for(int i=0;i<rows;i++){
            keyCol[i]=table[i][indexOf_minOf_zj_minus_cj];
        }
        return keyCol;
    }

    public static float[] cal_min_Ratio(float[] b, float[] key_Column_Array){
        float[] result = new float[b.length];
        for(int i=0;i<b.length;i++){
            result[i]=b[i]/key_Column_Array[i];
        }
        return result;
    }
     
    public static float[] cal_Key_Row(int columns, float table[][],int indexOf_minOf_minRAtio){
        float[] result = new float[columns];
        for(int i=0;i<columns;i++){
            result[i]= table[indexOf_minOf_minRAtio][i];
        }
        return result;
    }

    public static float cal_Key_element(float[][] table, int indexOf_minOf_minRAtio, int indexOf_minOf_zj_minus_cj){
        float result = table[indexOf_minOf_zj_minus_cj][indexOf_minOf_minRAtio];
        return result;
    }
    
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

    public static float cal_other_keyElements(float[] key_Column_Array ,int columns,float table[][],int indexOf_minOf_minRAtio, int indexOf_minOf_zj_minus_cj){
        float result=0;
        for(int i=0;i<table.length;i++){
            if(i!=indexOf_minOf_minRAtio){
                result = key_Column_Array[i];
            }
        } 
        return result;
    }

    public static float[][] cal_OtherRow1_NewKeyRow(int rows, int indexOf_minOf_zj_minus_cj,float[] key_Column_Array, float[] b,int columns,float table[][], int indexOf_minOf_minRAtio , float key_Element){
        float value = cal_other_keyElements(key_Column_Array, columns, table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj);    
        for(int i=0; i<rows; i++){
            if(i!= indexOf_minOf_minRAtio){
                b[i]=b[i]/value;                    
            }
            for(int j=0; j<columns;j++){
                
                
                if(i!= indexOf_minOf_minRAtio){
                    table[i][j] = table[i][j]/value;
                }
            }
        }
        return table;
    }
    
    
    public static float[][] cal_OtherRows_minus_KeyRows(float[][] table, int indexOf_minOf_minRAtio, int indexOf_minOf_zj_minus_cj, int columns){
        
        for(int i=0; i<columns;i++){
            table[indexOf_minOf_zj_minus_cj][i]=table[indexOf_minOf_zj_minus_cj][i]-table[indexOf_minOf_minRAtio][i];
        
        }
        return table;
    }
        



    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            
            int rows, columns;
            
            System.out.println("Enter Number of Equations (Rows): ");
            rows = input.nextInt();
            System.out.println("Enter Number of Variables (Columns): ");
            columns = input.nextInt();


            float [][] table = new float[rows][columns]; 

            System.out.println("Enter Table Values: ");
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    table[i][j] = input.nextFloat();
                }
            }

            
            //ENTER Cb & b
            float[] cb = new float[rows];
            float[] b = new float[rows];

            System.out.println("Enter Cb VAlues: ");
            for(int i=0; i<rows;i++){
                cb[i] = input.nextFloat();
            }
            System.out.println("Enter b VAlues: ");
            for(int i=0; i<rows;i++){
                b[i] = input.nextFloat();
            }

            //Enter Cj
            float[] cj = new float[columns];
            System.out.println("Enter Cj Values: ");
            for(int i=0; i<columns;i++){
                cj[i] = input.nextFloat();
            }

            //Zj
            float[] zj = cal_Zj(columns, table, cb);
                System.out.println("old old ZJ: ");
                        for(int r=0;r<columns;r++){
                            System.err.print(zj[r]+" ");
                        }


            
            //Zj-Cj
            float[] zj_minus_cj_array = cal_Zj_minus_Cj(zj, cj);

            //minimum of zj minus cj
            float minOf_zj_minus_cj_Value = cal_min_Zj_minus_cj(zj_minus_cj_array);
            
            for(int i=0;minOf_zj_minus_cj_Value<0;i++){
                
                //index of minimum of zj minus cj
                int indexOf_minOf_zj_minus_cj = cal_Index_min_Zj_minus_cj(zj_minus_cj_array);
                    System.out.println("Index of minimum of Zj-Cj : "+indexOf_minOf_zj_minus_cj);
                




                    System.out.println("TABLE");
                    for(int j=0;j<rows;j++){
                            for(int k=0;k<columns;k++){
                                System.out.print(table[j][k]+"  ");
                            }
                            System.out.println();
                        }
                //key column
                float[] key_Column_Array = cal_Key_Column(rows,table, indexOf_minOf_zj_minus_cj);
                
                System.out.println();

                System.out.println("Key Column Array: ");
                for(int z=0;z<rows;z++){
                    System.out.println(key_Column_Array[i]);
                }

                //Minimum Ratio
            //     float[] min_Ratio_Array = cal_min_Ratio(b, key_Column_Array);
                    
            //     for(int a=0;a<rows;a++){

            //         System.out.println("MINIMUM RATIO: "+ min_Ratio_Array[a]);
            //     }
               
            //         //Minimum of Min Ratio
            //     float minOf_MinRatio_Value=cal_min_Zj_minus_cj(min_Ratio_Array);
            //         System.out.println("Minimum of Min Ratio: "+minOf_MinRatio_Value); 
                
            //         //INdex of MinOF minimum Ratio
            //     int indexOf_minOf_minRAtio = cal_Index_min_Zj_minus_cj(min_Ratio_Array);
            //         System.out.println("Index Of Min Of MIn Ratio: "+ indexOf_minOf_minRAtio);
                
            //         //key Row

            //     float[] key_Row_Array = cal_Key_Row(columns, table, indexOf_minOf_zj_minus_cj);
            //     System.out.println("KEy ROw");    
            //     for(int z=0; z<columns;z++){
            //             System.out.print(key_Row_Array[i]+" ");
            //         }
            //         System.out.println();
            //     //key Element
            //     float key_Element = cal_Key_element(table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj);
            //         System.out.println("Key Element is: "+key_Element);
                
            //         //keyElement=1 (TABLE UPDATED)        
            //     table=cal_Key_Element1_NewKeyRow(indexOf_minOf_zj_minus_cj ,rows,b,columns, table, indexOf_minOf_minRAtio, key_Element);
            // //     for(int l=0;l<rows;l++){
            // //     for(int k=0;k<columns;k++){
            // //         System.out.println(table[l][k]+"  ");
            // //     }
            // //    }
               
            //     System.out.println("KeyEl=1");
            //             for(int j=0;j<rows;j++){
            //                 for(int k=0;k<columns;k++){
            //                     System.out.print(table[j][k]+"  ");
            //                 }
            //                 System.out.println();
            //             }



            //             //PRINTING b
            //             System.out.println("PRINTING b");
            //             for(int a=0;a<rows;a++){
            //                 System.out.println(b[i]);

            //             }
                        

            //     //other rows =1..................................
            //     table =cal_OtherRow1_NewKeyRow(rows, indexOf_minOf_zj_minus_cj, key_Column_Array, b, columns, table, indexOf_minOf_minRAtio, key_Element);
            //     System.out.println("other Row=1");
            //             for(int j=0;j<rows;j++){
            //                 for(int k=0;k<columns;k++){
            //                     System.out.print(table[j][k]+"  ");
            //                 }
            //                 System.out.println();
            //             }
                



            //     //=0
            //     table = cal_OtherRows_minus_KeyRows(table, indexOf_minOf_minRAtio, indexOf_minOf_zj_minus_cj, columns);
           
            //     System.out.println("KeyEl=0");
            //             for(int j=0;j<rows;j++){
            //                 for(int k=0;k<columns;k++){
            //                     System.out.print(table[j][k]+"  ");
            //                 }
            //                 System.out.println();
            //             }
            //     // NEW Cb::::::::::::::::::::::   
            //         cb[indexOf_minOf_minRAtio]= cj[indexOf_minOf_zj_minus_cj];

            //             System.out.println("NEW Cb");
            //         for(int r=0;r<rows;r++){

            //             System.out.println(cb[r]);
            //         }

            //         // System.out.println("old ZJ: ");
            //         //     for(int r=0;r<columns;r++){
            //         //         System.err.print(zj[r]+" ");
            //         //     }

            //     zj = cal_Zj(columns, table, cb);
            //             System.out.println("NEW ZJ: ");
            //             for(int r=0;r<columns;r++){
            //                 System.err.print(zj[r]+" ");
            //             }
            //             System.out.println();
            //    zj_minus_cj_array= cal_Zj_minus_Cj(zj, cj);
            //                 System.out.println("NEW ZJ-CJ: ");
            //             for(int r=0;r<columns;r++){
            //                 System.err.print(zj_minus_cj_array[r]+" ");
            //             }
            //             System.out.println();
               
            //             minOf_zj_minus_cj_Value = cal_min_Zj_minus_cj(zj_minus_cj_array);
            //     System.out.println("MIN OF ZJ-CJ");
            //     System.out.println(minOf_zj_minus_cj_Value);
                


            // }    
                        
            // System.out.println("ZJ Minus Cj");
            // for(int i=0;i<columns;i++){
            //     System.out.print(zj_minus_cj_array[i]+"  ");
                
            }      
        }   
    }
    