class ChildThread implements Runnable
{
	String name;
	Thread t;
	ChildThread(String n)
	{
		name=n;
		t=new Thread(this,name);
		System.out.println("ChildThread:"+t);
		t.start();
	}
	public void run()
	{
		try
		{
			for(int i=3;i>0;i--)
			{
				System.out.println(name+":"+i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println("interrupted");
		}
		System.out.println("Exiting");
	}
}
class Alivejoin
{
	public static void main(String args[])
	{
		ChildThread c1=new ChildThread("one");
		ChildThread c2=new ChildThread("two");
		ChildThread c3=new ChildThread("three");
	System.out.println("Thread one isAlive:"+c1.t.isAlive());
	System.out.println("Thread two isAlive:"+c2.t.isAlive());
	System.out.println("Thread three isAlive:"+c3.t.isAlive());
	try
	{
		System.out.println("Threads waiting for compliation");
	c1.t.join();
	c2.t.join();
	c3.t.join();
	}
	catch(Exception e)
	{
		System.out.println("mainThread is interrupted");
	}
	System.out.println("Thread one isAlive:"+c1.t.isAlive());
	System.out.println("Thread two isAlive:"+c2.t.isAlive());
	System.out.println("Thread three isAlive:"+c3.t.isAlive());
	}
}
