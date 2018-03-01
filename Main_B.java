package iss.java;
import java.util.Random;
import iss.java.List.*;

/**
 * Created by ShiBaorong on 2016/10/2.
 */
class insertthread extends Thread{				//插入节点线程
	  private MyList list=new MyList();
	  public insertthread(MyList list){			//构造函数
		  this.list=list;
	  }
	  public void run(){			
		  list.insert(0, new Random().nextInt(10));	//在head节点后插入一个0-10的随机数
	  }
}
class removethread extends Thread{				//删除节点线程
	private MyList list=new MyList();
	public static final Object obj=new Object();
	public removethread(MyList list){			//构造函数
		  this.list=list;
	  }
	  public void run(){
		  if(list.getHead().getNext()==list.getTail())return;	//如果删除完毕，结束run()
		  synchronized(obj){	//加锁以保证不同的线程获得不同的target,以保护数据，保证删除正常进行
		  list.remove(1);	//这里1代表节点的序号，即head节点后的第一个节点
		 }
	  }

}
public class Main_B {
	
	  public static void main(String args[]) {
		MyList list=new MyList();
		
		insertthread i1=new insertthread(list);		//建立六个插入节点线程
		insertthread i2=new insertthread(list);
		insertthread i3=new insertthread(list);
		insertthread i4=new insertthread(list);
		insertthread i5=new insertthread(list);
		insertthread i6=new insertthread(list);
		
		removethread r1=new removethread(list);		//建立六个删除节点线程
		removethread r2=new removethread(list);
		removethread r3=new removethread(list);
		removethread r4=new removethread(list);
		removethread r5=new removethread(list);
		removethread r6=new removethread(list);
		
		i1.start();				//线程启动
		i2.start();
		i3.start();
		i4.start();
		i5.start();
		i6.start();
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		r6.start();
	    }	
}