package Test03;

public class Test01{
	public static void main(String[] args) {
		NodeManager nManager= new NodeManager();
		nManager.add(2);
		nManager.add(28);
		nManager.add(49);
		nManager.add(20);
		nManager.add(10);
		nManager.print();
		System.out.println("\n-------------del---------------");
		nManager.del(49);
		nManager.print();
		System.out.println("\n-------------find--------------");
		System.out.println(nManager.find(49));
		System.out.println(nManager.find(2));
		System.out.println(nManager.find(10));
		System.out.println("-------------update--------------");
		nManager.upDate(20, 99);
		nManager.print();
		System.out.println("\n-------------insert--------------");
		nManager.insert(0, 10);
		nManager.insert(2, 20);
		nManager.print();
	}
}

class NodeManager{
	private	Node root;
	private int currentIndex = 0;
	//打印
	public void print() {
		if (root!=null) {
			root.prints();
		}
	}
	
	//添加
	public void add(int data) {
		if (root==null) {
			root = new Node();
		}
		root.addNode(data);
	}
	//删除
	public void del(int data) {
		if (root==null) {
			return;
		}else {
			root.delNode(data);
		}
	}
	//查询
	public boolean find(int data) {
		if (root==null) {
			return false;
		}else {
		 	return root.findNode(data);
		}
	}
	//修改
	public void upDate(int olddata,int newdata) {
		if (root ==null) {
			return;
		}else {
			root.updataNode(olddata, newdata);
		}
	}
	//插入
	public void insert(int index,int data) {
		if (root==null) {
			return;
		}else {
			root.insertNode(index, data);
		}
		currentIndex=0;
	}
	
	
	class Node{
		private int data;
		private Node next;
		
		public Node() {}
		public  Node(int data) {
			this.data = data;
		}
		
		
		
		//添加
		public void addNode(int data) {
			if (this.next==null) {
				this.next = new Node(data);
				return;
			}else{
				this.next.addNode(data);
			}
		}
		//删除
		public void delNode(int data) {
			if (this.next==null) {
				return;
			}else if (this.next.data == data) {
				this.next = this.next.next;
			}else {
				this.next.delNode(data);
			}
		}
		//查询
		public boolean findNode(int data) {
			if (this.next==null) {
				return false;
			}else if (this.next.data == data) {
				return true;
			}else {
				return this.next.findNode(data);
			}
		}
		//修改
		public void updataNode(int olddata,int newdata) {
			if (this.next == null) {
				return;
			}else if (this.next.data == olddata) {
				this.next.data = newdata;
				return;
			}else {
				this.next.updataNode(olddata, newdata);
			}
		}
		//插入
		public void insertNode(int index,int data) {
			if (this.next ==null) {
				return;
			}else if (currentIndex == index) {
				Node newNode = new Node(data);
				newNode.next = this.next;
				this.next = newNode;
				return;
			}else {
				currentIndex++;
				this.next.insertNode(index, data);
			}
		}
		
		
		//打印
		public void prints() {
			if (this.next!=null) {
				System.out.print(this.next.data+"->");
				this.next.prints();
			}else {
				System.out.println("NULL");
			}
		}
		
		public void setData(int data) {
			this.data = data;
		}
		public int getData() {
			return data;
		}
	}
	
}
