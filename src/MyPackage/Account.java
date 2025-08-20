package MyPackage;

import java.util.Scanner;

class Account{
    
    int accNum;
    int availBal;
    int userPin;
    int bankPin;
    
    void deposit(int amount){
        availBal = availBal + amount;        
    }
     
    void withdraw(int amount){
        if(availBal >= amount){
            availBal = availBal - amount;
        }else{
            System.out.println("Not sufficient balance");
            }
    }

}

class MyMain {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Account a1 = new Account();
        
        a1.accNum = 202501;
        a1.userPin = 666;
        a1.bankPin = 000;


        System.out.println("Welcome To BANK OF DEVi");
        System.out.println();
        System.out.println("ENTER YOUR ACCOUNT NUMBER: ");
        int enteraccNum = input.nextInt();
        if (enteraccNum == a1.accNum) {
         System.out.println("Press 1: Deposit");
        System.out.println("Press 2: Withdraw");
        System.out.println("Press 3: View Available Balance");
        System.out.println("Press 4: Open New Account");
        
        int askWhatToDo = input.nextInt();

        switch (askWhatToDo) {
            case 1:
                System.out.println("Enter the PIN");
                int askPin1 = input.nextInt();
                if (askPin1 == a1.bankPin) {
                    System.out.println("Enter the Amount");
                    int askAmount = input.nextInt();
                    a1.deposit(askAmount);
                    System.out.println("Available Balance: "+a1.availBal);
                    break;
                }else{
                    System.out.println("WRONG PIN");
                    break;
                }
            case 2:
                System.out.println("Enter the PIN");
                int askPin2 = input.nextInt();
                if (askPin2 == a1.userPin) {
                    System.out.println("Enter the Amount");
                    int askAmount = input.nextInt();
                    a1.withdraw(askAmount);

                    System.out.println("Available Balance: "+a1.availBal);
                    break;
                }else{
                    System.out.println("WRONG PIN");
                    break;
                }
            case 3:
                System.out.println("Enter the PIN");
                int askPin3 = input.nextInt();

                if (askPin3 == a1.userPin) {
                    System.out.println("Available Balance is: "+a1.availBal);
                    break;
                }else{
                    System.out.println("WRONG PIN");
                    break;
                } 
            default:
                System.out.println("This Option is not working");
                break;
        }

    }else{
        System.out.println("ACCOUNT DOES NOT EXIST");
    }
   
        }
        
}
