package BinTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	private BinaryTree lChild;
	private BinaryTree rChild;
	private BinaryTree root;//�洢���ڵ�
	private Object data;//�洢������
	private List<BinaryTree> datas;//�洢���нڵ�
	public BinaryTree(BinaryTree lChild, BinaryTree rChild, Object data){
		super();
		this.lChild = lChild;
		this.rChild = rChild;
		this.data = data;
	}
	public BinaryTree(Object data){
		this(null, null, data);
	}
	public BinaryTree(){
		super();
	}
	//����
	public void createTree(Object[] objs){
		datas = new ArrayList<BinaryTree>();
		for(Object object:objs){
			datas.add(new BinaryTree(object));
		}
		root = datas.get(0);//����һ����Ϊ���ڵ�
		for(int i=0; i<objs.length/2; i++){
			datas.get(i).lChild = datas.get(i*2+1);
			if(i*2+2<datas.size()){
				datas.get(i).rChild = datas.get(i*2+2);
			}
		}
	}
	//�������
	public void preorder(BinaryTree root){
		if(root != null){
			visit(root.getData());
			preorder(root.lChild);
			preorder(root.rChild);
		}
	}
	//�������
	public void inorder(BinaryTree root){
		if(root != null){
			inorder(root.lChild);
			visit(root.getData());
			inorder(root.rChild);
		}
	}
	//�������
	public void afterorder(BinaryTree root){
		if(root != null){
			afterorder(root.lChild);
			afterorder(root.rChild);
			visit(root.getData());
		}
	}
	
	private void visit(Object obj){
		System.out.print(obj+" ");
	}
	public Object getData(){
		return data;
	}
	public BinaryTree getRoot(){
		return root;
	}
	

}
