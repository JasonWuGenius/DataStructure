package BinTree;

public class BinaryTreeDemo {
	/**
	 * �����ֱ���ʵ��
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		Object[] objs = {0,1,2,3,4,5,6,7};
		System.out.println("ԭ����Ϊ:");
		for(Object obj: objs){
			System.out.print(obj+" ");
		}
		binaryTree.createTree(objs);
		System.out.println("\n�������:");
		binaryTree.preorder(binaryTree.getRoot());
		System.out.println("\n�������:");
		binaryTree.inorder(binaryTree.getRoot());
		System.out.println("\n�������:");
		binaryTree.afterorder(binaryTree.getRoot());
	}
}
