#include <stdio.h>
#include <math.h>
void main(){
    int a,b,c;
    float s,areaOfTriangle;

    printf("Enter the sides of Triangle (Assuming Tringle is Possible)");
    scanf("%d%d%d",&a,&b,&c);
    
    s = (a+b+c)/2;
    areaOfTriangle = sqrt(s*(s-a)*(s-b)*(s-c));

    printf("Area of Triangle is: %f",areaOfTriangle);
    
}