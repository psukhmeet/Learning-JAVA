package JavaPassByValue;

import MyPackage.Account;
class Vehicle{

        int wheels;
        String color;

    Vehicle(int wheels){
        this.wheels = wheels;
    }

}

public class PassByValue {

    public static void main(String args[]){

        Account a1 = new Account();

      int accountNum=  a1.accountNum=9;
        System.out.println(accountNum);
        


    }


    
}
