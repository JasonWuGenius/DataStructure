package BinTree;

public class BinaryTreeDemo {
	/**
	 * 树三种遍历实验
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		Object[] objs = {0,1,2,3,4,5,6,7};
		System.out.println("原序列为:");
		for(Object obj: objs){
			System.out.print(obj+" ");
		}
		binaryTree.createTree(objs);
		System.out.println("\n先序遍历:");
		binaryTree.preorder(binaryTree.getRoot());
		System.out.println("\n中序遍历:");
		binaryTree.inorder(binaryTree.getRoot());
		System.out.println("\n后序遍历:");
		binaryTree.afterorder(binaryTree.getRoot());
	}
}
