/****************************************************************
 * file: Main.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-26
 * 
 * purpose: This program fills a Binary Search Tree and a Red Black
 * Tree with 100 random numbers. The program gives the user options
 * for adding and deleting values and evaluating the data structures
 * 
 ****************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import TreePackage.BinarySearchTree;
import TreePackage.Logger;
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
		System.out.println("BST:"+bst.inorderTraverse());
		System.out.println("RBT:"+rbt.inorderTraverse());
	}
	
	static void loadTrees() {
		Random rand = new Random();
		HashSet<Integer> pete = new HashSet<Integer>();
		while(pete.size() < 100) {
			pete.add(rand.nextInt(1000));
		}
				
		for(int i=0; i< pete.size(); i++) {
			bst.add(new Integer(pete.toArray()[i].toString()));
			rbt.add(new Integer(pete.toArray()[i].toString()));
		}
	}
	
	static void getCommand() {
		String cmdString = null;
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
		} else {
			System.out.println("Too few arguments");
		}
	}

	static void handleDeleteCommand() {
		if(command.length > 1) {
			bst.remove(Integer.parseInt(command[1]));
			rbt.remove(Integer.parseInt(command[1]));
		} else {
			System.out.println("Too few arguments");
		}
	}
	
	static void handleCountCommand() {
		System.out.println("BST Leaves: "+bst.getNumberOfLeaves());
		System.out.println("RBT Leaves: "+rbt.getNumberOfLeaves());
	}
	
	static void handleRangeCommand() {
		if(command.length > 2) {
			System.out.println(bst.getNodesInRange(new Integer(command[1]), new Integer(command[2])));
			System.out.println(rbt.getNodesInRange(new Integer(command[1]), new Integer(command[2])));
		} else {
			System.out.println("Too few arguments");
		}
	}
	
	static void handlePreOrderDeleteCommand() {
		List<Integer> bstPre = bst.preorderTraverse();
		List<Integer> rbtPre = rbt.preorderTraverse();
		if(!(bstPre.size() > 20) || !(rbtPre.size() > 20)) {
			System.out.println("Not enough entries for this function");
		} else {
			for(Integer val: bstPre.subList(0, 20)) {
				bst.remove(val);
			}
			for(Integer val: rbtPre.subList(0, 20)) {
				rbt.remove(val);
			}
		}
	}
	
	public static void main(String[] args) {
		loadTrees();
		
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
