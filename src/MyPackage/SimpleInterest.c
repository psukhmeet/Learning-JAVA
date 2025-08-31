#include <stdio.h>
void main() {
    float p,r,t,si;
    printf("ENTER PRINCIPAL AMOUNT, ROI & S.I. RESPECTIVELY ");
    scanf("%f%f%f",&p,&r,&si);

    t = (si*100)/(p*r);

    printf("TIME IS %f YEARS",t);
}