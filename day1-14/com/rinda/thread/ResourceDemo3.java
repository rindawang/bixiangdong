/*package com.rinda.thread;

class Resource
{
	private String name;
	private String sex;
	private boolean flag = false;

	public synchronized void set(String name,String sex)
	{
		if(flag)
			try{this.wait();}catch(InterruptedException e){}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}

	public synchronized void out()
	{
		if(!flag)
			try{this.wait();}catch(InterruptedException e){}
		System.out.println(name+"...+...."+sex);
		flag = false;
		notify();
	}
}


// ‰»Î
class InputDemo3 implements Runnable
{
	Resource r ;
//	Object obj = new Object();
	InputDemo3(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			if(x==0)
			{
				r.set("mike","nan");
			}
			else
			{
				r.set("Lily","Female");
			}
			x = (x+1)%2;
		}
	}
}
class OutputDemo3 implements Runnable
{

	Resource r;
//	Object obj = new Object();
	OutputDemo3(Resource r)
	{
		this.r = r;
	}

	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}



class  ResourceDemo3
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();
		InputDemo3 in = new InputDemo3(r);
		OutputDemo3 out = new OutputDemo3(r);
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();
	}
}
*/