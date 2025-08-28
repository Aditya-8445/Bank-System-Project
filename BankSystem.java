import java.util.*;
class Account{
    private int accountNumber;
    private String name;
    private double balance;

    Account(int accountNumber, String name, double balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getName(){
        return name;
    }

    public double getbalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println(" Deposited : "+amount+" New balance :"+balance);
    }

    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdraw :"+amount+"New balance :"+balance);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public String toString(){
        return accountNumber +" - "+name+" | Balance :"+balance;
    }
}

// ACCOUNT CREATED SUCCESSFULLY

class Bank{
    private List<Account>accounts = new ArrayList<>();

    void createAccount(int accountNumber, String name, double initiaBalance){
        accounts.add(new Account(accountNumber, name, initiaBalance));
        System.out.println("Account created successfully");
    }

    Account findAccount(int accountNumber){
        for(Account acc : accounts){
            if(acc.getAccountNumber() == accountNumber){
                return acc;
            }
        }
        return null;
    }
    
    // ACCOUNT SEARCHING

    void showAccounts(){
        if(accounts.isEmpty()){
            System.out.println("No account found");
            return;
        }
        for(Account acc : accounts){
            System.out.println(acc);
        }
    }
}

public class BankSystem{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while(true){
    
    System.out.println("\n===Bank Menu===");
    System.out.println("1. Create Account");
    System.out.println("2. Show All Accounts");
    System.out.println("3. Dwposit Money");
    System.out.println("4. Withdraw Money");
    System.out.println("5. Exit");
    System.out.print("Enter choice : ");
        int ch = sc.nextInt();
        sc.nextLine();   //BUFFER CLEAR

        switch(ch){

         case 1:
            System.out.print("Enter Account Number : ");
            int accountNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Intial Balance : ");
            double bal = sc.nextDouble();
            bank.createAccount(accountNumber, name, bal);
            break;

        case 2:
            bank.showAccounts();
                break;

        case 3:
            System.out.print("Enter Account Number : ");
            accountNumber = sc.nextInt();

            System.out.print("Enter Amount to Deposit: ");
            double dep = sc.nextDouble();
            Account acc1 = bank.findAccount(accountNumber);

            if(acc1 != null){
                acc1.deposit(dep);
            }
            else{
                 System.out.println("Account Not Found ! ");
                 break;
            }

            case 4:
                 System.out.print("Enter Account Number : ");
                 accountNumber = sc.nextInt();


                System.out.print("Enter Amount to Withdraw : ");
                double wd = sc.nextDouble();
                Account acc2 = bank.findAccount(accountNumber);

                if(acc2 != null){
                    acc2.withdraw(wd);
                }
                else{
                     System.out.println("Account not found ! ");
                     break;
                }

                case 5:
                    System.out.println("Exitint....");
                    return;

                    default:
                     System.out.println("Invalid choice ! ");

            }
        }
    }
}