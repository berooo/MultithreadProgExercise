package iss.java.List;

/**
 * Created by Shibaorong on 2016/10/2.
 */
public class MyList {
    // two guards. Do not call remove() on them!!
    private static Node head;
    private static Node tail;
    private static int size;
    public static final Object obj=new Object();	//建立静态object对象obj
    static MyList list = new MyList();
    
    public MyList() {				//构造函数
    	
        head = new Node().setData(0);
        tail = new Node().setData(0).setNext(null).setPrev(head);
        head.setNext(tail);
        size = 0;
        
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    /**
     * Insert a node with <pre>data</pre> after <pre>_prev</pre>.
     *
     * @param _prev
     * @param data
     * @return The node just inserted.
     */
    public void insert(int _prevnumber, int data) {			//插入节点函数
    	synchronized(obj){			//synchronized互斥锁
    		
    		System.out.println("要插入的值为："+data);
    		
    		Node _prev=new Node();_prev=list.getHead();		//创建_prev节点，并初始化为头节点
    		for(int i=0;i<_prevnumber;i++)_prev=_prev.getNext();	//使_prev移到_prevnumber所对应的节点上
    		
	        Node node = new Node().setData(data).setNext(_prev.getNext()).setPrev(_prev);		//插入节点操作
	        _prev.getNext().setPrev(node);
	        _prev.setNext(node);
	        
	        ++size;
	        
	        tranverse_list_Display();		//展示链表
	        backtranverse_list_Display();	//展示逆置链表
       
        }
    }

      public void remove(int targetnumber) {			//删除节点函数
    	synchronized(obj){
        if (targetnumber == 0 || targetnumber == list.getSize()+2)
            throw new RuntimeException("DO NOT remove the head or tail node. They are guards.");
        
        Node target=new Node();target=list.getHead();		//创建target节点，并初始化为头节点
        for(int i=0;i<targetnumber;i++)target=target.getNext();		//使target节点移到targetnumber所对应的节点上
        
        System.out.println("要删除的值为："+target.getData());
        
        Node prev = target.getPrev();		//删除节点操作
        Node next = target.getNext();
        prev.setNext(next);
        next.setPrev(prev);
      
        --size;
       
        tranverse_list_Display();	//展示链表
        backtranverse_list_Display();	//展示逆置链表
        
      }
    }
      public static void tranverse_list_Display()		//展示链表函数
      {
    	  System.out.print("链表为：");
  		for(Node n=list.getHead().getNext();n!=list.getTail();n=n.getNext())
  		{
  			System.out.printf("%d",n.getData());
  		}
  		System.out.printf("\n");
      }
      public static void backtranverse_list_Display()	//展示逆置链表函数
      {
    	  System.out.print("逆置链表为：");
  		for(Node n=list.getTail().getPrev();n!=list.getHead();n=n.getPrev())
  		{
  			System.out.printf("%d",n.getData());
  		}
  		System.out.printf("\n");
      }
      
}




