package com.hibernate.CarPurchaseApplication;
import services.CustomerService;
import serviceimpl.CustomerServiceImpl;
import entities.Salesperson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import entities.Customer;
import serviceimpl.SalespersonServiceImpl;
import services.SalespersonService;
import alloperations.CustomerOperations;
import alloperations.SalespersonOperations;

public class App 
{
    public static void main( String[] args ) throws IOException
    {        
    	// Displaying the main menu
    	System.out.println("----------------------------------------------------------------------");
    	System.out.println();
        System.out.println("----------------WELCOME TO Car Dealership Application-----------------");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Are You ?");
        System.out.println("SalesPerson OR Customer");
    	boolean flag = true;
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (flag) {
              try {
            	  System.out.println("---------------------------------------------------------------------");
            	  System.out.println("Choose Your Option : ");
            	  System.out.println("---------------------------------------------------------------------");
            	  System.out.println();
            	  System.out.println("For Sales Person [Enter 1]");
            	  System.out.println("For Cutomer [Enter 2]");
            	  int choice = Integer.parseInt(reader.readLine());
            	  System.out.println();
            	  switch(choice) {
            	  case 1:
            		// Create an instance of SalespersonDao
                      SalespersonService salespersonDao = new SalespersonServiceImpl();
                        System.out.print("Enter the Salesperson ID : ");
                        Long salespersonID =Long.parseLong(reader.readLine());
						System.out.print("Enter the Salesperson name : ");
						String salespersonName = reader.readLine();
						System.out.print("Enter the Salerperson Mail  : ");
						String salespersonMail = reader.readLine();
						System.out.print("Enter the Salerperson Phone number  : ");
						String salespersonPhoneno = reader.readLine();
						System.out.print("Enter the Password : ");
						String salespersonPassword = reader.readLine();
						
                      // Create an instance of salesperson with sample data
						Salesperson salesperson = new Salesperson(salespersonID, salespersonName, salespersonMail, salespersonPhoneno, salespersonPassword);
						
						// Register the salesperson
						salespersonDao.addSalesperson(salesperson);
						System.out.println("----------------------------------------------------------");
						System.out.println("-----------Salesperson registered successfully-------------");
						System.out.println("----------------------------------------------------------");
					
						boolean flag2 = true;
						while (true) {
							System.out.println("------------------------Sell your car---------------------");
							System.out.println("Add Your Car Details For Selling [Enter 1]");
			            	System.out.println("Update Your Car Details  [Enter 2]");
			            	System.out.println("Delete Your Car [Enter 3]");
			            	System.out.println("See all Your Car [Enter 4]");
			            	System.out.println("For Exit !! [Enter 5]");
							System.out.println("----------------------------------------------------------");
							
							SalespersonOperations salespersonOperations = new SalespersonOperations();
							int Operations = Integer.parseInt(reader.readLine());
						    switch (Operations) {
						        case 1:
						        	salespersonOperations.addCar();
						        	System.out.println("-----------------------------------------------------------------------");
						            break;
						        case 2:
						        	salespersonOperations.updateCar();
						        	System.out.println("-----------------------------------------------------------------------");
						            break;
						        case 3:
						        	salespersonOperations.deleteCar();
						        	System.out.println("-----------------------------------------------------------------------");
						            break;
						        case 4:
						        	salespersonOperations.displayAllCars();
						        	System.out.println("-----------------------------------------------------------------------");
						            break;
						        case 5:
						            flag2 = false; // This should update the flag to exit the loop
						            break; // You need to break out of the loop after setting the flag to false
						        default:
						            System.out.println("-----------------Invalid operations-------------");
						            System.out.println("----------------choose Corrrect Option-------------");
						    }
						}
            	  case 2:
            			// Create an instance of customerDao
            			CustomerService customerDao = new CustomerServiceImpl();
            			System.out.print("Enter the Customer ID : ");
                        Long customerId =Long.parseLong(reader.readLine());
            			System.out.print("Enter the customer name : ");
            			String cutomerName = reader.readLine();
            			System.out.print("Enter the customer Mail  : ");
            			String cutomerMail = reader.readLine();
            			System.out.print("Enter the customer Phone number  : ");
            			String cutomerPhoneno = reader.readLine();
            			System.out.print("Enter the Password : ");
            			String cutomerPassword = reader.readLine();
            			
            		    // Create an instance of customer with sample data
            			Customer customer = new Customer(customerId, cutomerName, cutomerMail, cutomerPhoneno, cutomerPassword);
            			
            			// Register the customer
            			customerDao.addCustomer(customer);
            			System.out.println("----------------------------------------------------------");
            			System.out.println("-----------Customer registered successfully-------------");
            			System.out.println("----------------------------------------------------------");
            
            			boolean flag3 = true;
            			while(flag3) {
            				System.out.println("------------------------Do !! What you want ---------------------");
                			System.out.println("See All Car Details [Enter 1]");
                			System.out.println("Get Car By Price [Enter 2]");
                			System.out.println("Get Car By Brand [Enter 3]");
                			System.out.println("For Buying car [Enter 4]");
                			System.out.println("For Exit !! [Enter 5]");
                			System.out.println("----------------------------------------------------------");
                			int OperationsOfCustomer = Integer.parseInt(reader.readLine());
                			CustomerOperations customerOperations = new CustomerOperations();
            				switch(OperationsOfCustomer){
            			       case 1:
            			    	   customerOperations.getAllCars();
            			    	   System.out.println("-----------------------------------------------------------------------");
            			    	   break;
            			       case 2:
            			    	   customerOperations.getCarsByPriceRange();
            			    	   System.out.println("-----------------------------------------------------------------------");
            			    	   break;
            			      case 3:
            			    	  customerOperations.getCarsByBrand();
            			    	  System.out.println("-----------------------------------------------------------------------");
            			    	  break;
            			      case 4:
            			    	  customerOperations.buyCar(customer);
            			    	  System.out.println("-----------------------------------------------------------------------");
            			    	  break;
            			      case 5:
            			    	  System.out.println("--------------------Invalid Choice----------------");
              			    	  System.out.println("----------------choose Corrrect Choice-------------");
            			    	  System.out.println("-----------------------------------------------------------------------");
            			    	  flag3 = false;
            			    	  break;
            		      }
            		   }  
            			break;
            	  case 3 :
            		  System.out.println("-----------------------------------------------------------------------");
            			System.out.println("--------------------Invalid Choice----------------");
    			    	System.out.println("----------------choose Corrrect Choice-------------");
    			    	System.out.println("-----------------------------------------------------------------------");
    			    	break;
    			    default :
            	  }
                } catch (InputMismatchException e) {
                    // Handling any unexpected exceptions and printing the error message
                    System.out.println("Error Occurred: Invalid input! Please enter a valid integer.");
                }
          }
     }
}