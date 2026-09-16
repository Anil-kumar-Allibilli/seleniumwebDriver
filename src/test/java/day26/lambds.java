package day26;

@FunctionalInterface
interface lambds 
{
	void show();
}

class check implements lambds
{
	public void show()
	{
		System.out.println("hi");
	}
}
//class Demo
//{
//	public static void main(String[] args) 
//	{
//		lambds obj = new check();
//		obj.show();
//	}
//}



// in above code we have only one method then why to have differenct class gain. then we can cna create same class in main class

class Demo
{
	public static void main(String[] args) 
	{
		lambds obj = () -> System.out.println("hi"); // here () representa show methhos as we have only one method, and -> represents lambda expression and code in show method
	}
}