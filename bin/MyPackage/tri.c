#include <stdio.h>
void main(){
    
    int side1, side2, side3;
    printf("ENTER THE SIDES OF TRIANGLE: ");
    scanf("%d%d%d",&side1,&side2,&side3);
    
    if(side1+side2>side3 && side2+side3>side1 && side1+side3>side2){

        if(side1==side2 && side1==side3){
            printf("Triangle is:  Triangle");
        }else if(side1==side2 || side2==side3 || side3==side1){
            printf("Triangle is: Isosceles Traingle");
        }else if(side1*side1+side2*side2-side3*side3==0 || side2*side2+side3*side3-side1*side1==0 || side3*side3+side1*side1-side2*side2==0){
            printf("Triangle is: Right Angle Triangle");
        }else{
            printf("Triangle is: Scalene Triangle");
        }
    }else{
        printf("Triangle is NOT POSSIBLE, Try with another sides");
    }
}    
    