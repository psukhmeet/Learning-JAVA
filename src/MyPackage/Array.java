package MyPackage;

import java.util.Scanner;
import java.io.*;

public class Array {
    
    //:::::::::::::::::::::::SPAN OF ARRAY:::::::::::::::::::::::::::::::  
    public static int spanOfArray(int[] arr){
        int max=arr[0];
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr [i]>max) max=arr[i];
            
            if (arr[i]<min) min=arr[i];
        }
        int soa =max-min;
        return soa;
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



    //::::::::::::::::::::FINDING ELEMENT FROM ARRAY::::::::::::::::::::::
    public static void findAnElement(int[] arr, int d){  
        int index=-1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==d){
                System.out.println("ELEMENT FOUND AT INDEX "+i);
                index=0;
                break;
            }
        }
        if(index==-1) System.out.println("-1");
    }
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::   
        

    
    //:::::::::::::::::::::::::BAR CHART:::::::::::::::::::::::::::::::
    public static void barChart(int[] arr){
        
        int max= arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }


        for(int i=0; i<arr.length;i++){
            for(int j=0;j<arr[i];j++){
                System.out.print(" ");
            }
            System.out.println();
        }


        for(int i=0; i<arr.length;i++){
            for(int j=0;j<arr[i];j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    // public static void main(String[] args) throws IOException {
        
        //Scanner input = new Scanner(System.in);
        
        //BAR CHART:::::::::::::::::::::

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // String name = br.readLine(); 
    // System.out.println("name is: "+name);

    // System.out.println("ENTER ANYTHING");

    // String sr = input.nextLine();


    // for(int i=0;i<sr.length();i++){
    //     int j = sr.length()-1;
    //     if(sr.charAt(i)==sr.charAt(j) && j>=0){
    //         j--;
    //     }else{
    //         System.out.println("NOT A PALINDROME ");
    //     }
    
    // }
  //  System.out.println(sr.charAt(0));








       
    //    int a = 10;
    //    int b = 20;
    //    int c = 15;

    //    int d = (a>b)? (a>c)? a:c : (b>c)? b:c ;
       
    //    System.out.println(d);
       
       
        // System.out.println("ENTER LENGTH OF ARRAY: ");
        // int n = input.nextInt();

        // int[] arr = new int[n];
        // System.out.println("ENTER ELEMENTS: ");
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=input.nextInt();
        // }
        
        // barChart(arr);

        



        

        
        //Declaration of Array:::
        //..............................
        //..............................

        // int[] arr;
        // arr= new int[5];

        // for(int i=0 ; i<arr.length;i++){
        //     System.out.println("ENTER MARKS OF "+i+"th Student");
        //     arr[i] = input.nextInt();
        // }
        // for(int i=0 ; i<arr.length;i++){
        //     System.out.println(arr [i]);
        // }    
        
        //.................................
        //.................................

        //implication 2nd

        //.................................
        //.................................
        
        // int[] one= new int[3];
        // one[0]=10;
        // one[1]=5;
        // one[2]=9;
        
        // int[] two = one;
        // two[1]= 500;

        // for(int i=0; i< one.length;i++){
        //     System.out.println(one[i]);
        // }
        // System.out.println();

        // for(int i=0; i< two.length;i++){
        //     System.out.println(two[i]);
        // }

        // System.out.println("last"+ one);
        
        //..................................................
        //..................................................

        //SPAN OF ARRAYS
        // System.out.println("ENTER THE LENGTH OF ARRAY: ");
        // int n = input.nextInt();

        // int[] arr = new int[n];
        // for(int i=0; i<arr.length;i++){
        //     System.out.println("ENTER "+(i+1)+"th NUMBER");
        //     arr[i] = input.nextInt();
        // }

        // int max=arr[0];
        // int min=arr[0];


        //LOGIC(SELF)......................
        // for(int i=0; i<arr.length; i++){
        //     for(int j=1; j<arr.length; j++){
                
        //         if(arr[i]>arr[j]){
        //             if(arr[i]>max){
        //                 max=arr[i];
        //             }
        //             if(arr[j]<min){
        //                 min=arr[j];
        //             }
        //         }else{
        //             if(arr[j]>max){
        //                 max=arr[j];
        //             }
        //             if(arr[i]<min){
        //                 min=arr[i];
        //             }
        //         }   
        //     }            
        // }

        //LOGIC(PepCoding).......................
    //     for(int i=0; i<arr.length; i++){
    //         if(max<arr[i]){
    //             max=arr[i];
    //         }
    //         }
    //         if(min>arr[i]){
    //             min=arr[i];
    //     }

    //     System.out.println("MAX IS: "+max+"\nMIN IS: "+min);
    //     System.out.println("SPAN OF ARRAY IS "+(max-min));
        
    
    // int[] arr;
    // System.out.println("ENTER THE LENGTH OF ARRAY: ");
    // int n = input.nextInt();
    // arr= new int[n];

    // System.out.println("ENTER THE ELEMENTS: ");
    // for(int i=0; i<arr.length;i++){
    //     arr[i] = input.nextInt();
    // }

    // System.out.println("ENTER THE FINDING ELEMENT: ");
    // int d = input.nextInt();
    // findAnElement(arr, d);
    
    // } 
    
    


    

    // System.out.println("ENTER NUMBER: ");
    // int n = input.nextInt();

    // int ite=0;
    // int d=n;
    
    // for(int i=1;d!=0;i++){
    //    int r = d/10;
    //    d=r;
    //    ite=i;
    // }
    
    // System.out.println(ite);

    // int temp;
    // int faltu=n;
    // int divide[]= new int[ite];
    // for(int i=0;i < ite;i++){
    //     faltu=faltu/10;
    //     divide[i] = faltu;
        
        
    // }

    // for(int i=0; i<divide.length-1;i++){
    //     System.out.println(divide[i]);
    // }
    
    
    //........................................
    //........................................
    //........................................
    
    // System.out.println("Enter the length of an array: ");
    
    // int n = input.nextInt();

    // int[] arr = new int[n];
    // System.out.println("ENTER THE ARRAY ELEMENTS: ");
    // for(int i=0;i<arr.length;i++){
    //     arr[i] = input.nextInt();
    // }

    // System.out.println("ENTER TARGET ELEMENT: ");
    // int d = input.nextInt();
    // int index=-1;
    // for(int i=0;i<arr.length;i++){
    //     if(arr[i]==d){
    //         System.out.println("FOUND AT: " + i);
    //         index =0;
    //         break;
    //     }
    //     // else if(arr[i]!=d){
    //     //     index=-1;
    //     // }
    // }
    // if(index==-1){
    //     System.out.println("NOT FOUND (-1)");
    // }
    
    
int a=10;
int b=14;
int r = a++;
System.out.println(r);
?

    }

