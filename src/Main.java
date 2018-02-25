import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import TreePackage.BinarySearchTree;
import TreePackage.RedBlackTree;

public class Main {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static String [] command;
	private static BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	private static RedBlackTree<Integer> rbt = new RedBlackTree<Integer>();
	
	static void printCommandMenu() {
		System.out.println("Please Enter a Command");
		System.out.println("I: Insert a value");
		System.out.println("D: Delete a value");
		System.out.println("C: Count leaves of both trees");
		System.out.println("R: Get values from a range");
		System.out.println("P: Delete first 20 entries of a pre-order traversal");
		System.out.println("E: Exit the program");
		System.out.println("H: Display this message");
		
	}
	
	static void getCommand() {
		String cmdString = "";
		try {
			cmdString = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		command = cmdString.split(" ");
	}
	
	static void handleInsertCommand() {
		if(command.length > 1) {
			bst.add(Integer.parseInt(command[1]));
			rbt.add(Integer.parseInt(command[1]));
//			System.out.println(bst.inorderTraverse());
		} else {
			System.out.println("Too few arguments");
		}
	}

	static void handleDeleteCommand() {
		
	}
	
	static void handleCountCommand() {
		
	}
	
	static void handleRangeCommand() {
		
	}
	
	static void handlePreOrderDeleteCommand() {
		
	}
	
	public static void main(String[] args) {
		printCommandMenu();
		
		while(true) {
			printCommandMenu();
			getCommand();
			
			switch(Character.toUpperCase(command[0].charAt(0))) {
			case 'I':
				handleInsertCommand();
				break;
			case 'D':
				handleDeleteCommand();
				break;
			case 'C':
				handleCountCommand();
				break;
			case 'R':
				handleRangeCommand();
				break;
			case 'P':
				handlePreOrderDeleteCommand();
				break;
			case 'E':
				System.exit(0);
				break;
			case 'H':
				printCommandMenu();
				break;
			default:
				System.out.println("Invalid command, try again -> " + command[0]);
				break;
			}
			
		}
	}

}
