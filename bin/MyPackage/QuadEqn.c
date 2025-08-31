#include <stdio.h>
#include <math.h>
void main(){
    int a,b,c;
    float d, D, r1, r2;
    printf("Enter the co-efficient of Quadradtic Eqn: (a is not equals to 0)");
    scanf("%d%d%d",&a,&b,&c);

    d = b*b-(4*a*c);
    D = sqrt(d);

    r1= (-b+D)/(2*a);
    r2= (-b-D)/(2*a);

    printf("First Root is: %f & Second Root is: %f",r1,r2);
}