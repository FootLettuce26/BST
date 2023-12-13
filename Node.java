package pack;

public class Node {
	public int Data;
	public Node leftChild;
	public Node rightChild;
	public Node parentNode;
	
	public Node(int data) {
		this.Data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}
