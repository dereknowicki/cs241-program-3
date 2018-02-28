/****************************************************************
 * file: Logger.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-28
 * 
 * purpose: This is a helper class for printing to the console.
 * 
 ****************************************************************/

package TreePackage;

public class Logger {
	/**
	 * method: printlns
	 * @param values
	 * purpose: print every object on a seperate line
	 */
	public static void printlns(Object... values) {
		for(Object val:values) {
			System.out.println(val.toString());
		}
	}
	
	/**
	 * method: println
	 * @param values
	 * purpose: print all objects on the same line
	 */
	public static void println(Object... values) {
		for(Object val:values) {
			System.out.print(val.toString() +" ");
		}
		System.out.print('\n');
	}
}
