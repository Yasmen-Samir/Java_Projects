package software;

import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        
    String input;
    Scanner scanner = new Scanner(System.in);

    Bank bank = new Bank ();

    do        
{
        System.out.println("Please enter a choice from 1 to 4: "); 
        System.out.println("1- add new client");
        System.out.println("2- add new commercial client");
        System.out.println("3- List all accounts / clients information");
        System.out.println("4- Quit" + "\n");
               
        input =(scanner.nextLine());
                
        if (input.equals("1"))
        {   
            System.out.println("Please enter the client information in this order (Name / National ID / Address / Phone)");
            
            String name = scanner.next();
            long nationalId = scanner.nextLong();
            String address = scanner.next();
            long phone = scanner.nextLong();
            
            System.out.println("Please enter the client's account information in this order (Account number / balance)");
            
            int accountNumber = scanner.nextInt();
            double balance = scanner.nextDouble();
            Account account1 = new Account (accountNumber, balance);  
            
            Client client = new Client (name,nationalId,address,phone, account1);
            bank.addClient(client);    
            
            while (true)
            {
            System.out.println("Do you want to withdraw or deposit money ?: / (Yes or No)");
            String answer1 = scanner.next();
            
            if (answer1.equalsIgnoreCase("Yes"))
            {
                while (true)
                {
                System.out.println("Which process will you do, withdraw or deposit money ?: / (Withdraw or Deposit)");
                String answer2 = scanner.next();
            
                
                if (answer2.equalsIgnoreCase("Withdraw"))
                {
                    System.out.println("Please enter the amount of money you want to withdraw");
                    double money = scanner.nextDouble();
                    
                    Account account = new SpecialAccount();
                    account.set_balance(account1.get_balance());
                    account.withdraw(money);
                    account1.set_balance(account.get_withdraw());
                           
     
                    break;
                }
                
                
                else if (answer2.equalsIgnoreCase("Deposit"))
                {
                    System.out.println("Please enter the amount of money you want to deposit");           
                    double money2 = scanner.nextDouble();
                    account1.deposit(money2);
                    System.out.println("Balance after deposit: " + account1.get_deposit());
                    account1.set_balance(account1.get_deposit());
                    
                    break;
                }
                
                else
                {
                    System.out.println("Please enter a valid choice");
                }
                
                }
                
            }
            
            else if (answer1.equalsIgnoreCase("No"))
            {
                break;
            }
            
            else
            {
                System.out .println("Please enter a valid choice");  
            }
                       
            }
            
            bank.addAccount(account1);
        }
        
        else if (input.equals("2"))
             
        {   
            System.out.println("Please enter the commercial client information in this order (Name / Commercial ID / Address / Phone)");    
        
            String name2 = scanner.next();
            long commercialId = scanner.nextLong();
            String address2 = scanner.next();
            long phone2 = scanner.nextLong();
            
            System.out.println("Please enter the commercial client's account information in this order (Account number / balance)");
            int accountNumber2 = scanner.nextInt();
            double balance2 = scanner.nextDouble();
            
            Account account2 = new Account (accountNumber2, balance2);           
            
            CommercialClient commercialClient = new CommercialClient (name2,commercialId,address2,phone2, account2);
            bank.addCommercialClient(commercialClient);
            
            while (true)
            {
            System.out.println("Do you want to withdraw or deposit money ?: / (Yes or No)");
            String answer3 = scanner.next();
            
            if (answer3.equalsIgnoreCase("Yes"))
            {
                while (true)
                {
                System.out.println("Which process will you do, withdraw or deposit money ?: / (Withdraw or deposit)");
                String answer4 = scanner.next();
            
                if (answer4.equalsIgnoreCase("Withdraw"))
                {
                    System.out.println("Please enter the amount of money you want to withdraw");
                    double money = scanner.nextDouble();

                    Account account3 = new SpecialAccount();
                    account3.set_balance(account2.get_balance());
                    account3.withdraw(money);
                    account2.set_balance(account3.get_withdraw());
                           
                                       
                    break;
                }
                
                else if (answer4.equalsIgnoreCase("deposit"))
                {
                    System.out.println("Please enter the amount of money you want to deposit");           
                    double money2 = scanner.nextDouble();
                    account2.deposit(money2);
                    System.out.println("Balance after deposit: " + account2.get_deposit());
                    account2.set_balance(account2.get_deposit());
                    
                    break;
                }
                   
                else 
                {
                    System.out .println("Please enter a valid choice");                    
                }
                
                }
                                
            }
            
            else if (answer3.equalsIgnoreCase("No"))
            {
                break;
            }
            
            else
            {
                System.out .println("Please enter a valid choice");              
            }
            
            }
            
            bank.addAccount(account2);
            
        }                
       
  
        else if (input.equals("3"))
            
        {   
            System.out.println("Accounts are:");
            System.out.println("******************************************" + "\n");
            System.out.println(bank.displayAccounts());
            System.out.println("******************************************" + "\n");
            
            System.out.println("Clients are:");
            System.out.println("******************************************" + "\n");
            System.out.println(bank.displayClients());
            System.out.println("******************************************" + "\n");
            
            System.out.println("Commercial clients are:");
            System.out.println("******************************************" + "\n");
            System.out.println(bank.displayCommercialClients());
            System.out.println("******************************************" + "\n");
        } 
        
    
    
    }   while(!input.equals("4"));  
        
             
    }

}