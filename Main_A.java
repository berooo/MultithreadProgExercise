package iss.java;
import java.util.Random;
import iss.java.List.*;


public class Main_A{

	static Node nodedata=new Node();	//创建nodedata节点
	public static final Object obj=new Object();
	public static int i=5;		//静态变量用来验证线程的有序性
	public static void set()	//set函数
	{
		nodedata.setData(new Random().nextInt(10));			//写入1-10的随机数
		System.out.println("写入的数为："+nodedata.getData());
		i++;
	}
	public static void get()	//get函数
	{
		System.out.println("读出的数为："+nodedata.getData());
		i--;
	}
	public static void main(String args[])throws InterruptedException{
		Thread ta=new Thread(){			//创建线程ta
				public void run()
				{
					System.out.println("ta线程 启动！");
					synchronized(obj){			//synchronized锁
						System.out.print("ta");
						set();
						System.out.println("i="+i);
						System.out.print("ta");
						get();
						System.out.println("i="+i);
					
					}
				}
		};
		Thread tb=new Thread(){			//创建线程tb
			public void run()
			{
				System.out.println("tb线程 启动！");
				synchronized(obj){				//synchronized锁
					System.out.print("tb");
					set();
					System.out.println("i="+i);
					System.out.print("tb");
					get();
					System.out.println("i="+i);
				
				}
			}
		};
		Thread tc=new Thread(){			//创建线程tc
			public void run(){
				System.out.println("tc线程 启动！");
				synchronized(obj){				//synchronized锁
					System.out.print("tc");
					set();
					System.out.println("i="+i);
					System.out.print("tc");
					get();
					System.out.println("i="+i);
				}
			}
		};
		Thread td=new Thread(){			//创建线程td
			public void run(){
				System.out.println("td线程 启动！");
				synchronized(obj){				//synchronized锁
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