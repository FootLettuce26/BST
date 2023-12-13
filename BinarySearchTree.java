package pack;

public class BinarySearchTree {
	public Node Root;
	
	public BinarySearchTree() {
		this.Root = null;
		
	}
	
	public Node Search(int value) {
		//go to Root node
		Node node = this.Root;
		//while loop for iteration
		while(node != null) {
			//matches, return node
			if(node.Data == value) {
				return node;
			}else if(value < node.Data) {
				node = node.leftChild;
			}else {
				node = node.rightChild;
			}
		}
		return null; //if nothing is found
	}
	
	public Node getRoot() {
		return this.Root;
	}
	
	public void Insert(int value) {
		Node newNode = new Node(value); //creating a new node with the data being the value
		Node node = this.Root;
		while(node != null) {
			if(node.Data == value) {
				if(node.leftChild == null) { //inserting into left if open 
					node.leftChild = newNode;
					newNode.parentNode = node;
				}else if(node.rightChild == null) { //insert to right if open and if left is not null
					node.rightChild = newNode;
					newNode.parentNode = node;
				}else { //automatically moving down the left node
					node = node.leftChild;
					newNode.parentNode = node;
				}
			}else if(value < node.Data) {
				if(node.leftChild == null) {
					node.leftChild = newNode;
					newNode.parentNode = node;
				}
				node = node.leftChild;
			}else {
				if(node.rightChild == null) {
					node.rightChild = newNode;
					newNode.parentNode = node;
				}
				node = node.rightChild;
			}
		}
		if(node == null) {
			this.Root = newNode;
		}
	}
	
	public boolean Remove(int key) {
		   Node parent = null;
		   Node currentNode = Root;
		      
		   // Search for the node.
		   while (currentNode != null) {
		      // Check if currentNode has a matching key.
		      if (currentNode.Data == key) {
		         if (currentNode.leftChild == null && currentNode.rightChild == null) { // Case 1
		            if (parent == null) { // Node is Root
		               Root = null;
		            }
		            else if (parent.leftChild == currentNode) { 
		               parent.leftChild = null;
		            }
		            else {
		               parent.rightChild = null;
		            }
		            return true; // Node found and removed
		         }
		         else if (currentNode.leftChild != null && currentNode.rightChild == null) { // Case 2
		            if (parent == null) { // Node is Root
		               Root = currentNode.leftChild;
		            }
		            else if (parent.leftChild == currentNode) {
		               parent.leftChild = currentNode.leftChild;
		            }
		            else {
		               parent.rightChild = currentNode.leftChild;
		            }
		            return true; // Node found and removed
		         }
		         else if (currentNode.leftChild == null && currentNode.rightChild != null) { // Case 2
		            if (parent == null) { // Node is Root
		               Root = currentNode.rightChild;
		            }
		            else if (parent.leftChild == currentNode) {
		               parent.leftChild = currentNode.rightChild;
		            }
		            else {
		               parent.rightChild = currentNode.rightChild;
		            }
		            return true; // Node found and removed
		         }
		         else { // Case 3
		            // Find successor (leftmost child of right subtree)
		            Node successor = currentNode.rightChild;
		            while (successor.leftChild != null) {
		               successor = successor.leftChild;
		            }
		            currentNode.Data = successor.Data; // Copy successor to current node
		            parent = currentNode;
		            currentNode = currentNode.rightChild; // Remove successor from right subtree
		            key = successor.Data;             // Loop continues with new key
		         }
		      }
		      else if (currentNode.Data < key) { // Search right
		         parent = currentNode;
		         currentNode = currentNode.rightChild;
		      }
		      else { // Search left
		         parent = currentNode;
		         currentNode = currentNode.leftChild;
		      }
		   }
		   return false; // Node not found
		}
}
