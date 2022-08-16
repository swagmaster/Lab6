/*-----------------------------------------------------------------------------------
 * 
 *	sum( n ) is a summation algorithm defined as follows:

 *				
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *			
 *	(2)	    sum( n ) = n + sum( n - 1 ) 
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 ) 
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1 
 *
 *----------------------------------------------------------------------------------- */ 

import java.awt.Dimension;

import javax.swing.*;
	
public class RecursionLab {
	
	private static JTextArea myArea = new JTextArea();
	private static int count = 0;
	
	public static void main( String args[] ) {	//invoke the recursive method here...
		
		/**
		 * TODO: switch between the two commented lines below and execute this code, 
		 * observing the output for both the iterative solution and the recursive solution.
		 * To watch the recursive behaviour in action, set a breakpoint on the if statement
		 * inside the recursiveSum() function
		 * 
		 */
		int solution = iterativeSum( 20 );
		//int solution = recursiveSum( 20 );
		
		System.out.println("Testing factorial sum with n = 4: " + factorialSum(4));
		
		System.out.println("Testing Power1(2, 3): " + Power1(2, 3));
		
		System.out.println("Testing Power2(2, 4): " + Power2(2, 4));
		
		System.out.println("Testing FibNum(6): " + FibNum(6));
		
		System.out.print("Testing FibSequence(6): ");		
		FibSequence(6);
		
		//Some GUI details
		/*
		myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
		JScrollPane myPane = new JScrollPane( myArea );
		myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myPane.setPreferredSize(new Dimension(600,300));
		JOptionPane.showMessageDialog( null, myPane );
		
		//good form to include an exit call when GUIing in Java 
		System.exit(0);
		*/
	}
	
	
	
	/** recursion is similar to iterative looping, but we
	 *  use method calls to repeat computations (or decompose the problem) 
	 *  instead of explicit looping control structures 
	 */
	public static int recursiveSum( int n ) {
		updateRecursiveDisplay(n);			//overhead for nice output, not required
		if( n == 1)			//if we're at the base case...
			return 1;		//then return the answer to the simplest problem which we know how to solve
		else				//otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep recursing
			return ( n + recursiveSum( n - 1) );
	}						//for this method to terminate, we must be breaking the problem down into smaller
							//and smaller problems, until we reach the simplest form of the problem which we know
							//how to solve (in this case, it's the fact that sum( 1 ) == 1 )
	
	/*
	 * summation to factorial function
	 */
	public static int factorialSum(int n) {
		if (n == 0) {
			return 0;		}
		if(n == 1) {
			return 1;
		} else {
			return n * factorialSum(n - 1);
		}
	}
	
	/*
	 * the exponent functions
	 */
	public static int Power1(int x, int n) {
		if(n == 0) {
			return 1;
		} else {
			return x * Power1(x, n - 1);
		}
	}
	
	public static int Power2(int x, int n) {
		if( n == 0) {
			return 1;
		} else if(n % 2 == 0) {
			return x * Power2(x, n/2);
		} else {
			return x * Power2(x, (n-1)/2);
		}
	}
	
	public static int FibNum(int n) {
		if(n == 0) {
			return 0;
		} else if ( n == 1) {
			return 1;
		} else {
			return FibNum(n - 1) + FibNum(n - 2);
		}
	}
	
	public static void FibSequence(int n) {
		if(n == 0) {
			System.out.print("0");
		} else if (n == 1) {
			System.out.print("0 1");
		} else {
			FibSequence(n-1);
			System.out.print(" " + FibNum(n));
		}
		
	}
	
 
	//the iterative counterpart to the above recursion
	//notice how it's longer? At times, an iterative solution may require more code than the recursive counterpart, 
	//but, the recursive solution is slower and more memory intensive.  We can always recast recursion as iteration.
	public static int iterativeSum( int i ) {
		int total = 0;
		
		for( int n = i; n >= 1; n--) {
			updateIterativeDisplay(n);
			total = total + n;
		}
		return total;
	}						
	
	public static void updateIterativeDisplay(int n) {
		count++;
		String text = myArea.getText();
		
		text += "\n/*******************Loop iteration " + count + "**************************************";
		text += "\n Calling iterativeSum( int n = " + n +" ). Total += " + n;
		text += "\n***************************************************************************/";
		
		myArea.setText( text );
	}
							
							
	//ignore this method unless interested in the output string						
	public static void updateRecursiveDisplay(int n) {
		
		count++;
		String text = myArea.getText();
		
		
		if( count == 1 )  {
			text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}
		
		
		text += "\n/*******************Method invocation " + count + "*********************";
		
		
		text += "\n Calling recursiveSum( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";
		
		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( "+ (n - 1) +" ));";
		} else {
			text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";
		
		myArea.setText( text );
		
	}
}



/*
 * 
 * 
 * Given a target file to find and a starting directory, determine if and where the target file exists.
 * 
 * 1. Setup and Initialization
 * 	
 * define the target variable here
 * initialize file here
 * 
 * try{ finding file
 * catch{ if file isn't found, throw error exception
 * 
 * 2. Input
 * 
 * Use scanner to ask user for input
 * store the input into the target variable
 * 
 * Scanner input = new Scanner(System.in)
 * input.next = target;
 * 
 * 
 * 3. Processing
 * 
 * Use while loop to check if a file is a directory or not.

public static String searchFiles(File path, String target) {

check if path is actually a dir, abort if not


if a file{ call serachFiles to search the file recursively

check for a match and return if found

if a directory, repeat these steps

if found in the directory, return found

return �Not found�; //if we made it here, we didn�t find it


 * 
 * 
 * 4. output
 * 
 *public static void main(String[] args)
 *
 *	try and catch files here
 *
 *	save input from user into variable
 *	
 *	call searchFiles using the files pass through as parameters
 *
 *	print(searchFiles)
 * 
 * 
 */














	

	
	
	
