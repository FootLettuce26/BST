package pack;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		  Scanner scnr = new Scanner(System.in);
	      BinarySearchTree tree = new BinarySearchTree();
	      
	      tree.Insert(0);
	      tree.Insert(1);
	      tree.Insert(5);
	      tree.Insert(3);
	      tree.Insert(7);
	      tree.Insert(4);
	      tree.Insert(9);
	      tree.Insert(8);
	      tree.Insert(6);
	      tree.Insert(2);
	      
	      
	      tree.Search(0);
	      tree.Search(7);
	      tree.Search(2);
	      
	      // Show the tree
	      System.out.println("Initial tree:");
	      System.out.println(BSTPrint.treeToString(tree.getRoot()));
	      System.out.println();
	      
	   // Ask the user for a value to remove
	      System.out.print("Enter value to remove: ");
	      String removeValueString = scnr.nextLine();
	      int removeValue = Integer.parseInt(removeValueString);
	      System.out.println();
	      
	      
	      
	      System.out.printf("Tree after removing %d:%n", removeValue);
	      tree.Remove(removeValue);
	      System.out.println(BSTPrint.treeToString(tree.getRoot()));
	}
	
}
