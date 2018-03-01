package iss.java;
import java.util.Random;
import iss.java.List.*;

/**
 * Created by ShiBaorong on 2016/10/2.
 */
class insertthread extends Thread{				//����ڵ��߳�
	  private MyList list=new MyList();
	  public insertthread(MyList list){			//���캯��
		  this.list=list;
	  }
	  public void run(){			
		  list.insert(0, new Random().nextInt(10));	//��head�ڵ�����һ��0-10�������
	  }
}
class removethread extends Thread{				//ɾ���ڵ��߳�
	private MyList list=new MyList();
	public static final Object obj=new Object();
	public removethread(MyList list){			//���캯��
		  this.list=list;
	  }
	  public void run(){
		  if(list.getHead().getNext()==list.getTail())return;	//���ɾ����ϣ�����run()
		  synchronized(obj){	//�����Ա�֤��ͬ���̻߳�ò�ͬ��target,�Ա������ݣ���֤ɾ����������
		  list.remove(1);	//����1����ڵ����ţ���head�ڵ��ĵ�һ���ڵ�
		 }
	  }

}
public class Main_B {
	
	  public static void main(String args[]) {
		MyList list=new MyList();
		
		insertthread i1=new insertthread(list);		//������������ڵ��߳�
		insertthread i2=new insertthread(list);
		insertthread i3=new insertthread(list);
		insertthread i4=new insertthread(list);
		insertthread i5=new insertthread(list);
		insertthread i6=new insertthread(list);
		
		removethread r1=new removethread(list);		//��������ɾ���ڵ��߳�
		removethread r2=new removethread(list);
		removethread r3=new removethread(list);
		removethread r4=new removethread(list);
		removethread r5=new removethread(list);
		removethread r6=new removethread(list);
		
		i1.start();				//�߳�����
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