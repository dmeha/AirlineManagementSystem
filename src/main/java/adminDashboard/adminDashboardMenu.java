package adminDashboard;

import Authentication.AuthController;
import StaffHandling.Controller.StaffHandlingController;
import Transactions.Controller.IController;
import Transactions.Controller.ViewAllTransactionDetails.TransactionDetailController;

import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class adminDashboardMenu {
    private String userName;
    public final String line = "==========================================================";
    private static adminDashboardMenu menu;
    private AuthController authController;
    private static final Stack<String> processStack = new Stack<String>(){
        {
            push("firstPaint");
        }
    };
    private Date date;


    private adminDashboardMenu(AuthController _authController)
    {
        this.authController = _authController;
    }

    public static adminDashboardMenu getController(AuthController _authController){
       if(menu ==null){
           menu = new adminDashboardMenu(_authController);
       }
    return menu;
   }

    public  boolean runner(){

        while(!processStack.isEmpty()){
            //first paint
            int selectedOptionAfterFirstPaint;
            if(processStack.peek().equals("firstPaint")){
                selectedOptionAfterFirstPaint = menu();
                String userName = authController.authenticatedUser.getUsername();
                switch (selectedOptionAfterFirstPaint){
                    case 1 :{
                        processStack.add("mealHandling");
                        //Meal Handling
                        processStack.pop();
                        break;
                    }
                    case 2:{
                        processStack.add("customerServices");
                        //Customer Service
                        processStack.pop();
                        break;
                    }
                    case 3:{
                        processStack.push("roleHandling");
                        //Roles Handling
                        processStack.pop();
                        break;
                    }

                    case 4:{
                        processStack.push("TicketHandling");
                        System.out.println("Ticket Handling");
                        processStack.pop();
                        break;
                    }

                    case 5:{
                        processStack.push("Transaction");
                        //Transaction
                        IController transactionController = new TransactionDetailController(this.userName, this.date);
                        transactionController.IController();
                        processStack.pop();
                        break;
                    }

                    case 6:{
                        processStack.push("staffHandling");
                        //staff Handling
                        StaffHandling.Controller.IController staffController = new StaffHandlingController(this.userName);
                        staffController.controller();
                        processStack.pop();
                        break;
                    }

                    case 7:{
                        processStack.push("Aircraft Handling");
                        //Aircraft Handling
                        processStack.pop();
                        break;
                    }

                    case 8:{
                        System.out.println("Logging out...");
                        authController.authenticatedUser=null;
                        processStack.clear();
                        // do not move forward this component: i.e go back to authentication.
                        return false;

                    }
                    default:{
                        System.out.println("SYSTEM: Select an appropriate option");
                        break;
                    }

                }
            }
        }

        processStack.push("firstPaint");
        //move forward : True
        return true;
    }


    public int menu(){
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        System.out.println("1. Meal Handling");
        System.out.println("2. Customer Service");
        System.out.println("3. Roles Handling");
        System.out.println("4. Ticket Handling");
        System.out.println("5. Transaction");
        System.out.println("6. Staff Handling");
        System.out.println("7. Aircraft Handling");
        System.out.println("8. Log Off");
        System.out.println();
        Scanner choiceInput = new Scanner(System.in);
        System.out.print("Enter Your Choice: ");
        int choice = choiceInput.nextInt();
        System.out.println(line);

        return choice;
    }
}
