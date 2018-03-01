package iss.java.List;

/**
 * Created by Shibaorong on 2016/10/2.
 */
public class MyList {
    // two guards. Do not call remove() on them!!
    private static Node head;
    private static Node tail;
    private static int size;
    public static final Object obj=new Object();	//������̬object����obj
    static MyList list = new MyList();
    
    public MyList() {				//���캯��
    	
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
    public void insert(int _prevnumber, int data) {			//����ڵ㺯��
    	synchronized(obj){			//synchronized������
    		
    		System.out.println("Ҫ�����ֵΪ��"+data);
    		
    		Node _prev=new Node();_prev=list.getHead();		//����_prev�ڵ㣬����ʼ��Ϊͷ�ڵ�
    		for(int i=0;i<_prevnumber;i++)_prev=_prev.getNext();	//ʹ_prev�Ƶ�_prevnumber����Ӧ�Ľڵ���
    		
	        Node node = new Node().setData(data).setNext(_prev.getNext()).setPrev(_prev);		//����ڵ����
	        _prev.getNext().setPrev(node);
	        _prev.setNext(node);
	        
	        ++size;
	        
	        tranverse_list_Display();		//չʾ����
	        backtranverse_list_Display();	//չʾ��������
       
        }
    }

      public void remove(int targetnumber) {			//ɾ���ڵ㺯��
    	synchronized(obj){
        if (targetnumber == 0 || targetnumber == list.getSize()+2)
            throw new RuntimeException("DO NOT remove the head or tail node. They are guards.");
        
        Node target=new Node();target=list.getHead();		//����target�ڵ㣬����ʼ��Ϊͷ�ڵ�
        for(int i=0;i<targetnumber;i++)target=target.getNext();		//ʹtarget�ڵ��Ƶ�targetnumber����Ӧ�Ľڵ���
        
        System.out.println("Ҫɾ����ֵΪ��"+target.getData());
        
        Node prev = target.getPrev();		//ɾ���ڵ����
        Node next = target.getNext();
        prev.setNext(next);
        next.setPrev(prev);
      
        --size;
       
        tranverse_list_Display();	//չʾ����
        backtranverse_list_Display();	//չʾ��������
        
      }
    }
      public static void tranverse_list_Display()		//չʾ������
      {
    	  System.out.print("����Ϊ��");
  		for(Node n=list.getHead().getNext();n!=list.getTail();n=n.getNext())
  		{
  			System.out.printf("%d",n.getData());
  		}
  		System.out.printf("\n");
      }
      public static void backtranverse_list_Display()	//չʾ����������
      {
    	  System.out.print("��������Ϊ��");
  		for(Node n=list.getTail().getPrev();n!=list.getHead();n=n.getPrev())
  		{
  			System.out.printf("%d",n.getData());
  		}
  		System.out.printf("\n");
      }
      
}




