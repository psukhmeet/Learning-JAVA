#include <stdio.h>
void main(){
    
    int a,b;
    printf("ENTER TWO NUMBERS: ");
    scanf("%d%d",&a,&b);
    
    //BITWISE OPERATORS:
    printf("Bitwise AND of 'a' & 'b' %d \n:", a&b);
    printf("Bitwise OR of 'a' & 'b' %d \n:", a|b);
    printf("Bitwise NOT of 'a' %d \n:", ~a);
    printf("Left Shift of 'a' & 'b' %d \n:", a<<1);
    printf("Right Shift of 'a' & 'b' %d \n:", a>>1);

    //INCREMENT/DECREMENT OPERATORS:
    printf("Pre-Increment: %d and Cheching Input %d", ++a, a);
    printf("Post-Increment: %d and Cheching Input %d", a++, a);
    printf("Pre-Decrement: %d and Cheching Input %d", --a, a);
    printf("Post-Decrement: %d and Cheching Input %d", a--, a);

}