#include <stdio.h>
void main(){
    
    float basicSalary;
    float hra, da, ta, ca, epf, eepf;
    float grossSalary, netSalary;

    printf("Enter Basic Salary: ");
    scanf("%f",&basicSalary);

    hra = basicSalary*0.25;
    da = basicSalary*0.55;
    ta = basicSalary*0.09;
    ca = basicSalary*0.005;
    epf = basicSalary*0.12;
    eepf = epf;
    
    grossSalary = basicSalary + hra + da + ta + ca + epf + eepf;
    netSalary = grossSalary - epf - eepf;
    
    printf("Basic Salary: %f \nHRA: %f \nDA: %f \nTA: %f \nCA: %f \nCA: %f \nEPF: %f \nEEPF %f \nGross Salary: %f \nNet Salary: %f",basicSalary,hra,da,ta,ca,epf,eepf,grossSalary,netSalary);
    

    
    
}