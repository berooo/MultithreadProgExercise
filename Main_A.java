package iss.java;
import java.util.Random;
import iss.java.List.*;


public class Main_A{

	static Node nodedata=new Node();	//����nodedata�ڵ�
	public static final Object obj=new Object();
	public static int i=5;		//��̬����������֤�̵߳�������
	public static void set()	//set����
	{
		nodedata.setData(new Random().nextInt(10));			//д��1-10�������
		System.out.println("д�����Ϊ��"+nodedata.getData());
		i++;
	}
	public static void get()	//get����
	{
		System.out.println("��������Ϊ��"+nodedata.getData());
		i--;
	}
	public static void main(String args[])throws InterruptedException{
		Thread ta=new Thread(){			//�����߳�ta
				public void run()
				{
					System.out.println("ta�߳� ������");
					synchronized(obj){			//synchronized��
						System.out.print("ta");
						set();
						System.out.println("i="+i);
						System.out.print("ta");
						get();
						System.out.println("i="+i);
					
					}
				}
		};
		Thread tb=new Thread(){			//�����߳�tb
			public void run()
			{
				System.out.println("tb�߳� ������");
				synchronized(obj){				//synchronized��
					System.out.print("tb");
					set();
					System.out.println("i="+i);
					System.out.print("tb");
					get();
					System.out.println("i="+i);
				
				}
			}
		};
		Thread tc=new Thread(){			//�����߳�tc
			public void run(){
				System.out.println("tc�߳� ������");
				synchronized(obj){				//synchronized��
					System.out.print("tc");
					set();
					System.out.println("i="+i);
					System.out.print("tc");
					get();
					System.out.println("i="+i);
				}
			}
		};
		Thread td=new Thread(){			//�����߳�td
			public void run(){
				System.out.println("td�߳� ������");
				synchronized(obj){				//synchronized��
					System.out.print("td");
					set();
					System.out.println("i="+i);
					System.out.print("td");
					get();
					System.out.println("i="+i);
				}
			}
		};
		
		ta.start();			
		tb.start();			
		tc.start();			
		td.start();			
		
	}
}