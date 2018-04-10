package monolithic;
import java.util.Scanner;

public class monolithicUI {           //USER INTERFACE CLASS
	public static void main(String[] args)
	 {	    
	     Scanner sc = new Scanner(System.in);

	     while (true)
	     {
	         // Enter the equation in the form-
	         // "operand1 operation operand2"
	         System.out.print("Enter the expression :");
	         

	         String inp = sc.nextLine();

	         if (inp.equals("bye"))
	             break;
                 businessLogic a=new businessLogic();
	        
	         System.out.println("Answer=" + a.solve(inp));
	     }
	     sc.close();
	 }
}